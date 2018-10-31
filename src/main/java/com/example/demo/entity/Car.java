package com.example.demo.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufect_id", nullable = false)
    private Manufect manufect;

    @Column(name = "marx")
    private String marx;

    @Column(name = "engine")
    private String engine;

    public Car(Manufect manufect, String marx, String  engine) {
        this.manufect = manufect;
        this.marx = marx;
        this.engine = engine;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manufect getManufect() {
        return manufect;
    }

    public void setManufect(Manufect manufect) {
        this.manufect = manufect;
    }

    public String getMarx() {
        return marx;
    }

    public void setMarx(String marx) {
        this.marx = marx;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String  engine) {
        this.engine = engine;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, manufect, marx, engine);
    }


}
