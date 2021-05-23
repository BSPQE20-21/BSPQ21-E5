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

/**
 * This class has the declaration of each HTTP method. These methods are annotated with the JAX-RS annotations
 *
 * @author lazlomeli
 */

@Path("myapp")
public class Server {

	/**
	 *  View the information of each ticket stored in the DB  
	 * @return list of tickets
	 */
	
	@GET
	@Path("/ticket")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Ticket> getTicketInfo() {
		return DBManager.getInstance().getTickets();
	}
	
	/**
	 *  View the information of each client stored in the DB
	 * @return list of clients
	 */
	
	@GET
	@Path("/client")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Cliente> getClientInfo() {
		return DBManager.getInstance().getClients();
	}
	
	/**
	 *  View the information of each trip stored in the DB
	 * @return list of trip
	 */
	
	@GET
	@Path("/trip")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Trip> getTripInfo() {
		return DBManager.getInstance().getTrips();
	}
	
	/**
	 *  Post a ticket into the DB 
	 * @return passed ticket
	 */
	
	@POST
	@Path("/ticket")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket saveTicket(Ticket ticket) {
		DBManager.getInstance().pushToDB(ticket);
		return ticket;
	}
	
	/**
	 *  Post a trip into the DB  
	 * @return passed trip
	 */
	
	@POST
	@Path("/trip")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Trip saveTrip(Trip trip) {
		DBManager.getInstance().pushToDB(trip);
		return trip;
	}
	
	/**
	 *  Post a client (user) into the DB  
	 * @return passed client (user)
	 */
	
	@POST
	@Path("/client")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente saveClient(Cliente client) {
		DBManager.getInstance().pushToDB(client);
		return client;
	}
	
	/**
	 * Delete ticket from the DB
	 * @return success message
	 */
	
	@DELETE
	@Path("/ticket/id/{ticketCode}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarCliente(@PathParam("ticketCode") int code) {
		DBManager.getInstance().deleteTicket(code);
		return "Ticket deleted succesfully";
	}
}