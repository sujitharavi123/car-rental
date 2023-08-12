package com.example.carrental.repo;

import com.example.carrental.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepo extends MongoRepository<Car, String> {
}
