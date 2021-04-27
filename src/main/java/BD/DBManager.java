package BD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import Classes.Cliente;
import Classes.Ticket;
import Classes.Trip;

public class DBManager {
	// INSTALACION DE DATOS
	public void preparedData() throws DBException {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Cliente client1 = new Cliente("Antonio", "antonio@gmail.com", "1234");
			pm.makePersistent(client1);
			Cliente client2 = new Cliente("Paco", "paco@hotmail.com", "5678");
			pm.makePersistent(client2);
			Cliente client3 = new Cliente("Juanjo", "juanjo@gmail.com", "91011");
			pm.makePersistent(client3);

			tx.begin();
			Trip trip1 = new Trip("Madrid", "21/03/2021", 1, 40);
			pm.makePersistent(trip1);
			Trip trip2 = new Trip("Barcelona", "01/07/2021", 2,  60);
			pm.makePersistent(trip2);
			Trip trip3 = new Trip("Madrid", "13/02/2021", 3, 70);
			pm.makePersistent(trip3);
		
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	// LISTAR ClienteS DE BD
	public List<Cliente> listarClientes() throws DBException {
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

	public boolean exiteCliente(Cliente Cliente) throws DBException {

		boolean existe = false;
		List<Cliente> clientes = listarClientes();

		for (Cliente client : clientes) {
			if (client.getName().equals(Cliente.getName())) {
				existe = true;
			}
		}

		return existe;

	}

	// INSERTAR Cliente
	public void insertarCliente(Cliente client) throws DBException {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			pm.makePersistent(client);

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}

	public Ticket bookATicketaso(Cliente client) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		return null;

	}

	// Create a new Trip
	public void insertarTrip(Trip trip) throws DBException {

		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			pm.makePersistent(trip);
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

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

				Trip t = new Trip(trip.getDestiny(), trip.getDate(), trip.getBusID(), trip.getCost());

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
	
	

	public List<Trip> getSelectedTrip(String destiny, Calendar date ){
			  PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			  PersistenceManager pm = pmf.getPersistenceManager();
			  Transaction tx = pm.currentTransaction();

	          List<Trip> trips = new ArrayList<Trip>();
	          try {
	                System.out.println("* Checking trips");
	                tx.begin();

	                Extent<Trip> tripsExtent = pm.getExtent(Trip.class, true);

	                for (Trip trip : tripsExtent) {

	                		Trip t = new Trip(trip.getDestiny(), trip.getDate(), trip.getBusID(), trip.getCost());

	                    	  
	     
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
	                System.out.println("$ Error viendo todos Anuncios: " + ex.getMessage());
	            } finally {
	                if (tx != null && tx.isActive()) {
	                    tx.rollback();
	                }

	                pm.close();
	            }
		  
		    return trips;
	          }
		  
}

