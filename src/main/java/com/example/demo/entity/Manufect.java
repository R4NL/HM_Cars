package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Manufect")
public class Manufect {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "manufect")
    private List<Car> carList;

    public Manufect(String name, List<Car> carList) {
        this.name = name;
        this.carList = carList;
    }

    public Manufect() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufect manufect = (Manufect) o;
        return Objects.equals(id, manufect.id) &&
                Objects.equals(name, manufect.name) &&
                Objects.equals(carList, manufect.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, carList);
    }


}
