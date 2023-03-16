package com.example.bmsmarch2023.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Movie extends BaseModel{

    private String name;

}
