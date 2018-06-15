package cr.ac.cenfotec.logica;

public class Carta {
	private String nombre;
	private String palo;
	private int valor;

	public Carta() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) throws Exception {
		if (validarValorCarta(valor))
			this.valor = valor;
	}

	private boolean validarValorCarta(int valor) throws Exception {
		if(valor >= 1 && valor <= 10) {
			return true;
		} else {
			throw new Exception("El valor de la carta es incorrecta, no esta entre 1 al 10");
		}
	}

	public boolean equals(Carta card) {
		if (this.getValor() == card.getValor()) {
			return true;
		}

		return false;
	}

}
