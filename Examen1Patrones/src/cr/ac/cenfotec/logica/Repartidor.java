package cr.ac.cenfotec.logica;

public class Repartidor {
	private Naipe naipeDealer;

	public Repartidor() throws Exception {
		naipeDealer = new Naipe();
		naipeDealer.combinarNaipe();
	}

	public Naipe getNaipeDealer() {
		return naipeDealer;
	}

	public void darCarta(Jugador player) throws Exception {
		Carta manoDealer[] = this.getNaipeDealer().getNaipe();

		for (int indManoDealer = 0; indManoDealer < manoDealer.length; indManoDealer++) {
			if (existeCarta(manoDealer, indManoDealer)) {
				Carta nueva = manoDealer[indManoDealer];
				agregarCartaManoJugador(player, nueva);
				manoDealer[indManoDealer] = null;
				break;

			} else if (naipeVacio(manoDealer, indManoDealer)) {
				throw new Exception("Naipe vacio");
			}
		}

	}

	private void agregarCartaManoJugador(Jugador player, Carta cartaNueva) {
		Carta manoJugador[] = player.getMano();
		for (int indManoPlayer = 0; indManoPlayer < manoJugador.length; indManoPlayer++) {
			if (manoJugador[indManoPlayer] == null) {
				manoJugador[indManoPlayer] = cartaNueva;
				break;
			}
		}
	}

	private boolean naipeVacio(Carta[] manoDealer, int indManoDealer) {
		return indManoDealer == manoDealer.length - 1;
	}

	private boolean existeCarta(Carta[] manoDealer, int indManoDealer) {
		return manoDealer[indManoDealer] != null;
	}

}
