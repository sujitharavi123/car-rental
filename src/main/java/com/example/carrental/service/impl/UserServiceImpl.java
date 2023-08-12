package com.example.carrental.service.impl;

import com.example.carrental.dto.UserInputDTO;
import com.example.carrental.dto.UserOutputDTO;
import com.example.carrental.entities.User;
import com.example.carrental.exception.AlreadyExistsException;
import com.example.carrental.exception.NotFoundException;
import com.example.carrental.repo.UserRepo;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public UserOutputDTO createUser(UserInputDTO input) {
        if (!StringUtils.hasText(input.getEmail())) {
            throw new IllegalArgumentException("EMAIL_IS_MANDATORY");
        }
        if (!StringUtils.hasText(input.getPhoneNumber())) {
            throw new IllegalArgumentException("PHONE_NUMBER_IS_MANDATORY");
        }
        if (!StringUtils.hasText(input.getUserName())) {
            throw new IllegalArgumentException("NAME_IS_MANDATORY");
        }

        Optional<User> optionalUserEmail = userRepo.findByEmail(input.getEmail());

        if (optionalUserEmail.isPresent()) {
            throw new AlreadyExistsException("Email already exists");
        }

        Optional<User> optionalUserPhNum = userRepo.findByPhoneNumber(input.getPhoneNumber());

        if (optionalUserPhNum.isPresent()) {
            throw new AlreadyExistsException("Phone number already exists");
        }

        User user = modelMapper.map(input, User.class);
        user.setId(UUID.randomUUID().toString());
        userRepo.save(user);

        return modelMapper.map(user, UserOutputDTO.class);
    }

    @Override
    public UserOutputDTO getUserById(String id) {
        if (!StringUtils.hasText(id)) {
            throw new IllegalArgumentException("ID_IS_MANDATORY");
        }

        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isEmpty()){
            throw new NotFoundException("User not found");
        }

        return modelMapper.map(optionalUser.get(), UserOutputDTO.class);

    }
}
