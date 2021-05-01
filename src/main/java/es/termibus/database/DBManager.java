package es.termibus.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;


public class DBManager {
	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;

	// Singleton usage to instance DB once at a time
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	// Testing data
	
	public void preparedData() throws DBException {
		Cliente client1 = new Cliente("11111111A", "Antonio", "antonio@gmail.com", "1234");
		Cliente client2 = new Cliente("22222222B", "Paco", "paco@hotmail.com", "5678");
		Cliente client3 = new Cliente("33333333C", "Juanjo", "juanjo@gmail.com", "91011");

		Trip trip1 = new Trip(1234, 40, "21/03/2021", "Madrid");
		Trip trip2 = new Trip(5678, 60, "07/01/2021", "Barcelona");
		Trip trip3 = new Trip(91011, 70, "13/02/2021", "Sevilla");

		pushToDB(client1);
		pushToDB(client2);
		pushToDB(client3);
		
		pushToDB(trip1);
		pushToDB(trip2);
		pushToDB(trip3);
	}

	// Push object to DB
	
    public void pushObjToDB(Object object) {
        PersistenceManager pm = pmf.getPersistenceManager();
        pm.getFetchPlan().setMaxFetchDepth(4);
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            System.out.println("* Storing an object: " + object);
            pm.makePersistent(object);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("$ Error storing an object: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    // Push client to DB
    
    public void pushToDB(Cliente c) {
        DBManager.getInstance().pushObjToDB(c);
    }
    
    // Push trip to DB
    
    public void pushToDB(Trip t) {
        DBManager.getInstance().pushObjToDB(t);
    }
    
    // Push ticket to DB
    
    public void pushToDB(Ticket t) {
        DBManager.getInstance().pushObjToDB(t);
    }
    
    // Return a list of clients

	public List<Cliente> getClients() throws DBException {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Cliente> query = pm.newQuery("javax.jdo.query.SQL", "select * from " + "cliente");
		query.setClass(Cliente.class);

		List<Cliente> results = query.executeList();

		tx.commit();
		pm.close();
		return results;
	}

	// Exists client
	
	public boolean existsClient(Cliente client) throws DBException {

		boolean existe = false;
		List<Cliente> clientes = getClients();

		for (Cliente c : clientes) {
			if (c.getName().equals(client.getName())) {
				existe = true;
			}
		}
		return existe;
	}
	
	// Ticket booking

	public void bookATicket(String code, String date, String orig, String dest, float price) {
		pushToDB(new Ticket(code, date, orig, dest, price));
	}

	// Return a list of trips
	
	public List<Trip> getTrips() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Trip> trips = new ArrayList<Trip>();

		try {
			System.out.println("Check every trip");
			tx.begin();

			Extent<Trip> tripExtent = pm.getExtent(Trip.class, true);

			for (Trip trip : tripExtent) {

				Trip t = new Trip(trip.getBusID(), trip.getCost(), trip.getDate(), trip.getDestiny());

				trips.add(t);

			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("$ Error cant Check trips: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return trips;

	}

	// Get trips from a specific client
	
	public List<Trip> getClientTrips(int clientID) throws DBException {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		Query<Trip> query = pm.newQuery("javax.jdo.query.SQL", "SELECT * FROM trip where clientID='" + clientID + "'");
		query.setClass(Trip.class);
		List<Trip> conclusion = query.executeList();

		tx.commit();
		pm.close();
		return conclusion;
	}

	// Get a specific trip
	
	public List<Trip> getSelectedTrip(String destiny, Calendar date) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Trip> trips = new ArrayList<Trip>();
		try {
			System.out.println("* Checking trips");
			tx.begin();

			Extent<Trip> tripsExtent = pm.getExtent(Trip.class, true);

			for (Trip trip : tripsExtent) {
				Trip t = new Trip(trip.getBusID(), trip.getCost(), trip.getDate(), trip.getDestiny());

				int account1 = 0;
				int account2 = 0;

				if (!t.getDestiny().equals("")) {
					account1++;
					if (t.getDestiny().contains(destiny) || t.getDestiny().toLowerCase().contains(destiny)) {
						account2++;
					}
				}
				if (account1 == account2) {
					trips.add(t);
				}
				tx.commit();
			}
		} catch (Exception ex) {
			System.out.println("$ Error showing trips: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return trips;
	}
	
	// Return a list of tickets 
	
	public List<Ticket> getTickets() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		List<Ticket> tickets = new ArrayList<>();

		try {
			System.out.println("* Viewing the tickets");
			tx.begin();
			Extent<Ticket> e = pm.getExtent(Ticket.class, true);
			Iterator<Ticket> i = e.iterator();
			while (i.hasNext()) {
				Ticket t = (Ticket) i.next();

				pm.makeTransient(t.getCodigo());
				pm.makeTransient(t.getDate());
				pm.makeTransient(t.getOrigen());
				pm.makeTransient(t.getDestino());
				pm.makeTransient(t.getPrecio());

				pm.makeTransient(t); // 😐
				tickets.add(t);
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("$ Error viendo todos facturas: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return tickets;
	}
}