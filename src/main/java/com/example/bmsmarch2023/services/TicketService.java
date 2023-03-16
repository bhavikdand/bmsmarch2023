package com.example.bmsmarch2023.services;

import com.example.bmsmarch2023.exceptions.ShowDoesntExistsException;
import com.example.bmsmarch2023.models.*;
import com.example.bmsmarch2023.repositories.ShowRepository;
import com.example.bmsmarch2023.repositories.ShowSeatRepository;
import com.example.bmsmarch2023.exceptions.SeatNotAvailableException;
import com.example.bmsmarch2023.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository, ShowRepository showRepository, TicketRepository ticketRepository) {
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
    }

    /*
    Steps to follow in production
         1. Fetch list of seats to be booked
         2. Check if all the seats are available
         3. If any of the seats are unavailable, then throw Exception
         4. Lock the seats via select for update
         5. We need to check the status again because we will do it via DCL
         6. If all the seats are still available then only update status to LOCKED
         7. else throw exception
         8. generate the ticket

     */
//    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIds, long showId, long userId) throws SeatNotAvailableException, ShowDoesntExistsException {
        // 1. Read seats with select for update
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        // 2. Check if all the seats are available
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException(showSeat.getId() + " is not available");
            }
        }

        // 3. Update seat status to LOCKED
        for(ShowSeat showSeat: showSeats){
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

        // Generate ticket
        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        Optional<Show> show = showRepository.findById(showId);
        if(show.isEmpty()){
            throw new ShowDoesntExistsException("Show doesn't exists");
        }
        ticket.setShow(show.get());
        ticket.setTicketStatus(TicketStatus.PENDING);
        // TODO set all the other attributes of ticket



        return ticketRepository.save(ticket);
    }
}
