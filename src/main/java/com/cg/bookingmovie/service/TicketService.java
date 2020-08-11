package com.cg.bookingmovie.service;

import java.util.List;

import com.cg.bookingmovie.entity.Booking;
import com.cg.bookingmovie.entity.Ticket;
import com.cg.bookingmovie.exception.TicketException;


public interface TicketService  {

	


	public List<Ticket> getAllTickets();
	public Ticket RetreiveTicket(int ticketId) throws TicketException;
	public Ticket deleteTicketById(int ticketId) throws TicketException;
	public Ticket createTicket(Ticket ticket);
//	public Ticket addTicket(Ticket ticket) throws TicketException;
//	
//	public Ticket showTicket(int ticketId);
//    
//	public List<Ticket> getAllBookings(Ticket ticket);
//
//	public boolean cancelBooking(int ticketId) throws TicketException;
//}
}