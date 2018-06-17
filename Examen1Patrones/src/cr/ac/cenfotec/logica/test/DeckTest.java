package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Deck;

public class DeckTest {

	Deck maso;

	@Before
	public void init() throws Exception {
		maso = new Deck();
	}

	@Test
	public void testAgarrarCarta() throws Exception {
		maso.agarrarCarta();
		Carta manoDeck[] = maso.getMaso().getNaipe();
		assertNull(manoDeck[0]);
	}

	@Test
	public void testAgarrarCarta1() throws Exception {
		Carta manoDeck[] = maso.getMaso().getNaipe();
		for (int i = 0; i < 20; i++) {
			maso.agarrarCarta();
		}
		assertNull(manoDeck[19]);
	}
	
	@Test
	public void testAgarrarCarta2() throws Exception {
		Carta manoDeck[] = maso.getMaso().getNaipe();
		for (int i = 0; i < 20; i++) {
			maso.agarrarCarta();
		}
		assertTrue(manoDeck[20] != null);
	}

	@Test(expected = Exception.class)
	public void testDeckVacio() throws Exception {
		for (int i = 0; i < 53; i++)
			maso.agarrarCarta();
	}

}
