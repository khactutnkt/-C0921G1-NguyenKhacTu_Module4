package com.codegym.casestudy.model;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String description;
    private Double pollArea;
    private Integer numberOfFloor;

    @ManyToOne(targetEntity = ServiceType.class)
    private ServiceType serviceType;

    @ManyToOne(targetEntity = RentType.class)
    private RentType rentType;

    public Service() {
    }

    public Service(String name, Integer area, Double cost, Integer maxPeople, String standardRoom, String description, Double pollArea, Integer numberOfFloor, ServiceType serviceType, RentType rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.pollArea = pollArea;
        this.numberOfFloor = numberOfFloor;
        this.serviceType = serviceType;
        this.rentType = rentType;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPollArea() {
        return pollArea;
    }

    public void setPollArea(Double pollArea) {
        this.pollArea = pollArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}