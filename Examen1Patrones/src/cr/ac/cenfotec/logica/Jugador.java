package cr.ac.cenfotec.logica;

public class Jugador {
	private String nombre;
	private Carta mano[];
	
	public Jugador() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carta[] getMano() {
		return mano;
	}

	public void setMano(Carta[] mano) {
		this.mano = mano;
	}
	
	
}
