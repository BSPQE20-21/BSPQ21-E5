package teses;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.termibus.data.*;

public class testTicket {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCodigo() {
		Ticket ticket = new Ticket(001, "12/02/21","Madrid", "13:00",1232, 14);
		assertEquals(ticket.getCodigo(),001);	
		}

	@Test
	public void testGetDate() {
		Ticket ticket = new Ticket(001, "12/02/21","Madrid", "13:00",1232, 14);
		assertEquals(ticket.getDate(),"12/02/21");	
		}
	
	@Test
	public void testGetHour() {
		Ticket ticket = new Ticket(001, "12/02/21","Madrid", "13:00",1232, 14);
		assertEquals(ticket.getHour(),"13:00");	
		}
	
	@Test
	public void testGetDestino() {
		Ticket ticket = new Ticket(001, "12/02/21","Madrid", "13:00",1232, 14);
		assertEquals(ticket.getDestino(),"Madrid");	
		}
	
	@Test
	public void testGetPrecio() {
		Ticket ticket = new Ticket(001, "12/02/21","Madrid", "13:00",1232,  14);
		assertEquals(ticket.getPrecio(), 14); 
		}
}