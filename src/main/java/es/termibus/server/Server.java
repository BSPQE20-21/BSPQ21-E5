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

	// View the information of each ticket stored in the DB
	
	@GET
	@Path("/ticket")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Ticket> getTicketInfo() {
		return DBManager.getInstance().getTickets();
	}
	
	@GET
	@Path("/client")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Cliente> getClientInfo() {
		return DBManager.getInstance().getClients();
	}
	
	@GET
	@Path("/trip")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Trip> getTripInfo() {
		return DBManager.getInstance().getTrips();
	}
	
	@POST
	@Path("/ticket")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket saveTicket(Ticket ticket) {
		DBManager.getInstance().pushToDB(ticket);
		return ticket;
	}
	
	@DELETE
	@Path("/ticket/id/{ticketCode}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarCliente(@PathParam("ticketCode") int code) {
		DBManager.getInstance().deleteTicket(code);
		return "Ticket deleted succesfully";
	}
	
	// TODO: @POST methods for trips and clients
	
}
