package com.example.bmsmarch2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

//    @Getter
//    @Setter  //Add this annotation on a attribute, if you want to have getters/setters only for that attribute
    private String name;

    private String address;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
}
