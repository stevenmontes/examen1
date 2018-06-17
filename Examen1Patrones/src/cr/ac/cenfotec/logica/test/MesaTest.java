package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Deck;
import cr.ac.cenfotec.logica.Jugador;
import cr.ac.cenfotec.logica.Mesa;
import cr.ac.cenfotec.logica.Repartidor;

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
		agregarTodosJugadores();
		a.agregarJugador("p5");
	}
	
	@Test
	public void testJugadoresMaximo() throws Exception {
		agregarTodosJugadores();
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
	
	@Test
	public void testEmpezarJuego1() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		Jugador p1 = jugadores[0];
		Jugador p2 = jugadores[1];
		Jugador p3 = jugadores[2];
		Jugador p4 = jugadores[3];
		
		assertTrue(p1.getMano() != null);
		assertTrue(p2.getMano() != null);
		assertTrue(p3.getMano() != null);
		assertTrue(p4.getMano() != null);
	}

	private Jugador[] iniciarJuegoBasico() throws Exception {
		agregarTodosJugadores();
		a.empezarAJugar21();
		return a.getJugadores();
	}

	private Jugador[] agregarTodosJugadores() throws Exception {
		a.agregarJugador("p1");
		a.agregarJugador("p2");
		a.agregarJugador("p3");
		a.agregarJugador("p4");
		return a.getJugadores();
	}
	
	@Test
	public void testVerCartas() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		
		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();
		
		assertTrue(manoP1[1] != null);
		assertTrue(manoP2[1] != null);
	}
	
	@Test
	public void testVerCartas1() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		
		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();
		Carta manoP3[] = jugadores[2].getMano();
		Carta manoP4[] = jugadores[3].getMano();
		
		assertTrue(manoP1[1] != null);
		assertTrue(manoP2[1] != null);
		assertTrue(manoP3[1] != null);
		assertTrue(manoP4[1] != null);
	}
	
	@Test
	public void testFinalizarJuego() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		
		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();
		Carta manoP3[] = jugadores[2].getMano();
		Carta manoP4[] = jugadores[3].getMano();
		
		manoP1[0].setValor(2);
		manoP1[1].setValor(2);
		
		manoP2[0].setValor(10);
		manoP2[1].setValor(10);
		
		manoP3[0].setValor(5);
		manoP3[1].setValor(5);
		
		manoP4[0].setValor(9);
		manoP4[1].setValor(10);
		
		jugadores[0].setMano(manoP1);
		jugadores[1].setMano(manoP2);
		jugadores[2].setMano(manoP3);
		jugadores[3].setMano(manoP4);
		
		Jugador ganadores[] = a.finalizarJuego();
		assertTrue(jugadores[1] == ganadores[1]);
	}
	
	@Test
	public void testFinalizarJuego1() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();
		
		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();
		
		manoP1[0].setValor(9);
		manoP1[1].setValor(10);
		
		manoP2[0].setValor(10);
		manoP2[1].setValor(10);
		
		jugadores[0].setMano(manoP1);
		jugadores[1].setMano(manoP2);
		
		Jugador ganadores[] = a.finalizarJuego();
		assertTrue(jugadores[1] == ganadores[1]);
	}
	
	@Test
	public void testEmpezarPartidaRon() throws Exception {
		Jugador[] jugadores = agregarTodosJugadores();
		
		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();
		Carta manoP3[] = jugadores[2].getMano();
		Carta manoP4[] = jugadores[3].getMano();
		
		a.empezarPartidaDeRon();
		
		for(int i = 0; i < 7; i++) {
			assertTrue(manoP1[i] != null);
			assertTrue(manoP2[i] != null);
			assertTrue(manoP3[i] != null);
			assertTrue(manoP4[i] != null);
		}
	}
	
	@Test
	public void testReset() throws Exception {
		a.reset();
		Repartidor dealer = a.getDealer();
		Carta manoDealer[] = dealer.getMaso().getMaso();
		Jugador jugadores[] = a.getJugadores();
		assertTrue(jugadores[0] == null);
		assertTrue(manoDealer.length == 52);
	}
	
		
		

}
