package com.evreka.Entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Entity
public class NavigationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "navRec_id")
    private long id;

    @ManyToOne
    private Vehicle vehicle;

    private Date dateTime;

    private float latitude;

    private float longitude;

    ///////// These are additional attributes that were not mentioned in the Classes in the assignment paper /////////
    private String name;

    private String status;

    private String  performance;

    public NavigationRecord(Vehicle vehicle, Date dateTime, float latitude, float longitude, String name, String status, String performance) {
        this.vehicle = vehicle;
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.status = status;
        this.performance = performance;
    }

    public NavigationRecord() {

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(getDateTime());
    }

    public boolean isLastTwoDays(){
        Date nowDate = new Date();
        long differenceInHours = TimeUnit.HOURS.convert(nowDate.getTime() -  getDateTime().getTime(), TimeUnit.MILLISECONDS);
        return differenceInHours <= 48;
    }
}
