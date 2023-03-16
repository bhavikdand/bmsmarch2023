package com.example.bmsmarch2023.dtos;

import com.example.bmsmarch2023.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private Response response;
    private Ticket ticket;
}
