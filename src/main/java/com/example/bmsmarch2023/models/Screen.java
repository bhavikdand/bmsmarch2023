package com.example.bmsmarch2023.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "screens")
public class Screen  extends BaseModel{

    private String name;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "feature_oridnal")
    private List<Feature> features;

    @ManyToOne()
    private Theatre theatre;
}
