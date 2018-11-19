package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class PastaVerificador {
	
	public void busca() {
		
		File criador = new File("src/main/java/resources/users.txt");
		File diretorio = new File("src/main/java/resources/");
		
		
		if(!diretorio.exists()) {
			diretorio.mkdirs();
		}

		if (!criador.exists()) {
			try {
				criador.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("src/main/java/resources/users.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linha;
		LinkedList<Object> lista = new LinkedList<Object>();
		String[] textoSeparado = null;
		try {
			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				lista.add(textoSeparado[0]);
				lista.add(textoSeparado[1]);
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File("src/main/java/resources/");
		File afile[] = file.listFiles();
		int x = 0;
		int i = 0;
		if (lista.size() != 0) {
			while (i < afile.length) {
				boolean palavra = true;
				x = 0;
				File arquivo = afile[i];
				while (x < lista.size()) {
					if (x == 0 || x % 2 == 0) {
						if (arquivo.getName().contains((lista.get(x).toString())) && arquivo.getName().contains(".txt")) {
							palavra = false;
							break;
						}
						else if (!arquivo.getName().contains(".txt") || arquivo.getName().equals("users.txt")) {
							palavra = false;
						}
					}
					x++;
				}
				if (palavra == true) {
					arquivo.delete();
				}
				i++;
			}
		}

	}

}