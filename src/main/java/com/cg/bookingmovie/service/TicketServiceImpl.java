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
  TicketDao ticketDao;


	@Override
	public Ticket RetreiveTicket(int ticketId) throws TicketException {
		if(! ticketDao.existsById(ticketId))
		{
			throw new TicketException ("Id not found");
			
		}
		return ticketDao.findById(ticketId).get();
	
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketDao.findAll( );
	}

	@Override
	public Ticket deleteTicketById(int ticketId) throws TicketException {
	Ticket ticket= null;
		if(! ticketDao.existsById(ticketId))
		{
			throw new TicketException ("Id not found");
			
		}
		else
		{
			ticket=ticketDao.findById(ticketId).get();
			ticketDao.deleteById(ticketId);
		}
		return ticket;
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.saveAndFlush(ticket);
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
