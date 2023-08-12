package com.example.carrental.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {

    @Id
    private String id;

    private String userName;

    @Indexed(unique = true)
    private String email;

    private String phoneNumber;
}
