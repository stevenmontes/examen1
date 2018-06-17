package cr.ac.cenfotec.logica;

public class Deck {
	private Naipe maso;

	public Deck() throws Exception {
		maso = new Naipe();
		maso.combinar();
	}

	public Naipe getMaso() {
		return maso;
	}

	public void setMaso(Naipe maso) {
		this.maso = maso;
	}

	public Carta agarrarCarta() throws Exception {
		Carta manoDeck[] = this.maso.getMaso();
		Carta nueva = new Carta();

		for (int ind = 0; ind < manoDeck.length; ind++) {
			if (existeCarta(manoDeck, ind)) {
				nueva = manoDeck[ind];
				manoDeck[ind] = null;
				break;
			} else if (deckVacio(manoDeck, ind)) {
				throw new Exception("Deck vacio");
			}
		}

		return nueva;
	}

	private boolean deckVacio(Carta[] manoDeck, int ind) {
		return ind == manoDeck.length - 1;
	}

	private boolean existeCarta(Carta[] manoDeck, int ind) {
		return manoDeck[ind] != null;
	}
}
