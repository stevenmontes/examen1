package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import cr.ac.cenfotec.logica.Carta;

public class CartaTest {
	
	Carta cardA;
	Carta cardB;
	
	@Before
	public void init() {
		cardA = new Carta();
		cardB = new Carta();
	}
	
	public void modificarCarta(Carta a, String nombre, String palo, int valor) throws Exception {
		a.setNombre(nombre);
		a.setPalo(palo);
		a.setValor(valor);
	}
	
	@Test(expected = Exception.class)
	public void testValorCarta() throws Exception {
		cardA.setValor(11);
	}
	
	@Test
	public void testValorCarta1() throws Exception {
		cardA.setValor(10);
	}
	
	@Test
	public void testValorCarta2() throws Exception {
		cardA.setValor(1);
	}
	
	@Test
	public void testEquals() throws Exception {
		modificarCarta(cardA, "3", "Escudos", 3);
		modificarCarta(cardB, "3", "Estrellas", 3);
		assertTrue(cardA.equals(cardB));
	}
	
	@Test
	public void testEquals1() throws Exception {
		modificarCarta(cardA, "Jota", "Gotas", 10);
		modificarCarta(cardB, "Ka", "Estrellas", 10);
		assertTrue(cardA.equals(cardB));
	}
}
