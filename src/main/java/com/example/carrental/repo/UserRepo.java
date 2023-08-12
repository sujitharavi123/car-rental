package com.example.carrental.repo;

import com.example.carrental.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {

    Optional<User> findByEmail(String s);

    Optional<User> findByPhoneNumber(String ph);

}
