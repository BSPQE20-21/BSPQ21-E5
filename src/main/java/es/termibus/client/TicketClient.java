package es.termibus.client;

import java.util.List;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import es.termibus.data.Ticket;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class TicketClient {
	
    static TicketClient instance = null;
    Client client;
    WebTarget target;

    public static TicketClient getInstance() {
        if (instance == null) { 
            instance = new TicketClient();
        }
        return instance;
    }

    public TicketClient() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("ticket"); // http://localhost:8080/myapp/cliente
    }
    
    // View trips
    
    public List<Ticket> viewTickets() {
        Invocation.Builder ib = target.request();
        Response response = ib.get();
        List<Ticket> tickets = response.readEntity(new GenericType<List<Ticket>>() {
        });
        return tickets;
    }
    
    // Post ticket in DB
    
    public Ticket postTicket(Ticket t) {
    	 Invocation.Builder ib = target.request();
         Response response = ib.post(Entity.entity(t, MediaType.APPLICATION_JSON));
         t = response.readEntity(Ticket.class);
    	return t;
    }
}