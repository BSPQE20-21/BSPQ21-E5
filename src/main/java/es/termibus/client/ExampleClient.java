package es.termibus.client;

import java.util.List;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.Response;

public class ExampleClient {
	
    static ExampleClient instance = null;
    Client client;
    WebTarget target;

    public static ExampleClient getInstance() {
        if (instance == null) {
            instance = new ExampleClient();
        }
        return instance;
    }

    public ExampleClient() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("tripinfo"); // http://localhost:8080/myapp/cliente
    }
    
    // View trips
    
    public List<Trip> viewTrips() {
        Invocation.Builder ib = target.request();
        Response response = ib.get();
        List<Trip> trips = response.readEntity(new GenericType<List<Trip>>() {
        });
        return trips;
    }
    
    // View tickets
    
    public List<Ticket> viewTickets() {
        Invocation.Builder ib = target.request();
        Response response = ib.get();
        List<Ticket> tickets = response.readEntity(new GenericType<List<Ticket>>() {
        });
        return tickets;
    }
    
    // View clients
    
    public List<Cliente> viewClients() {
        Invocation.Builder ib = target.request();
        Response response = ib.get();
        List<Cliente> clients = response.readEntity(new GenericType<List<Cliente>>() {
        });
        return clients;
    }
}