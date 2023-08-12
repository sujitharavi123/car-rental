package com.example.carrental.controller;

import com.example.carrental.dto.CarInputDTO;
import com.example.carrental.dto.CarOutputDTO;
import com.example.carrental.dto.UserInputDTO;
import com.example.carrental.dto.UserOutputDTO;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarOutputDTO> createCar(@RequestBody CarInputDTO input) {
        CarOutputDTO output = carService.createCar(input);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }
}
