package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Jugador;
import cr.ac.cenfotec.logica.Repartidor;

public class RepartidorTest {

	Repartidor dealer;

	@Before
	public void init() throws Exception {
		dealer = new Repartidor();
	}

	@Test
	public void testDarPrimeraCarta() throws Exception {
		Jugador player = new Jugador();
		dealer.darCarta(player);
		Carta manoJugador[] = player.getMano();
		Carta naipeDealer[] = dealer.getNaipeDealer().getNaipe();
		assertNull(naipeDealer[0]);
		assertTrue(manoJugador[0] != null);

	}

	@Test
	public void testDarSegundaCarta() throws Exception {
		Jugador player = new Jugador();
		dealer.darCarta(player);
		dealer.darCarta(player);
		Carta manoJugador[] = player.getMano();
		Carta naipeDealer[] = dealer.getNaipeDealer().getNaipe();
		assertNull(naipeDealer[1]);
		assertTrue(manoJugador[1] != null);

	}

	@Test
	public void testDarCarta() throws Exception {
		Jugador player = new Jugador();
		
		for(int i = 0; i < 5; i++) {
			dealer.darCarta(player);
		}
		
		Carta manoJugador[] = player.getMano();
		Carta naipeDealer[] = dealer.getNaipeDealer().getNaipe();
		
		assertNull(naipeDealer[4]);
		assertTrue(manoJugador[3] != null);

	}

	@Test(expected = Exception.class)
	public void testNaipeVacio() throws Exception {
		Carta naipeDealer[] = dealer.getNaipeDealer().getNaipe();
		for (int i = 0; i < naipeDealer.length + 1; i++) {
			Jugador p1 = new Jugador();
			dealer.darCarta(p1);
		}

	}

}
