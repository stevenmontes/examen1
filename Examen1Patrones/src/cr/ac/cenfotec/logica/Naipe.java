package cr.ac.cenfotec.logica;

public class Naipe {
	private Carta maso[];

	public Naipe() throws Exception {
		maso = new Carta[52];
		setMaso();
	}
	
	public void combinar() {
		int indiceAleatorio = (int) Math.floor(Math.random() * 52);
		
		for(int indiceNaipe = 0; indiceNaipe < maso.length; indiceNaipe++) {
			Carta a = maso[indiceNaipe];
			maso[indiceNaipe] = maso[indiceAleatorio];
			maso[indiceAleatorio] = a;
		}
	}
	
	public Carta[] getMaso() {
		return maso;
	}

	private void setMaso() throws Exception {
		int indiceNaipe = 0;
		for (int indicePaloCarta = 0; indicePaloCarta < 4; indicePaloCarta++) {
			for (int indiceValorCarta = 0; indiceValorCarta < 13; indiceValorCarta++) {
				Carta a = obtenerCarta(indicePaloCarta, indiceValorCarta);
				maso[indiceNaipe++] = a;
			}
		}
	}

	private Carta obtenerCarta(int indicePalo, int indiceNombre) throws Exception {
		Carta a = new Carta();
		a.setNombre(obtenerNombre(indiceNombre));
		a.setPalo(obtenerPalo(indicePalo));
		a.setValor(obtenerValor(indiceNombre));
		return a;
	}


	private int obtenerValor(int indiceNombreCarta) {
		int valor;
		switch (indiceNombreCarta) {
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

	private String obtenerPalo(int indicePaloCarta) {
		String palo;
		switch (indicePaloCarta) {
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

	private String obtenerNombre(int indiceNombreCarta) {
		String nombre;
		switch (indiceNombreCarta) {
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
