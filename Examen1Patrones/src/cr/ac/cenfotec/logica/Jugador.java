package cr.ac.cenfotec.logica;

public class Jugador {
	private String nombre;
	private Carta mano[];

	public Jugador() {
		mano = new Carta[7];
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

	private boolean verificarCarta3() {
		boolean tres = false;
		for (int indCarta = 0; indCarta < mano.length; indCarta++) {
			if (existeCarta(indCarta)) {
				if (existeCarta3(indCarta)) {
					tres = true;
					break;
				}
			}
		}
		
		return tres;
	}
	
	private boolean verificarCartaFiguras() {
		boolean figuras = false;
		for (int indCarta = 0; indCarta < mano.length; indCarta++) {
			if (existeCarta(indCarta)) {
				if (existaFiguras(indCarta)) {
					figuras = true;
					break;
				}
			}
		}
		
		return figuras;
	}
	
	public boolean verificarCambio() {
		boolean tres = verificarCarta3();
		boolean figuras = verificarCartaFiguras();

		if (tres && figuras) {
			return true;
		} else {
			return false;
		}
	}

	private boolean existaFiguras(int indCarta) {
		return mano[indCarta].getNombre().equals("Ka") || mano[indCarta].getNombre().equals("Jota")
				|| mano[indCarta].getNombre().equals("Quina");
	}

	private boolean existeCarta3(int indCarta) {
		return mano[indCarta].getValor() == 3;
	}

	private boolean existeCarta(int indCarta) {
		return mano[indCarta] != null;
	}

}
