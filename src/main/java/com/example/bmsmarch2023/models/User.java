package com.example.bmsmarch2023.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseModel {
    private String email;
}