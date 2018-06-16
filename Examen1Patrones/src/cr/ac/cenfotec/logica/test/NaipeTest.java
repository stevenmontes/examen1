package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Naipe;

public class NaipeTest {

	static Naipe p;

	@BeforeClass
	public static void init() throws Exception {
		p = new Naipe();
	}

	@Test
	public void testPrimerCarta() {
		Carta primeraCarta = obtenerCarta(0);
		assertEquals("As", primeraCarta.getNombre());
		assertEquals("Escudos", primeraCarta.getPalo());
		assertEquals(1, primeraCarta.getValor());
	}

	@Test
	public void testUltimaCarta() {
		Carta ultimaCarta = obtenerCarta(51);
		assertEquals("Ka", ultimaCarta.getNombre());
		assertEquals("Gotas", ultimaCarta.getPalo());
		assertEquals(10, ultimaCarta.getValor());
	}

	@Test
	public void testCartasAsFlores() {
		Carta as = obtenerCarta(13);
		assertEquals("As", as.getNombre());
		assertEquals("Flores", as.getPalo());
		assertEquals(1, as.getValor());
	}

	@Test
	public void testCartasAsEstrellas() {
		Carta as = obtenerCarta(26);
		assertEquals("As", as.getNombre());
		assertEquals("Estrellas", as.getPalo());
		assertEquals(1, as.getValor());
	}

	@Test
	public void testCartasAsGotas() {
		Carta as = obtenerCarta(39);
		assertEquals("As", as.getNombre());
		assertEquals("Gotas", as.getPalo());
		assertEquals(1, as.getValor());
	}

	private Carta obtenerCarta(int indice) {
		Carta naipe[] = p.getMaso();
		Carta primeraCarta = naipe[indice];
		return primeraCarta;
	}

}
