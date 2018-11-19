package model;


public class Cesar {

public String encriptar(int chave, String texto) {
    StringBuilder textoCifrado = new StringBuilder();
    int tamanhoTexto = texto.length();

    for (int c = 0; c < tamanhoTexto; c++) {
        int letraCifradaASCII = ((int) texto.charAt(c)) + (chave);
        
        if(letraCifradaASCII == 58) {
        	letraCifradaASCII = 48;
        }
        
        if(letraCifradaASCII == 59) {
        	letraCifradaASCII = 49;
        }
        
        if(letraCifradaASCII == 60) {
        	letraCifradaASCII = 50;
        }
        
        if(letraCifradaASCII == 123) {
        	letraCifradaASCII = 97;
        }
        
        if(letraCifradaASCII == 124) {
        	letraCifradaASCII = 98;
        }
        if(letraCifradaASCII == 125) {
        	letraCifradaASCII = 99;
        }

        while (letraCifradaASCII > 126) {
            letraCifradaASCII -= 94;
        }

        textoCifrado.append((char) letraCifradaASCII);
    }

    return textoCifrado.toString();
}

public String decriptar(int chave, String textoCifrado) {
    StringBuilder texto = new StringBuilder();
    int tamanhoTexto = textoCifrado.length();

    for (int c = 0; c < tamanhoTexto; c++) {
        int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - (chave);
        
        if(letraDecifradaASCII == 47) {
        	letraDecifradaASCII = 57;
        }
        
        if(letraDecifradaASCII == 46) {
        	letraDecifradaASCII = 56;
        }
        
        if(letraDecifradaASCII == 45) {
        	letraDecifradaASCII = 55;
        }
        
        if(letraDecifradaASCII == 96) {
        	letraDecifradaASCII = 122;
        }
        
        if(letraDecifradaASCII == 95) {
        	letraDecifradaASCII = 121;
        }
        if(letraDecifradaASCII == 94) {
        	letraDecifradaASCII = 120;
        }

        while (letraDecifradaASCII < 32) {
            letraDecifradaASCII += 94;
        }

        texto.append((char) letraDecifradaASCII);
    }
    
	return texto.toString();
}
}
