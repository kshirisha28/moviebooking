package com.cg.bookingmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.bookingmovie.dao.TicketDao;

import com.cg.bookingmovie.entity.Ticket;
import com.cg.bookingmovie.exception.TicketException;



@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
  TicketDao ticketdao;


	@Override
	public Ticket RetreiveTicket(int ticketId) throws TicketException {
		if(! ticketdao.existsById(ticketId))
		{
			throw new TicketException ("Id not found");
			
		}
		return ticketdao.findById(ticketId).get();
	
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketdao.findAll( );
	}

	@Override
	public Ticket deleteTicketById(int ticketId) throws TicketException {
	Ticket ticket= null;
		if(! ticketdao.existsById(ticketId))
		{
			throw new TicketException ("Id not found");
			
		}
		else
		{
			ticket=ticketdao.findById(ticketId).get();
			ticketdao.deleteById(ticketId);
		}
		return ticket;
	}

//	@Override
//	public Ticket addTicket(Ticket ticket) throws TicketException {
//		// TODO Auto-generated method stub
//		return ticketdao.getOne(ticketId);
//		return null;
//	}
//
//	@Override
//	public Ticket showTicket(int ticketId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Ticket> getAllBookings(Ticket ticket) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean cancelBooking(int ticketId) throws TicketException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
	

}
