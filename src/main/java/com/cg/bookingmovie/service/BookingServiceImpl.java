package com.cg.bookingmovie.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.cg.bookingmovie.dao.BookingDao;
import com.cg.bookingmovie.entity.Booking;
import com.cg.bookingmovie.entity.Payment;
import com.cg.bookingmovie.entity.Seat;
import com.cg.bookingmovie.exception.BookingException;



@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
    BookingDao bookingdao;
	
  //  List<Seat> seats;
	
//	@Autowired
//	RestTemplate rt;

//	@Override
//	public List<Seat> chooseSeats(List<Integer> seatIds) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public double calculateTotalCost(List<Seat> seats) {
//		// TODO Auto-generated method stub
////	return 0;
//		return seats.stream().mapToDouble(s->s.getSeatPrice()).sum();
//	}
//	

//	@Override
//	public Payment choosePaymentMethod(Payment payment) {
//		// TODO Auto-generated method stub
//		//return null;
//		return payment;
//	}
//
//
//	@Override
//	public void calculateTotalCost(List<com.cg.bookingmovie.controller.Seat> seats) {
//		// TODO Auto-generated method stub
//		
//		//return seats.stream().mapToDouble(s->s.getSeatPrice()).sum();
//	}


	@Override
	public List<Booking> findAllBooking() throws BookingException {
		
	return bookingdao.findAll();
	}

	@Override
	public Booking findAllBookingId(int bookingId) throws BookingException {
		// TODO Auto-generated method stub
		if(! bookingdao.existsById(bookingId))
		{
			throw new BookingException ("Id not found");
			
		}
		return bookingdao.findById(bookingId).get();
		}


	@Override
	public Booking deleteBookingById(int bookingId) throws BookingException {
		Booking booking = null;
		
		if(! bookingdao.existsById(bookingId))
		{
			throw new BookingException ("Id not found");
			
		}
		else
		{
			booking=bookingdao.findById(bookingId).get();
			bookingdao.deleteById(bookingId);
		}
		return booking;
	}

	@Override
	public Booking updateBooking(int bookingId, Booking booking) throws BookingException {
		// TODO Auto-generated method stub
		if(! bookingdao.existsById(bookingId))
		{
			throw new BookingException ("Id not found");
			
		}
		return bookingdao.saveAndFlush(booking);
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingdao.saveAndFlush(booking);
	}
	}


	
	
	