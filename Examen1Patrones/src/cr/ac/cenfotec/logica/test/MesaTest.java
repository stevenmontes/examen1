package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Jugador;
import cr.ac.cenfotec.logica.Mesa;

public class MesaTest {

	Mesa a;

	@Before
	public void init() {
		a = new Mesa();
	}

	@Test
	public void testInitMesa() {
		Jugador arrJugadores[] = a.getJugadores();
		assertNull(arrJugadores[0]);
		assertNull(arrJugadores[1]);
		assertNull(arrJugadores[2]);
		assertNull(arrJugadores[3]);
	}

	@Test(expected = Exception.class)
	public void testMesaLleno() throws Exception {
		a.agregarJugador("p1");
		a.agregarJugador("p2");
		a.agregarJugador("p3");
		a.agregarJugador("p4");
		a.agregarJugador("p5");
	}
	
	@Test
	public void testJugadoresMaximo() throws Exception {
		a.agregarJugador("p1");
		a.agregarJugador("p2");
		a.agregarJugador("p3");
		a.agregarJugador("p4");
	}

}
