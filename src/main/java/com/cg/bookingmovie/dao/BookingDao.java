package com.cg.bookingmovie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookingmovie.entity.Booking;



@Repository
public interface BookingDao extends JpaRepository<Booking,Integer> {

}
