package com.example.bmsmarch2023.repositories;

import com.example.bmsmarch2023.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);

    public ShowSeat save(ShowSeat showSeat);
    //If the showSeat object has id, save will update the object in DB
    //Else save will insert data into DB for the first time
}
