package com.example.demo.Controller;

import com.example.demo.MyRepository.CarRepository;
import com.example.demo.MyRepository.ManufectRepository;
import com.example.demo.entity.Car;
import com.example.demo.entity.Manufect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    private CarRepository carRepository;
    private ManufectRepository manufectRepository;
    private List<Manufect> manufectList;

    @Autowired
    public MyController(CarRepository carRepository, ManufectRepository manufectRepository) {
        this.carRepository = carRepository;
        this.manufectRepository = manufectRepository;
        this.manufectList = new ArrayList<>();
    }

    public MyController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCar(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("Marx") String marx, @ModelAttribute("Engine") String engine,
                          @ModelAttribute("Manufect") String manufectName, Model model) {
        Manufect manufect = searchForManufect(manufectName);
        Car car = new Car(manufect, marx, engine);
        saveManufect(manufect);
        carRepository.save(car);
        model.addAttribute("cars", carRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addCar() {
        return "addCar";
    }

    @RequestMapping(value = "/get")
    public String addCar1() {
        String marx = "car";
        String engine = "2.5";
        String manufectName = "one";
        Manufect manufect = searchForManufect(manufectName);
        Car car = new Car(manufect, marx, engine);
        manufectRepository.save(manufect);
        carRepository.save(car);
        System.out.print(carRepository.findAll());
        return "index";
    }

    private Manufect searchForManufect(String manufectName) {
        if (getManufectList()) {
            for (Manufect i : manufectList) {
                if (i.getName().equals(manufectName)) {
                    return i;
                }
            }
        }
        return new Manufect(manufectName, new ArrayList<Car>());
    }

    private void saveManufect(Manufect manufect) {
        if (this.manufectList.contains(manufect)) {
            return;
        } else {
            manufectRepository.save(manufect);
            return;
        }
    }

    private boolean getManufectList() {
        try {
            this.manufectList = manufectRepository.findAll();
            if (manufectList.equals(null)) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }
}
