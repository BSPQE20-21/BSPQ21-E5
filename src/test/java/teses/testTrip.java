package teses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.termibus.data.*;

public class testTrip {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBusID() {
		Trip trip = new Trip(001, 40, "21/03/2021","Madrid","12:00");
		assertEquals(trip.getBusID(),001);	
		}

	@Test
	public void testGetCost() {
		Trip trip = new Trip(001, 40, "21/03/2021","Madrid","12:00");
		assertEquals(trip.getCost(),40);	
		}
	
	@Test
	public void testGetDate() {
		Trip trip = new Trip(001, 40, "21/03/2021","Madrid","12:00");
		assertEquals(trip.getDate(),"21/03/2021");	
		}
	
	@Test
	public void testGetDestiny() {
		Trip trip = new Trip(001, 40, "21/03/2021","Madrid","12:00");
		assertEquals(trip.getDestiny(),"Madrid");	
		}
	
	@Test
	public void testGetHour() {
		Trip trip = new Trip(001, 40, "21/03/2021","Madrid","12:00");
		assertEquals(trip.getHour(),"12:00");	
		}
}