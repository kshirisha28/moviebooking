package com.cg.bookingmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookingmovie.entity.Seat;
import com.cg.bookingmovie.exception.BookingException;
import com.cg.bookingmovie.service.BookingService;
import com.cg.bookingmovie.service.SeatService;

@RestController
public class SeatContoller {
	
	
	@Autowired
	SeatService seatService;
	@GetMapping("seat")
	public ResponseEntity<List<Seat>> findAllSeat() throws BookingException
	{
		List<Seat> list = seatService.findAllSeat();
		ResponseEntity<List<Seat>>  rt = new ResponseEntity<List<Seat>>(list,HttpStatus.OK);
		return rt;
			}

}
