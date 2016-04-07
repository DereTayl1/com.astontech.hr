package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by deretayl1 on 4/5/2016.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private Integer year;
    private String licensePlate;
    private String VIN;
    private String color;
    private String vehicleModelName;


    public Vehicle(){}


    public Vehicle(Integer year,
                   String licensePlate,
                   String VIN,
                   String color){
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVIN(VIN);
        this.setColor(color);
    }



    // region GET & SET

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    // endregion
}
