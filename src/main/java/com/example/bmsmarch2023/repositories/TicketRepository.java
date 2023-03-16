package com.example.bmsmarch2023.repositories;

import com.example.bmsmarch2023.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}
