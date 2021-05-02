package teses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.termibus.data.*;

public class testCliente {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetDNI() {
		Cliente cliente = new Cliente("11111111A", "Antonio","antonio@gmail.com", "1234");
		assertEquals(cliente.getDNI(),"11111111A");	
		}
	
	@Test
	public void testGetNameCliente() {
		Cliente cliente = new Cliente("11111111A", "Antonio","antonio@gmail.com", "1234");
		assertEquals(cliente.getName(),"Antonio");	
		}

	@Test
	public void testGetMail() {
		Cliente cliente = new Cliente("11111111A", "Antonio","antonio@gmail.com", "1234");
		assertEquals(cliente.getMail(),"antonio@gmail.com");	
		}

	@Test
	public void testGetPw() {
		Cliente cliente = new Cliente("11111111A", "Antonio","antonio@gmail.com", "1234");
		assertEquals(cliente.getPw(),"1234");	
		}
}