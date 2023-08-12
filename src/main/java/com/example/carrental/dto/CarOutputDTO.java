package com.example.carrental.dto;

import com.example.carrental.entities.Brand;
import com.example.carrental.enums.CarGroupName;
import com.example.carrental.enums.FuelType;
import com.example.carrental.enums.TransmissionType;
import lombok.Data;

@Data
public class CarOutputDTO {
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
