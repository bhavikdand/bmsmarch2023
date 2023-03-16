package com.example.bmsmarch2023.controllers;

import com.example.bmsmarch2023.dtos.BookTicketRequestDTO;
import com.example.bmsmarch2023.dtos.BookTicketResponseDTO;
import com.example.bmsmarch2023.dtos.Response;
import com.example.bmsmarch2023.dtos.ResponseStatus;
import com.example.bmsmarch2023.exceptions.SeatNotAvailableException;
import com.example.bmsmarch2023.exceptions.ShowDoesntExistsException;
import com.example.bmsmarch2023.models.Ticket;
import com.example.bmsmarch2023.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        try {
            Ticket ticket = ticketService.bookTicket(request.getShowSeatIds(), request.getShowId(), request.getUserId());
            Response successResponse = new Response();
            successResponse.setStatus(ResponseStatus.SUCCESS);
            successResponse.setMessage("Ticket generated successfully");
            BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
            responseDTO.setResponse(successResponse);
            responseDTO.setTicket(ticket);
            return responseDTO;
        } catch (SeatNotAvailableException | ShowDoesntExistsException e) {
            Response errResponse = new Response();
            errResponse.setStatus(ResponseStatus.FAILED);
            errResponse.setMessage(e.getMessage());
            BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
            responseDTO.setResponse(errResponse);
            return responseDTO;
        }

    }
}
