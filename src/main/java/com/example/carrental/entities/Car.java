package com.example.carrental.entities;

import com.example.carrental.enums.CarGroupName;
import com.example.carrental.enums.FuelType;
import com.example.carrental.enums.TransmissionType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Car {
    private String carId;
    private Brand brand;
    private FuelType fuelType;
    private CarGroupName groupName;
    private int seatingCapacity;
    private TransmissionType transmissionType;
    private String profileImgUrl;
    private String modelYear;
    private int totalAvailability;

}
