package com.example.bmsmarch2023.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private String name;
    private int row;
    private int col;


    @ManyToOne
    private Screen screen;
}
