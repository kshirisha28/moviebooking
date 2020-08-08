package com.cg.bookingmovie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookingmovie.entity.Seat;


@Repository
public interface SeatDao  extends JpaRepository<Seat,Integer>{

}
