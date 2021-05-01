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
		Ticket ticket = new Ticket("BM1", "12/02/21, 12:00", "Bilbao", "Madrid", 14f);
		assertEquals(ticket.getCodigo(),"BM1");	
		}

	@Test
	public void testGetDate() {
		Ticket ticket = new Ticket("001", "12/02/21, 12:00", "Bilbao", "Madrid", 14f);
		assertEquals(ticket.getDate(),"12/02/21, 12:00");	
		}
	
	@Test
	public void testGetOrigen() {
		Ticket ticket = new Ticket("001", "12/02/21, 12:00", "Bilbao", "Madrid", 14f);
		assertEquals(ticket.getOrigen(),"Bilbao");	
		}
	
	@Test
	public void testGetDestino() {
		Ticket ticket = new Ticket("001", "12/02/21, 12:00", "Bilbao", "Madrid", 14f);
		assertEquals(ticket.getDestino(),"Madrid");	
		}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetPrecio() {
		Ticket ticket = new Ticket("001", "12/02/21, 12:00", "Bilbao", "Madrid", 14f);
		assertEquals(ticket.getPrecio(), 14f); 
		}
}