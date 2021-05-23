package es.termibus.server;

import java.util.List;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import es.termibus.database.DBManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("myapp")
public class Server {
	
/*
 *  @brief Prueba
 *
 */
	
	@GET
	@Path("/ticket")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Ticket> getTicketInfo() {
		return DBManager.getInstance().getTickets();
	}
	
	/* View the information of each client stored in the DB */
	
	@GET
	@Path("/client")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Cliente> getClientInfo() {
		return DBManager.getInstance().getClients();
	}
	
	/* View the information of each trip stored in the DB */
	
	@GET
	@Path("/trip")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Trip> getTripInfo() {
		return DBManager.getInstance().getTrips();
	}
	
	/* Post a ticket into the DB */
	
	@POST
	@Path("/ticket")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket saveTicket(Ticket ticket) {
		DBManager.getInstance().pushToDB(ticket);
		return ticket;
	}
	
	/* Post a trip into the DB */
	
	@POST
	@Path("/trip")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Trip saveTrip(Trip trip) {
		DBManager.getInstance().pushToDB(trip);
		return trip;
	}
	
	/* Post a client into the DB */
	
	@POST
	@Path("/client")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente saveClient(Cliente client) {
		DBManager.getInstance().pushToDB(client);
		return client;
	}
	
	/* Delete a ticket from DB */
	
	@DELETE
	@Path("/ticket/id/{ticketCode}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarCliente(@PathParam("ticketCode") int code) {
		DBManager.getInstance().deleteTicket(code);
		return "Ticket deleted succesfully";
	}
}
