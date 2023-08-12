package com.example.carrental.service;

import com.example.carrental.dto.CarInputDTO;
import com.example.carrental.dto.CarOutputDTO;

public interface CarService {
    CarOutputDTO createCar(CarInputDTO carInputDTO);
}
