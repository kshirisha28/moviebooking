package com.cg.bookingmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookingmovie.dao.SeatDao;
import com.cg.bookingmovie.entity.Seat;
import com.cg.bookingmovie.exception.BookingException;
@Service
public class SeatServiceImpl implements SeatService{
	@Autowired
    SeatDao seatdao;

	@Override
	public List<Seat> findAllSeat() throws BookingException {
		// TODO Auto-generated method stub
		return seatdao.findAll();
	}
	
}
