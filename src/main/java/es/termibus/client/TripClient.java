package es.termibus.client;

import java.util.List;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.Response;

/**
 * This class will build a new trip and will communicate with the servers via HTTP methods through the RESTful API
 * @author lazlomeli
 *
 */

public class TripClient {
	
	/**
	 * Singleton pattern to instantiate a static object of the class
	 */
	
    static TripClient instance = null;
    Client client;
    WebTarget target;

    public static TripClient getInstance() {
        if (instance == null) {
            instance = new TripClient();
        }
        return instance;
    }

    public TripClient() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("trip"); // http://localhost:8080/myapp/cliente
    }
    
    /**
     * Post a trip into the DB
     * @param t
     * @return passed trip
     */
    
    public Trip postTrip(Trip t) {
    	 Invocation.Builder ib = target.request();
         Response response = ib.post(Entity.entity(t, MediaType.APPLICATION_JSON));
         t = response.readEntity(Trip.class);
    	return t;
    }
    
    /**
     *  Create a "get" request to get back a list of trips
     * @return list of trips
     */
    
    public List<Trip> viewTrips() {
        Invocation.Builder ib = target.request();
        Response response = ib.get();
        List<Trip> trips = response.readEntity(new GenericType<List<Trip>>() {
        });
        return trips;
    }
}