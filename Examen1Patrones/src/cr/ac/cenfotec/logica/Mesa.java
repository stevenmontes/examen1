package cr.ac.cenfotec.logica;

public class Mesa {
	private Repartidor dealer;
	private Jugador jugadores[];
	
	public Mesa() {
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
		
		for(int indiceJugadores = 0; indiceJugadores < jugadores.length;indiceJugadores++) {
			if(isEmpty(indiceJugadores)) {
				jugadores[indiceJugadores] = nuevoJugador;
				break;
			} else if(indiceJugadores == 3) {
				throw new Exception("Mesa llena");
			}
		}
		
	}

	private boolean isEmpty(int indiceJugadores) {
		return jugadores[indiceJugadores] == null;
	}
	
}
