package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContatoVerificador {

	public boolean nomeVerificador(String texto) {
		int tamanhoTexto = texto.length();
		boolean teste = false;

		if (!texto.isEmpty()) {
			for (int c = 0; c < tamanhoTexto; c++) {
				if (((int) texto.toLowerCase().charAt(c) >= 97 && 122 >= (int) texto.toLowerCase().charAt(c))
						|| ((int) texto.toLowerCase().charAt(c) >= 48 && 57 >= (int) texto.toLowerCase().charAt(c))
						|| ((int) texto.toLowerCase().charAt(c) >= 129 && 153 >= (int) texto.toLowerCase().charAt(c))
						|| ((int) texto.toLowerCase().charAt(c) >= 160 && 164 >= (int) texto.toLowerCase().charAt(c))
						|| (int) texto.toLowerCase().charAt(c) == 198
						|| (int) texto.toLowerCase().charAt(c) >= 65 && 90 >= (int) texto.toLowerCase().charAt(c)) {
					teste = true;
				} else {
					teste = false;
					break;
				}
			}
		}
		return teste;
	}

	public boolean telVerificador(String texto) {
		int tamanhoTexto = texto.length();
		boolean teste = false;
		for (int c = 0; c < tamanhoTexto; c++) {
			if (tamanhoTexto <= 20 && tamanhoTexto >= 8) {
				if ((int) texto.toLowerCase().charAt(c) >= 48 && 57 >= (int) texto.toLowerCase().charAt(c)) {
					teste = true;
				} else {
					teste = false;
					break;
				}
			}
		}
		return teste;
	}

	public boolean EmailVerificador(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	public boolean endVerificador(String endereco) {
		boolean saida;
		if ((!endereco.contains("lugar nenhum") && !endereco.contains("judas perdeu as botas")
				&& !endereco.contains("casa da mãe joana") && !endereco.contains("num sei"))
				&& (endereco.length() > 2 && endereco.length() < 256)) {
			saida = true;
		} else {
			saida = false;
		}
		return saida;
	}
}