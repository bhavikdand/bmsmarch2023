package com.example.bmsmarch2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
public class City extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
}
