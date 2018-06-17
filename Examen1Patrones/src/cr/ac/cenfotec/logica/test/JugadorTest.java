package cr.ac.cenfotec.logica.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import cr.ac.cenfotec.logica.Carta;
import cr.ac.cenfotec.logica.Jugador;

public class JugadorTest {

	Jugador player1;
	
	@Before
	public void init() {
		player1 = new Jugador();
	}
	
	@Test
	public void testCambioMano() throws Exception {
		Carta ka = new Carta();
		ka.setNombre("Ka");
		ka.setPalo("Estrellas");
		ka.setValor(10);
		
		Carta tres = new Carta();
		tres.setNombre("3");
		tres.setPalo("Gotas");
		tres.setValor(3);
		
		Carta mano[] = new Carta[7];
		mano[0] = ka;
		mano[1] = tres;
		
		player1.setMano(mano);
		assertTrue(player1.verificarCambio());
		
	}
	
	@Test
	public void testCambioMano1() throws Exception {
		Carta ka = new Carta();
		ka.setNombre("4");
		ka.setPalo("Estrellas");
		ka.setValor(4);
		
		Carta tres = new Carta();
		tres.setNombre("3");
		tres.setPalo("Gotas");
		tres.setValor(3);
		
		Carta mano[] = new Carta[7];
		mano[0] = ka;
		mano[1] = tres;
		
		player1.setMano(mano);
		assertFalse(player1.verificarCambio());
		
	}

}
