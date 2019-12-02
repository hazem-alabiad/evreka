package com.evreka.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private long id;

    private String plate;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<NavigationRecord> navigationRecords;

    ///////// These are additional attributes that were not mentioned in the Classes in the assignment paper /////////
    private String name;

    ///////// Driver should be put in a separate class however, considering the simplicity of this assignment it was considered as an attribute of Vehicle class /////////
    private String driver;

    public Vehicle(String plate, String name, String driver) {
        this.plate = plate;
        this.name = name;
        this.driver = driver;
    }

    public Vehicle() {

    }

    public long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public List<NavigationRecord> getNavigationRecords() {
        return navigationRecords;
    }

    public void setNavigationRecords(List<NavigationRecord> navigationRecords) {
        this.navigationRecords = navigationRecords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
