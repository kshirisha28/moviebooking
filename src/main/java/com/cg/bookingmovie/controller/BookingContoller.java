package com.cg.bookingmovie.controller;

import java.util.List;

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

import com.cg.bookingmovie.entity.Booking;
import com.cg.bookingmovie.entity.Payment;
import com.cg.bookingmovie.exception.BookingException;
import com.cg.bookingmovie.service.BookingService;
import com.cg.bookingmovie.service.BookingServiceImpl;




@RestController
@RequestMapping("/booking")
public class BookingContoller {

		
	@Autowired
	BookingService bookingService;
//		@GetMapping("/seats")	
//		public ResponseEntity<List<Seat>> calculateTotalCost(@RequestBody List<Seat> seats){
//			bookingService.calculateTotalCost(seats);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
		
//		@PutMapping("/choose/seats")	
//		public ResponseEntity<List<Seat>> chooseSeats(@RequestBody List<Integer> seatIds){
//		
//			return new ResponseEntity<>(service.chooseSeats(seatIds),HttpStatus.OK);
//		}
//		
//		@PostMapping("/payment")
//		public ResponseEntity<Payment> choosePaymentMethod(Payment payment) {
//			return new ResponseEntity<>(bookingService.choosePaymentMethod(payment),HttpStatus.OK);
//		}
//		

	

	@GetMapping("booking")
	public ResponseEntity<List<Booking>> findAllBooking() throws BookingException
	{
		List<Booking> list = bookingService.findAllBooking();
		ResponseEntity<List<Booking>>  rt = new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
		return rt;
			}
	
	@GetMapping("booking/{id}")
	public ResponseEntity<Booking> findAllBookingId(@PathVariable("id")  int id) throws BookingException 	{
		Booking  bookings = bookingService.findAllBookingId(id);
		   ResponseEntity<Booking>  tr = new ResponseEntity<>(bookings,HttpStatus.OK);
		   return tr;
		
	}
//	@PostMapping("booking/{id}")
//	public ResponseEntity<Booking> createBooking(@PathVariable("id") ,@RequestBody Booking booking) throws BookingException
//	{
//		Ticket ticket = new Ticket();
//		ticket.setTicketId(ticketId);
//		ticket.set
//		booking.setTicket(ticket);
//		
//		Ticket tic =bookingService.createBooking(booking);
//		ResponseEntity<Booking>  re = new ResponseEntity<Booking>(tic,HttpStatus.OK);
//
//		return re;
//	}
	
	@DeleteMapping("booking/{id}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("id") int bookingId) throws BookingException
	{

		ResponseEntity<Booking>  rt = null;
		
		
		Booking re = bookingService.deleteBookingById(bookingId);
		rt= new ResponseEntity<Booking>(re,HttpStatus.OK);
		
		return rt;
	}
	@PutMapping("booking/bookingId/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") int bookingId,@RequestBody Booking booking) throws BookingException
	{
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
