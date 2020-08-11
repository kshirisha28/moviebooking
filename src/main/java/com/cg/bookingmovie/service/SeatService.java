package com.cg.bookingmovie.service;

import java.util.List;

import com.cg.bookingmovie.entity.Booking;
import com.cg.bookingmovie.entity.Seat;
import com.cg.bookingmovie.exception.BookingException;

public interface SeatService {

	public List<Seat>  findAllSeat() throws BookingException;

}
