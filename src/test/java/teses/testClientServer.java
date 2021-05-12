package teses;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import es.termibus.Main;
import es.termibus.client.TicketClient;
import es.termibus.data.Cliente;
import es.termibus.data.Ticket;

@Category(IntegrationTest.class)
public class testClientServer {

	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	private static HttpServer server;
	private static TicketClient ticket;

	@BeforeClass
	public static void setUp() throws Exception {
		server = Main.startServer();
		ticket = TicketClient.getInstance();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		server.shutdownNow();
	}

	@Before
	public void PrepareData() {
		int code = 0;
		Ticket t = new Ticket(code, "21/03/2021", "Madrid", "13:00", 1234, 40);
		ticket.postTicket(t);
		ticket.removeTicket(t);
	}

	@After
	public void Clean() {
		List<Ticket> tickets = ticket.viewTickets();
		for (Ticket tck : tickets) {
			ticket.removeTicket(tck);
		}
	}
	
    @Test
    @PerfTest(invocations = 50, threads = 10)
    public void testTicketClient() {

		int code = 0;

		Ticket t = new Ticket(code, "21/03/2021", "Madrid", "13:00", 1234, 40);

        t.setCodigo(ticket.postTicket(t).getCodigo());

        boolean codeBool = false;

        List<Ticket> tickets = ticket.viewTickets();

        for (Ticket tck : tickets) {
            if (tck.getCodigo() == t.getCodigo()) {
                codeBool = true;
            }
        }
        assertTrue(codeBool);
    }
}