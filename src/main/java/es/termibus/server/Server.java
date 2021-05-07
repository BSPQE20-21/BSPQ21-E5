package es.termibus.server;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.termibus.data.Ticket;
import es.termibus.database.DBManager;

public class Server {

	// View the information of each ticket stored in the DB
	
	@GET
	@Path("/ticketinfo")
	@Produces(MediaType.TEXT_PLAIN) // Json
	public List<Ticket> getTicketInfo() {
		return DBManager.getInstance().getTickets();
	}
}
