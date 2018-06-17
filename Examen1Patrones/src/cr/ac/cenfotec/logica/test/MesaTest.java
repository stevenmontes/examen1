package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Jugador;
import cr.ac.cenfotec.logica.Mesa;
import cr.ac.cenfotec.logica.Repartidor;

public class MesaTest {

	Mesa mesaJuego;

	@Before
	public void init() throws Exception {
		mesaJuego = new Mesa();
	}

	@Test
	public void testInitMesa() {
		Jugador arrJugadores[] = mesaJuego.getJugadores();
		assertNull(arrJugadores[0]);
		assertNull(arrJugadores[1]);
		assertNull(arrJugadores[2]);
		assertNull(arrJugadores[3]);
	}

	@Test
	public void testAgregarJugadores() throws Exception {
		mesaJuego.agregarJugador("p1");
		Jugador arrJugadores[] = mesaJuego.getJugadores();
		assertTrue(arrJugadores[0] != null);
		assertTrue(arrJugadores[0].getNombre() == "p1");
	}

	@Test(expected = Exception.class)
	public void testMesaLleno() throws Exception {
		agregarJugadores(4);
		mesaJuego.agregarJugador("p5");
	}

	@Test
	public void testJugadoresMaximo() throws Exception {
		agregarJugadores(4);
		Jugador arrJugadores[] = mesaJuego.getJugadores();
		assertTrue(arrJugadores[3] != null);
	}

	@Test(expected = Exception.class)
	public void testEmpezar21SinJugadores() throws Exception {
		mesaJuego.empezarAJugar21();
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
		agregarJugadores(4);
		mesaJuego.empezarAJugar21();
		return mesaJuego.getJugadores();
	}

	private Jugador[] agregarJugadores(int cantJugadores) throws Exception {
		for (int i = 0; i < cantJugadores; i++) {
			int numJugador = 1;
			mesaJuego.agregarJugador("p" + numJugador++);
		}

		return mesaJuego.getJugadores();
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

		manoP2[0].setValor(5);
		manoP2[1].setValor(10);

		manoP3[0].setValor(5);
		manoP3[1].setValor(5);

		manoP4[0].setValor(10);
		manoP4[1].setValor(10);

		jugadores[0].setMano(manoP1);
		jugadores[1].setMano(manoP2);
		jugadores[2].setMano(manoP3);
		jugadores[3].setMano(manoP4);

		Jugador ganadores[] = mesaJuego.finalizarJuego();
		assertTrue(jugadores[3] == ganadores[3]);
	}
	
	@Test
	public void testFinalizarJuegoEmpate() throws Exception {
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

		manoP4[0].setValor(10);
		manoP4[1].setValor(10);

		jugadores[0].setMano(manoP1);
		jugadores[1].setMano(manoP2);
		jugadores[2].setMano(manoP3);
		jugadores[3].setMano(manoP4);

		Jugador ganadores[] = mesaJuego.finalizarJuego();
		assertTrue(jugadores[1] == ganadores[1]);
		assertTrue(jugadores[3] == ganadores[3]);
	}

	@Test
	public void testFinalizarJuego1() throws Exception {
		Jugador[] jugadores = iniciarJuegoBasico();

		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();

		manoP1[0].setValor(10);
		manoP1[1].setValor(10);

		manoP2[0].setValor(9);
		manoP2[1].setValor(10);

		jugadores[0].setMano(manoP1);
		jugadores[1].setMano(manoP2);

		Jugador ganadores[] = mesaJuego.finalizarJuego();
		assertTrue(jugadores[0] == ganadores[0]);
	}

	@Test
	public void testEmpezarPartidaRon() throws Exception {
		Jugador[] jugadores = agregarJugadores(4);

		Carta manoP1[] = jugadores[0].getMano();
		Carta manoP2[] = jugadores[1].getMano();
		Carta manoP3[] = jugadores[2].getMano();
		Carta manoP4[] = jugadores[3].getMano();

		mesaJuego.empezarPartidaDeRon();

		for (int i = 0; i < 7; i++) {
			assertTrue(manoP1[i] != null);
			assertTrue(manoP2[i] != null);
			assertTrue(manoP3[i] != null);
			assertTrue(manoP4[i] != null);
		}
	}
	
	@Test(expected = Exception.class)
	public void testIniciarPartidaRonSinJugadores() throws Exception {
		mesaJuego.empezarPartidaDeRon();
	}

	@Test
	public void testReset() throws Exception {
		mesaJuego.reset();
		Repartidor dealer = mesaJuego.getDealer();
		Carta manoDealer[] = dealer.getNaipeDealer().getNaipe();
		Jugador jugadores[] = mesaJuego.getJugadores();
		assertTrue(jugadores[0] == null);
		assertTrue(manoDealer.length == 52);
	}

}
