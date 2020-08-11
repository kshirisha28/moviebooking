package com.cg.bookingmovie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineMovieBookingModuleApplication;
import com.cg.bookingmovie.entity.Booking;

import com.cg.bookingmovie.entity.Ticket;
import com.cg.bookingmovie.exception.BookingException;
import com.cg.bookingmovie.service.BookingService;
import com.cg.bookingmovie.service.BookingServiceImpl;




@RestController
@RequestMapping("/booking")
public class BookingContoller {

		
	@Autowired
	BookingService bookingService;

	Logger logger = LoggerFactory.getLogger(OnlineMovieBookingModuleApplication.class);
	String msg;
	

	@GetMapping("booking")
	public ResponseEntity<List<Booking>> findAllBooking() throws BookingException
	{
		msg = "fetching the results of booking:";
		logger.info(msg);
		List<Booking> list = bookingService.findAllBooking();
		ResponseEntity<List<Booking>>  rt = new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
		return rt;
			}
	
	@GetMapping("booking/{id}")
	public ResponseEntity<Booking> findAllBookingId(@PathVariable("id")  int id) throws BookingException 	{
		msg = "fetching the results of booking by id:";
		logger.info(msg);
		
		Booking  bookings = bookingService.findAllBookingId(id);
		   ResponseEntity<Booking>  tr = new ResponseEntity<>(bookings,HttpStatus.OK);
		   return tr;
		
	}
	@PostMapping("booking/ticket/{id}")
	public ResponseEntity<Booking> createBooking(@PathVariable("id") int ticketId ,@RequestBody Booking booking) throws BookingException
	{
		msg = "adding the booking:";
		logger.info(msg);
		Ticket tick = new Ticket();
		tick.setTicketId(ticketId);
	
		booking.setTicket(tick);
		
		Booking book =bookingService.createBooking(booking);
		ResponseEntity<Booking>  re = new ResponseEntity<Booking>(book,HttpStatus.OK);

		return re;
	}
	
	@DeleteMapping("booking/{id}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("id") int bookingId) throws BookingException
	{
		msg = "deleting the booking by id:";
		logger.info(msg);
		ResponseEntity<Booking>  rt = null;
		
		
		Booking re = bookingService.deleteBookingById(bookingId);
		rt= new ResponseEntity<Booking>(re,HttpStatus.OK);
		
		return rt;
	}
	@PutMapping("booking/bookingId/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") int bookingId,@RequestBody Booking booking) throws BookingException
	{
		msg = "updating  booking:";
		logger.info(msg);
		booking.setMovieId(booking.getMovieId());
		booking.setShowId(booking.getShowId());
		booking.setBookingDate(booking.getBookingDate());
		booking.setTransactionId(booking.getTransactionId());
		booking.setTotalCost(booking.getTotalCost());
		
		Booking book =bookingService.updateBooking(bookingId, booking);
		ResponseEntity<Booking>  re = new ResponseEntity<Booking>(book,HttpStatus.OK);

		return re;
	}
}
