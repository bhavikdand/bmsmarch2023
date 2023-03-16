package com.example.bmsmarch2023.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SeatTypeShow extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    @ManyToOne
    private Show show;
    private double price;
}
