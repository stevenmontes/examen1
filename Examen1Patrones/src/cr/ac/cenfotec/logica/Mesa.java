package cr.ac.cenfotec.logica;

public class Mesa {
	private Repartidor dealer;
	private Jugador jugadores[];
	private Deck deck;

	public Mesa() throws Exception {
		dealer = new Repartidor();
		jugadores = new Jugador[4];
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck maso) {
		this.deck = maso;
	}

	public void agregarJugador(String nombre) throws Exception {
		Jugador nuevoJugador = new Jugador();
		nuevoJugador.setNombre(nombre);

		for (int ind = 0; ind < this.jugadores.length; ind++) {
			if (!existeJugador(this.jugadores[ind])) {
				this.jugadores[ind] = nuevoJugador;
				break;

			} else if (ind == 3) {
				throw new Exception("Mesa llena");
			}
		}

	}

	public void empezarAJugar21() throws Exception {
		if (existeJugador(this.jugadores[0])) {
			for (int ind = 0; ind < obtenerCantJugadores(); ind++) {
				Jugador actualJugador = this.jugadores[ind];
				this.getDealer().darCarta(actualJugador);
				this.getDealer().darCarta(actualJugador);
			}
		} else {
			throw new Exception("No hay jugadores agregados.");
		}
	}

	private boolean existeJugador(Jugador actualJugador) {
		return actualJugador != null;
	}

	private boolean existeCarta(Carta[] manoJugador, int ind) {
		return manoJugador[ind] != null;
	}

	public Jugador[] finalizarJuego() {
		int resultados[] = new int[4];
		for (int ind = 0; ind < obtenerCantJugadores(); ind++) {
			Carta manoJugador[] = this.jugadores[ind].getMano();
			resultados[ind] = sumarValorCartas(manoJugador);
		}

		Jugador ganadores[] = obtenerGanadores(resultados);
		return ganadores;
	}

	private int sumarValorCartas(Carta[] manoJugador) {
		int resultado = 0;
		for (int ind = 0; ind < manoJugador.length; ind++) {
			if (existeCarta(manoJugador, ind))
				resultado += manoJugador[ind].getValor();
		}
		return resultado;
	}

	private Jugador[] obtenerGanadores(int[] resultados) {
		int mayorPuntaje = obtenerMayorPuntaje(resultados);
		Jugador[] ganadores = new Jugador[4];

		for (int ind = 0; ind < resultados.length; ind++) {
			if (resultados[ind] == mayorPuntaje) {
				ganadores[ind] = this.jugadores[ind];
			}
		}

		return ganadores;
	}

	private int obtenerMayorPuntaje(int[] resultados) {
		int mayorPuntaje = 0;
		for (int ind = 0; ind < resultados.length; ind++) {
			if (resultados[ind] <= 22) {
				if (resultados[ind] > mayorPuntaje) {
					mayorPuntaje = resultados[ind];
				}
			}
		}
		return mayorPuntaje;
	}

	private int obtenerCantJugadores() {
		int cantJugadores = 0;
		for (int ind = 0; ind < this.jugadores.length; ind++) {
			if (existeJugador(this.jugadores[ind])) {
				cantJugadores++;
			}
		}
		return cantJugadores;
	}

	public void empezarPartidaDeRon() throws Exception {
		deck = new Deck();
		for (int indCarta = 0; indCarta < 7; indCarta++) {
			brindarCartasSalteadas();
		}
	}

	private void brindarCartasSalteadas() throws Exception {
		int cantJugadores = obtenerCantJugadores();

		switch (cantJugadores) {
		case 1:
			this.dealer.darCarta(this.jugadores[0]);
			break;
		case 2:
			this.dealer.darCarta(this.jugadores[0]);
			this.dealer.darCarta(this.jugadores[1]);
			break;
		case 3:
			this.dealer.darCarta(this.jugadores[0]);
			this.dealer.darCarta(this.jugadores[1]);
			this.dealer.darCarta(this.jugadores[2]);
			break;
		case 4:
			this.dealer.darCarta(this.jugadores[0]);
			this.dealer.darCarta(this.jugadores[1]);
			this.dealer.darCarta(this.jugadores[2]);
			this.dealer.darCarta(this.jugadores[3]);
			break;
		default:
			throw new Exception("No hay jugadores.");
		}
	}
	
	public void agarrarCartaDeck(Jugador solicitante) throws Exception {
		Carta nueva = deck.agarrarCarta();
		int numAleatorio = (int) Math.floor(Math.random() * 7);
		Carta manoJugador[] = solicitante.getMano();
		manoJugador[numAleatorio] = nueva;
	}
	
	public void reset() throws Exception {
		dealer = new Repartidor();
		jugadores = new Jugador[4];
	}

}
