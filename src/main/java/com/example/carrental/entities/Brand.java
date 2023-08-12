package com.example.carrental.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Brand {
    private String id;
    private String name;
    private String description;
    private String logo;
}
