package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import cr.ac.cenfotec.logica.Carta;

public class CartaTest {
	
	Carta cardA = new Carta();
	Carta cardB = new Carta();
	
	public void modificarCarta(Carta a, String nombre, String palo, int valor) throws Exception {
		a.setNombre(nombre);
		a.setPalo(palo);
		a.setValor(valor);
	}
	
	@Test(expected = Exception.class)
	public void testValor() throws Exception {
		cardA = new Carta();
		cardA.setValor(11);
		assertEquals(11, cardA.getValor());
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
