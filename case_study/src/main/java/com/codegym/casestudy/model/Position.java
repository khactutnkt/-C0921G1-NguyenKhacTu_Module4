package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "division")
    private List<Employee> position;

    public Position() {
    }

    public Position(String name, List<Employee> position) {
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getPosition() {
        return position;
    }

    public void setPosition(List<Employee> position) {
        this.position = position;
    }
}
