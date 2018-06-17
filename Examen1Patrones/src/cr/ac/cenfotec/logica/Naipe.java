package cr.ac.cenfotec.logica;

public class Naipe {
	private Carta naipe[];

	public Naipe() throws Exception {
		naipe = new Carta[52];
		setNaipe();
	}

	public void combinarNaipe() {
		for (int indNaipe = 0; indNaipe < naipe.length; indNaipe++) {
			int indAleatorio = (int) Math.floor(Math.random() * 52);
			Carta nuevaCarta = naipe[indNaipe];
			naipe[indNaipe] = naipe[indAleatorio];
			naipe[indAleatorio] = nuevaCarta;
		}
	}

	public Carta[] getNaipe() {
		return naipe;
	}

	private void setNaipe() throws Exception {
		int indNaipe = 0;
		for (int indPaloCarta = 0; indPaloCarta < 4; indPaloCarta++) {
			for (int indValorCarta = 0; indValorCarta < 13; indValorCarta++) {
				Carta nuevaCarta = obtenerCarta(indPaloCarta, indValorCarta);
				naipe[indNaipe++] = nuevaCarta;
			}
		}
	}

	private Carta obtenerCarta(int indPaloCarta, int indNombreCarta) throws Exception {
		Carta nuevaCarta = new Carta();
		nuevaCarta.setNombre(obtenerNombre(indNombreCarta));
		nuevaCarta.setPalo(obtenerPalo(indPaloCarta));
		nuevaCarta.setValor(obtenerValor(indNombreCarta));
		return nuevaCarta;
	}

	private int obtenerValor(int indNombreCarta) {
		int valor;
		switch (indNombreCarta) {
		case 0:
			valor = 1;
			break;
		case 1:
			valor = 2;
			break;
		case 2:
			valor = 3;
			break;
		case 3:
			valor = 4;
			break;
		case 4:
			valor = 5;
			break;
		case 5:
			valor = 6;
			break;
		case 6:
			valor = 7;
			break;
		case 7:
			valor = 8;
			break;
		case 8:
			valor = 9;
			break;
		default:
			valor = 10;
			break;
		}
		return valor;
	}

	private String obtenerPalo(int indPaloCarta) {
		String palo;
		switch (indPaloCarta) {
		case 0:
			palo = "Escudos";
			break;
		case 1:
			palo = "Flores";
			break;
		case 2:
			palo = "Estrellas";
			break;
		case 3:
			palo = "Gotas";
			break;
		default:
			palo = "";
			break;
		}

		return palo;
	}

	private String obtenerNombre(int indNombreCarta) {
		String nombre;
		switch (indNombreCarta) {
		case 0:
			nombre = "As";
			break;
		case 1:
			nombre = "2";
			break;
		case 2:
			nombre = "3";
			break;
		case 3:
			nombre = "4";
			break;
		case 4:
			nombre = "5";
			break;
		case 5:
			nombre = "6";
			break;
		case 6:
			nombre = "7";
			break;
		case 7:
			nombre = "8";
			break;
		case 8:
			nombre = "9";
			break;
		case 9:
			nombre = "10";
			break;
		case 10:
			nombre = "Jota";
			break;
		case 11:
			nombre = "Quina";
			break;
		case 12:
			nombre = "Ka";
			break;
		default:
			nombre = "";
			break;
		}

		return nombre;
	}
}
