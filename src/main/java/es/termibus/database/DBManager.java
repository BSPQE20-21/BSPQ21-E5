package es.termibus.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.termibus.client.ClienteClient;
import es.termibus.client.TripClient;
import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;


public class DBManager {
	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	
	private static Logger log = Logger.getLogger(DBManager.class.getName());

	/**
	 * Singleton ussage to instantiate the DB once at a time
	 *
	 */
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	/**
	 * Example data to work with in the UI
	 * @throws DBException
	 */
	
	public void preparedData() throws DBException {
		Cliente client1 = new Cliente("11111111A", "Antonio", "antonio@gmail.com", "1234");
		Cliente client2 = new Cliente("22222222B", "Paco", "paco@hotmail.com", "5678");
		Cliente client3 = new Cliente("33333333C", "Juanjo", "juanjo@gmail.com", "91011");

		Trip trip1 = new Trip(1234, 40, "21/03/2021", "Madrid", "13:00");
		Trip trip2 = new Trip(5678, 60, "07/01/2021", "Barcelona", "12:00");
		Trip trip3 = new Trip(9101, 70, "13/02/2021", "Sevilla", "15:00");
		Trip trip4 = new Trip(8976, 40, "21/03/2021", "Malaga", "11:00");
		Trip trip5 = new Trip(4554, 60, "09/04/2021", "San Sebastian", "14:30");
		Trip trip6 = new Trip(0010, 70, "13/02/2021", "Madrid", "11:00");
		Trip trip7 = new Trip(1007, 40, "18/03/2021", "Madrid", "13:00");
		Trip trip8 = new Trip(6666, 60, "07/01/2021", "Barcelona", "22:15");
		Trip trip9 = new Trip(0202, 70, "15/02/2021", "Cádiz", "09:00");
		
		pushToDB(client1);
		pushToDB(client2);
		pushToDB(client3);
		
		pushToDB(trip1);
		pushToDB(trip2);
		pushToDB(trip3);
		pushToDB(trip4);
		pushToDB(trip5);
		pushToDB(trip6);
		pushToDB(trip7);
		pushToDB(trip8);
		pushToDB(trip9);
	}

	/**
	 * Push an object to the DB
	 * @param object
	 */
	
    public void pushObjToDB(Object object) {
        PersistenceManager pm = pmf.getPersistenceManager(); 
        pm.getFetchPlan().setMaxFetchDepth(4);
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            log.info("* Storing an object: " + object);
            pm.makePersistent(object);
            tx.commit();
        } catch (Exception ex) {
            log.error("$ Error storing an object: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    /**
     * Cast passed object to a type object "Cliente" and push it to DB
     * @param c
     */
    
    public void pushToDB(Cliente c) {
        DBManager.getInstance().pushObjToDB(c);
    }
    
    /**
     * Cast passed object to a type object "Trip" and push it to DB
     * @param t
     */
    
    public void pushToDB(Trip t) {
        DBManager.getInstance().pushObjToDB(t);
    }
    
    /**
     * Cast passed object to a type object "Ticket" and push it to DB
     * @param t
     */
    
    public void pushToDB(Ticket t) {
        DBManager.getInstance().pushObjToDB(t);
    }
    
    /**
     * Method to get back all the clients stored in the DB
     * @return list of clients
     */

	public List<Cliente> getClients(){
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		tx.begin();

		log.info("getClients(): Checking all the clients ");
		Query<Cliente> query = pm.newQuery("javax.jdo.query.SQL", "select * from " + "cliente");
		query.setClass(Cliente.class);

		List<Cliente> results = query.executeList();

		tx.commit();
		pm.close();
		return results;
	}

	/**
	 * Method to know if a user exists
	 * @param client
	 * @return boolean (true if exists, false if it doesn't)
	 * @throws DBException
	 */
	
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
	
	/**
	 * Book selected ticket to the DB
	 * @param t
	 */

	public void bookATicket(Ticket t) {
		pushToDB(t);
	}

	/**
	 * Get back all the trips stored in the DB
	 * @return list of trips
	 */
	
	public List<Trip> getTrips() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Trip> trips = new ArrayList<Trip>();

		try {
            log.info("getTrips(): Checking every trip: ");
			tx.begin();

			Extent<Trip> tripExtent = pm.getExtent(Trip.class, true);

			for (Trip trip : tripExtent) {

				Trip t = new Trip(trip.getBusID(), trip.getCost(), trip.getDate(), trip.getDestiny(), trip.getHour());
				trips.add(t);
			}
			tx.commit();
		} catch (Exception ex) {
            log.error("$ Error can't check trips: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close(); 
		}
		return trips;
	}

	/**
	 * Get back all the tickets stored in the DB
	 * @return list of tickets
	 */
	
	public List<Ticket> getTickets() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Ticket> tickets = new ArrayList<Ticket>();

		try {
            log.info("getTrips(): Checking every trip: ");
			tx.begin();

			Extent<Ticket> ticketExtent = pm.getExtent(Ticket.class, true);

			for (Ticket ticket : ticketExtent) {

				Ticket t = new Ticket(ticket.getCodigo(), ticket.getDate(), ticket.getDestino(), ticket.getHour(), ticket.getBus(), ticket.getPrecio());

				tickets.add(t);
			}
			tx.commit();
		} catch (Exception ex) {
            log.error("$ Error can't check tickets: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return tickets;
	}
	
	/**
	 * Delete the ticket with the code passed
	 * @param code
	 */
	
    public void deleteTicket(int code) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            log.info("Eliminando ticket con código: " + code);
            tx.begin();

            Extent<Ticket> e = pm.getExtent(Ticket.class, true);
            Iterator<Ticket> iter = e.iterator();
            while (iter.hasNext()) {
                Ticket ticket = (Ticket) iter.next();
                if (ticket.getCodigo() == code) {
                    pm.deletePersistent(ticket);
                }
            }

            tx.commit();
        } catch (Exception ex) {
            log.error("Error obteniendo cliente: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }
}