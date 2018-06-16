package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cr.ac.cenfotec.logica.Mesa;

public class MesaTest {

	static Mesa a;
	
	@BeforeClass
	public static void init() {
		a = new Mesa();
	}
	
	@Test
	public void testInitMesa() {
		Mesa a = new Mesa();
		assertNull(a.getJugadores());
	}

}
