package com.example.carrental.service.impl;

import com.example.carrental.dto.CarInputDTO;
import com.example.carrental.dto.CarOutputDTO;
import com.example.carrental.entities.Car;
import com.example.carrental.repo.CarRepo;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final ModelMapper modelMapper;
    private final CarRepo carRepo;

    @Override
    public CarOutputDTO createCar(CarInputDTO carInputDTO) {
        if (ObjectUtils.isEmpty(carInputDTO)) {
            throw new IllegalArgumentException("Invalid data");
        }
        Car car = modelMapper.map(carInputDTO, Car.class);
        car.setCarId(UUID.randomUUID().toString());
        carRepo.save(car);
        return modelMapper.map(car, CarOutputDTO.class);
    }
}
