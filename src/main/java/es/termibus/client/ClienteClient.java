package es.termibus.client;

import java.util.List;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ClienteClient {
	
    static ClienteClient instance = null;
    Client client;
    WebTarget target;

    public static ClienteClient getInstance() {
        if (instance == null) {
            instance = new ClienteClient();
        }
        return instance;
    }

    public ClienteClient() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("client");
    }
    
    // View trips
    
    public List<Cliente> viewClients() {
        Invocation.Builder ib = target.request();
        Response response = ib.get();
        List<Cliente> clients = response.readEntity(new GenericType<List<Cliente>>() {
        });
        return clients;
    }
    
    // Post client in DB
    
    public Cliente postClient(Cliente c) {
    	 Invocation.Builder ib = target.request();
         Response response = ib.post(Entity.entity(c, MediaType.APPLICATION_JSON));
         c = response.readEntity(Cliente.class);
    	return c;
    }
}
