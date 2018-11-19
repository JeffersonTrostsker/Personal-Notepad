package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UsuarioTxtExiste {

	FileWriter fw = null;

	public void criaTxt() {

		/*
		 * ================================ Criação do arquivo users.txt
		 * ===============================
		 */

		File file = new File("src/main/java/resources/users.txt");
		File diretorio = new File("src/main/java/resources/");
		
		
		if(!diretorio.exists()) {
			diretorio.mkdirs();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Problema na criação de users.txt", null, 2);
			}
		}
	}

	public void criaTxtData(String nomeCriptogrado) {

		/*
		 * ================================ Criação do arquivo users.txt
		 * ===============================
		 */

		File file = new File("src/main/java/resources/data_u" + nomeCriptogrado + ".txt");
		File diretorio = new File("src/main/java/resources/");
		
		
		if(!diretorio.exists()) {
			diretorio.mkdirs();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Problema na criação de users.txt", null, 2);
			}
		}
	}

	public void deletaTxtData(String nomeCriptogrado) {

		/*
		 * ================================ Criação do arquivo users.txt
		 * ===============================
		 */
		
		File diretorio = new File("src/main/java/resources/");
		
		
		if(!diretorio.exists()) {
			diretorio.mkdirs();
		}

		File file = new File("src/main/java/resources/data_u" + nomeCriptogrado + ".txt");

		file.delete();

	}
}