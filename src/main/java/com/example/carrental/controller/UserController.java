package com.example.carrental.controller;


import com.example.carrental.dto.UserInputDTO;
import com.example.carrental.dto.UserOutputDTO;
import com.example.carrental.exception.AlreadyExistsException;
import com.example.carrental.exception.ErrorResponse;
import com.example.carrental.exception.NotFoundException;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO userInput) {
        UserOutputDTO output = userService.createUser(userInput);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutputDTO> getUserById(@PathVariable String id) {
        UserOutputDTO output = userService.getUserById(id);
        return new ResponseEntity<>(output, HttpStatus.FOUND);
    }

}
