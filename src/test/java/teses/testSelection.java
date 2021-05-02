package teses;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.termibus.data.*;

public class testSelection {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCity() {
		Selection select = new Selection( "Madrid","12/02/21, 12:00");
		assertEquals(select.getCity(),"Madrid");	
		}
	
	@Test
	public void testGetDate() {
		Selection select = new Selection( "Madrid","12/02/21, 12:00");
		assertEquals(select.getDate(),"12/02/21, 12:00");	
		}
}