package model;

public class UsuarioVerificador {

	public boolean verifica(String texto) {
		int tamanhoTexto = texto.length();
		boolean letra = false;
		boolean numero = false;
		boolean tamanho = false;
		boolean caracteres = true;

		if (tamanhoTexto >= 5 && tamanhoTexto <= 15) {
			tamanho = true;
		}

		for (int c = 0; c < tamanhoTexto; c++) {
			if (texto.toLowerCase().charAt(c) >= 97 && texto.toLowerCase().charAt(c) <= 122) {
				letra = true;
			} else if (texto.charAt(c) >= 48 && texto.charAt(c) <= 57) {
				numero = true;
			} else {
				caracteres = false;
			}
		}
		if ((numero == true || letra == true) && tamanho == true && caracteres == true) {
			return true;
		} else {
			return false;
		}
	}
}
