package com.cg.bookingmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookingmovie.entity.Ticket;
import com.cg.bookingmovie.exception.TicketException;
import com.cg.bookingmovie.service.TicketService;



@RestController
public class TicketContoller {

	@Autowired
TicketService ticketService;
	
	@GetMapping("ticket")
	public ResponseEntity<List<Ticket>> getAllTickets() 
	{
		List<Ticket> list = ticketService.getAllTickets();
		ResponseEntity<List<Ticket>>  rt = new ResponseEntity<List<Ticket>>(list,HttpStatus.OK);
		return rt;
			}
	
	@GetMapping("ticket/{id}")
	public ResponseEntity<Ticket> findAllTicketId(@PathVariable("id")  int id) throws TicketException 	{
	Ticket tic = ticketService.RetreiveTicket(id);
		   ResponseEntity<Ticket>  tr = new ResponseEntity<>(tic,HttpStatus.OK);
		   return tr;
		}

	@DeleteMapping("ticket/{id}")
	public ResponseEntity<Ticket> deleteTicketById(@PathVariable("id") int ticketId) throws TicketException
	{

		ResponseEntity<Ticket>  rt = null;
		Ticket ticket = ticketService.deleteTicketById(ticketId);
		rt= new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
		
		return rt;
	}
	@PostMapping("ticket")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) 
	{
		ticket.setTicketId(ticket.getTicketId());
		ticket.setNoOfSeats(ticket.getNoOfSeats());
		ticket.setSeatName(ticket.getSeatName());
		ticket.setScreenName(ticket.getScreenName());
		
	Ticket tickk = ticketService.createTicket(ticket);
		ResponseEntity<Ticket>  re = new ResponseEntity<Ticket>(tickk,HttpStatus.OK);
            return re;
	}
}
