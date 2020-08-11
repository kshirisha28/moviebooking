 package com.cg.bookingmovie.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="ticketmoduletbl")
public class Ticket {
	@Id
	@Column(name="ticketId")
	private int ticketId;
	@Column(name="noOfSeats")
	private int noOfSeats;
	@Column(name="seatName",length=15)
    private String seatName;
	@Column(name="screenName",length=15)
	private String screenName;
 
// 
//    @OneToOne
//     private Booking booking;
	@OneToMany(mappedBy="ticket")
	@JsonIgnore
	
	private List<Booking> booking = new ArrayList<>();

	public int getTicketId() {
		return ticketId;
	}


	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


	public int getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public String getSeatName() {
		return seatName;
	}


	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}





	public Ticket(int ticketId, int noOfSeats, String seatName, String screenName, List<Booking> booking) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatName = seatName;
		this.screenName = screenName;
		this.booking = booking;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}


	public Ticket() {
		super();
	}
	
    


}