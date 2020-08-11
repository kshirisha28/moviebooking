package com.cg;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;

import com.cg.bookingmovie.dao.BookingDao;
import com.cg.bookingmovie.dao.TicketDao;
import com.cg.bookingmovie.entity.Booking;
import com.cg.bookingmovie.entity.Ticket;

import mockit.integration.junit4.JMockit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;




@SuppressWarnings("unused")
@RunWith(JMockit.class)

public class BookingServiceTest {
     @Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
    private BookingDao bookingdao;
	@Mock
	private TicketDao ticketdao;
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testDeleteBookingById() {
		Booking booking = new Booking();
		bookingdao.deleteById(1001);
		verify(bookingdao,times(1)).deleteById(1001);
	}
	
	
	@Test
	public void testgetAllTicket()
	{
		List<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(new Ticket());
		when(ticketdao.findAll()).thenReturn(ticketList);
		List<Ticket>result = ticketdao.findAll();
		assertEquals(1,ticketList.size());
	}
	@Test
	public void testDeleteTicketById()
	{
		Ticket ticket = new Ticket();
		ticketdao.deleteById(9001);
		verify(ticketdao,times(1)).deleteById(9001);
	}
	
	@Test
	public void testfindAllBooking() {
		List<Booking> bookingList = new ArrayList<Booking>();
		bookingList.add(new Booking());
		when(bookingdao.findAll()).thenReturn(bookingList);
		List<Booking> result = (List<Booking>) bookingdao.findAll();
		assertEquals(1, bookingList.size());
	}
//	@Test
//	public void testcreateBooking() {
//	Booking booking=new Booking(1005,2003,3003,"10/08/2020",6004,9003,250);
//		booking.setBookingId(1005);
//		booking.setMovieId(2002));
//		booking.setShowId(3003);
//		booking.setLocalDate("10/08/2020");
//		booking.setTransactionId(6004);
//	 booking.setTicketId(9003);
//	booking,setTotalCost(250.00);
//	bookingdao.save(booking);
//	}

	
}
