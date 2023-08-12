package com.example.carrental.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class City {
    private String id;
    private String code;
    private String name;
    private String description;
}
