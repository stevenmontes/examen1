package cr.ac.cenfotec.logica;

public class Repartidor {
	private Naipe maso;

	public Repartidor() throws Exception {
		maso = new Naipe();
		maso.combinar();
	}

	public Naipe getMaso() {
		return maso;
	}

	public void darCarta(Jugador player) throws Exception {
		Carta manoDealer[] = this.getMaso().getMaso();

		for (int indManoDealer = 0; indManoDealer < manoDealer.length; indManoDealer++) {
			if (isNotNull(manoDealer, indManoDealer)) {
				Carta nueva = manoDealer[indManoDealer];
				addCarta(player, nueva);
				manoDealer[indManoDealer] = null;
				break;

			} else if (isNull(manoDealer, indManoDealer)) {
				throw new Exception("Naipe vacio");
			}
		}

	}

	private void addCarta(Jugador player, Carta cartaNueva) {
		Carta manoJugador[] = player.getMano();
		for (int indManoPlayer = 0; indManoPlayer < manoJugador.length; indManoPlayer++) {
			if (manoJugador[indManoPlayer] == null) {
				manoJugador[indManoPlayer] = cartaNueva;
				break;
			}
		}
	}

	private boolean isNull(Carta[] manoDealer, int indManoDealer) {
		return indManoDealer == manoDealer.length - 1;
	}

	private boolean isNotNull(Carta[] manoDealer, int indManoDealer) {
		return manoDealer[indManoDealer] != null;
	}

}
