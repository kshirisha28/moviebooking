package com.cg.bookingmovie.service;

import java.util.List;

import com.cg.bookingmovie.entity.Booking;

import com.cg.bookingmovie.exception.BookingException;






public interface BookingService 
{
//public List<Seat> chooseSeats(List<Integer> seatIds);
	
	//public double calculateTotalCost(List<Seat> seats);
	
	//public Payment choosePaymentMethod(Payment payment);

	//public void calculateTotalCost(List<com.cg.bookingmovie.controller.Seat> seats);	
	
	public List<Booking>  findAllBooking() throws BookingException;
	public Booking  findAllBookingId(int bookingId) throws BookingException;
	public Booking deleteBookingById(int bookingId) throws BookingException;
	public Booking updateBooking(int bookingId, Booking booking) throws BookingException;
	public Booking createBooking(Booking booking);
	

}
