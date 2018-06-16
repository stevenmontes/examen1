package cr.ac.cenfotec.logica;

public class Mesa {
	private Repartidor dealer;
	private Jugador jugadores[];
	
	public Mesa() {
	}

	public Repartidor getDealer() {
		return dealer;
	}

	public void setDealer(Repartidor dealer) {
		this.dealer = dealer;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	
	
}
