package com.cg.bookingmovie.dao;

//import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookingmovie.entity.Ticket;




@Repository
public interface TicketDao extends JpaRepository<Ticket,Integer>{
	// Object getTicketByDateTimeAndTicketId(LocalDateTime dateTime, int ticketId);

}
