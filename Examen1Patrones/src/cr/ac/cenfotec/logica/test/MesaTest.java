package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Jugador;
import cr.ac.cenfotec.logica.Mesa;

public class MesaTest {

	Mesa a;

	@Before
	public void init() throws Exception {
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
	
	@Test
	public void testAgregarJugadores() throws Exception {
		a.agregarJugador("p1");
		assertTrue(a.getJugadores() != null);
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
	
	@Test(expected = Exception.class)
	public void testEmpezarMesaVacia() throws Exception {
		a.empezarAJugar21();
		assertFalse(a.getJugadores() == null);
	}
	
	@Test
	public void testEmpezarJuego() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		Jugador p1 = jugadores[0];
		Jugador p2 = jugadores[1];
		
		assertTrue(p1.getMano() != null);
		assertTrue(p2.getMano() != null);
	}

	private Jugador[] iniciarJuegoBasico() throws Exception {
		a.agregarJugador("p1");
		a.agregarJugador("p2");
		
		a.empezarAJugar21();
		
		Jugador jugadores[] = a.getJugadores();
		return jugadores;
	}
	
	@Test
	public void testVerCartas() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		Jugador p1 = jugadores[0];
		Jugador p2 = jugadores[1];
		
		Carta manoP1[] = p1.getMano();
		Carta manoP2[] = p2.getMano();
		
		assertTrue(manoP1[1] != null);
		assertTrue(manoP2[1] != null);
	}

}
