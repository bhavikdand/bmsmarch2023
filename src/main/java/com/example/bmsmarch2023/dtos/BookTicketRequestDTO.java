package com.example.bmsmarch2023.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Long> showSeatIds;
    private Long showId;

    private Long userId;
}
