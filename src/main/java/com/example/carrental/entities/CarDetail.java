package com.example.carrental.entities;

import lombok.Data;

@Data
public class CarDetail extends Car{

    private String id;
    private String regNo;
    private City city;
    private float totalNoOfKmsRan;
    private Location location;
    private Pricing pricing;
}
