package com.example.carrental.service;

import com.example.carrental.dto.UserInputDTO;
import com.example.carrental.dto.UserOutputDTO;

public interface UserService {
    UserOutputDTO createUser(UserInputDTO input);

    UserOutputDTO getUserById(String id);
}
