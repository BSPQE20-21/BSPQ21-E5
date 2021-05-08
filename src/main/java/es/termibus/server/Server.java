package es.termibus.server;

import java.util.List;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import es.termibus.database.DBManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("myapp")
public class Server {

	// View the information of each ticket stored in the DB
	
	@GET
	@Path("/ticketinfo")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Ticket> getTicketInfo() {
		return DBManager.getInstance().getTickets();
	}
	
	@GET
	@Path("/clientinfo")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Cliente> getClientInfo() {
		return DBManager.getInstance().getClients();
	}
	
	@GET
	@Path("/tripinfo")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Trip> getTripInfo() {
		return DBManager.getInstance().getTrips();
	}
}
