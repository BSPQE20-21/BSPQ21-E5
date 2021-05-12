package teses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import es.termibus.database.DBManager;

public class testDB {

	private DBManager db;	
	
	private List<Ticket> tickets;	
	private List<Trip> trips;	
	private List<Cliente> clients;
	
	private Ticket t;
	private Trip tr;
	private Cliente c;
	
	
	@Test
	public void getTickets() {
		db = DBManager.getInstance();
		tickets = new ArrayList<Ticket>(db.getTickets());
		
		t = new Ticket(0, "21/03/2021", "Madrid", "13:00", 1234, 40);
		
		for (int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).equals(t)) {
				assertEquals(tickets.get(i), t); 
			}
		}
	}
	
	@Test
	public void getTrips() {
		db = DBManager.getInstance();
		trips = new ArrayList<Trip>(db.getTrips());
		
		tr = new Trip(1234, 40, "21/03/2021", "Madrid", "13:00");
		
		for (int i = 0; i < trips.size(); i++) {
			if(tickets.get(i).equals(tr)) {
				assertEquals(trips.get(i), tr);
			}
		}
	}
	
	@Test
	public void getClients() {
		db = DBManager.getInstance();
		clients = new ArrayList<Cliente>(db.getClients());
		
		c = new Cliente("11111111A", "Antonio", "antonio@gmail.com", "1234");
		
		for (int i = 0; i < clients.size(); i++) {
			if(clients.get(i).equals(c)) {
				assertEquals(clients.get(i), c);
			}
		}
	}
}
