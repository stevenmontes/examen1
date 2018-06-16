package cr.ac.cenfotec.logica;

public class Mesa {
	private Repartidor dealer;
	private Jugador jugadores[];

	public Mesa() throws Exception {
		dealer = new Repartidor();
		inicializarJugadores();
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

	private void inicializarJugadores() {
		jugadores = new Jugador[4];
	}

	public void agregarJugador(String nombre) throws Exception {
		Jugador nuevoJugador = new Jugador();
		nuevoJugador.setNombre(nombre);

		for (int indJugadores = 0; indJugadores < jugadores.length; indJugadores++) {
			if (isEmpty(indJugadores)) {
				jugadores[indJugadores] = nuevoJugador;
				break;
			} else if (indJugadores == 3) {
				throw new Exception("Mesa llena");
			}
		}

	}

	private boolean isEmpty(int indJugadores) {
		return jugadores[indJugadores] == null;
	}

	public void empezarAJugar21() throws Exception {
		Jugador jugadores[] = this.getJugadores();
		if (jugadores[0] != null) {
			for (int indJugador = 0; indJugador < jugadores.length; indJugador++) {
				Jugador actualJugador = jugadores[indJugador];
				if (existeJugador(actualJugador)) {
					this.getDealer().darCarta(actualJugador);
					this.getDealer().darCarta(actualJugador);
				}
			}
		} else {
			throw new Exception("No hay jugadores agregados.");
		}
	}

	private boolean existeJugador(Jugador actualJugador) {
		return actualJugador != null;
	}

}
