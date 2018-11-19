package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class ContatoDAOImpl implements ContatoDAO {

	BufferedWriter bw = null;
	BufferedReader reader = null;
	Writer out = null;
	String nomeUsuario;

	/*
	 * O construtor deve receber como parâmetro o nome do arquivo de dados de
	 * contatos (referente ao usuário específico carregado)
	 */
	public ContatoDAOImpl(String nome_arq_dados_c) {
		this.nomeUsuario = nome_arq_dados_c;
	}

	@Override
	public Contato inserir(Contato c) {

		File file = new File("src/main/java/resources/data_u" + nomeUsuario + ".txt");

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Problema na leitura do arquivo users.txt", null, 2);
		}
		String newLine = System.getProperty("line.separator");

		try {
			String linha;
			List<String> lista = new ArrayList<String>();
			List<String> lnome = new ArrayList<String>();
			String[] textoSeparado = null;
			int i = 0;
			int k = 0;
			int p = 0;

			lnome.add(c.getNome());
			lista.add(c.getNome());
			lista.add(c.getTelefone());
			lista.add(c.getEmail());
			lista.add(c.getEndereco());

			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				if (!textoSeparado[0].equals(c.getNome())) {
					lnome.add(textoSeparado[0]);
					lista.add(textoSeparado[0]);
					lista.add(textoSeparado[1]);
					lista.add(textoSeparado[2]);
					lista.add(textoSeparado[3]);
				}
			}
			while (p < lnome.size()) {
				if (!lnome.contains(c.getNome())) {
					lnome.add(c.getNome());
					lista.add(c.getNome());
					lista.add(c.getTelefone());
					lista.add(c.getEmail());
					lista.add(c.getEndereco());
				}
				p++;
			}

			Collections.sort(lnome);

			out = new FileWriter(file);
			out.write("");
			out.flush();
			out = new FileWriter(file.getAbsoluteFile(), true);
			while (i < lnome.size()) {
				k = 0;
				while (k < lista.size()) {
					if (k == 0 || k % 4 == 0) {
						if (lnome.get(i).toString().equals(lista.get(k).toString())) {
							out.write(lista.get(k).toString() + ";" + lista.get(k + 1).toString() + ";"
									+ lista.get(k + 2).toString() + ";" + lista.get(k + 3).toString() + newLine);
							break;
						}
					}
					k++;
				}
				i++;
			}
			reader.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Contato buscarPorParteNome(String parteNome) {
		Contato contato = new Contato();
		try {
			File file = new File("src/main/java/resources/data_u" + nomeUsuario + ".txt");

			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linha;
		LinkedList<Object> lista = new LinkedList<Object>();
		String[] textoSeparado = null;
		int i = 0;
		try {
			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				lista.add(textoSeparado[0]);
				lista.add(textoSeparado[1]);
				lista.add(textoSeparado[2]);
				lista.add(textoSeparado[3]);
			}
			while (i < lista.size()) {
				if ((i == 0 || i % 4 == 0)
						&& (lista.get(i).toString().equals(parteNome) || lista.get(i).toString().contains(parteNome))) {
					contato.setNome(lista.get(i).toString());
					contato.setTelefone(lista.get(i + 1).toString());
					contato.setEmail(lista.get(i + 2).toString());
					contato.setEndereco(lista.get(i + 3).toString());
					break;
				} else {
					contato.setNome("");
				}
				i++;
			}
			if (lista.size() == 0) {
				contato.setNome("");
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contato;
	}

	@Override
	public boolean removerContato(Contato c) {

		boolean removido = false;

		File file = new File("src/main/java/resources/data_u" + nomeUsuario + ".txt");

		try {
			reader = new BufferedReader(new FileReader(new File("src/main/java/resources/data_u" + nomeUsuario + ".txt")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String newLine = System.getProperty("line.separator");

		try {
			String linha;
			List<String> lista = new ArrayList<String>();
			List<String> lnome = new ArrayList<String>();
			String[] textoSeparado = null;
			int i = 0;
			int k = 0;

			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				if (!textoSeparado[0].equals(c.getNome())
						&& !textoSeparado[2].equals(c.getEmail())) {
					lnome.add(textoSeparado[0]);
					lista.add(textoSeparado[0]);
					lista.add(textoSeparado[1]);
					lista.add(textoSeparado[2]);
					lista.add(textoSeparado[3]);
				} else {
					removido = true;
				}
			}

			Collections.sort(lnome);

			out = new FileWriter(file);
			out.write("");
			out.flush();
			out = new FileWriter(file.getAbsoluteFile(), true);
			while (i < lnome.size()) {
				k = 0;
				while (k < lista.size()) {
					if (k == 0 || k % 4 == 0) {
						if (lnome.get(i).toString().equals(lista.get(k).toString())) {
							out.write(lista.get(k).toString() + ";" + lista.get(k + 1).toString() + ";"
									+ lista.get(k + 2).toString() + ";" + lista.get(k + 3).toString() + newLine);
							break;
						}
					}
					k++;
				}
				i++;
			}
			reader.close();
			out.close();
		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return removido;
	}

	@Override
	public Contato atualizarContato(Contato cAnt, Contato cAtual) {

		/*
		 * ================================ Verifica Existencia de Arquivo
		 * ===============================
		 */

		File file = new File("src/main/java/resources/data_u" + nomeUsuario + ".txt");

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Problema na leitura do arquivo users.txt", null, 2);
		}
		String newLine = System.getProperty("line.separator");

		try {
			String linha;
			List<String> lista = new ArrayList<String>();
			List<String> lnome = new ArrayList<String>();
			String[] textoSeparado = null;
			int i = 0;
			int k = 0;

			lnome.add(cAtual.getNome());
			lista.add(cAtual.getNome());
			lista.add(cAtual.getTelefone());
			lista.add(cAtual.getEmail());
			lista.add(cAtual.getEndereco());

			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				if (!textoSeparado[0].equals(cAnt.getNome()) && !textoSeparado[1].equals(cAnt.getTelefone())
						&& !textoSeparado[2].equals(cAnt.getEmail()) && !textoSeparado[3].equals(cAnt.getEndereco())) {
					lnome.add(textoSeparado[0]);
					lista.add(textoSeparado[0]);
					lista.add(textoSeparado[1]);
					lista.add(textoSeparado[2]);
					lista.add(textoSeparado[3]);
				}
			}

			Collections.sort(lnome);

			out = new FileWriter(file);
			out.write("");
			out.flush();
			out = new FileWriter(file.getAbsoluteFile(), true);
			if (lista.size() == 0) {
				out.write(cAtual.getNome() + ";" + cAtual.getTelefone() + ";" + cAtual.getEmail() + ";"
						+ cAtual.getEndereco() + newLine);
			}
			while (i < lnome.size()) {
				k = 0;
				while (k < lista.size()) {
					if (k == 0 || k % 4 == 0) {
						if (lnome.get(i).toString().equals(lista.get(k).toString())) {
							out.write(lista.get(k).toString() + ";" + lista.get(k + 1).toString() + ";"
									+ lista.get(k + 2).toString() + ";" + lista.get(k + 3).toString() + ";" + newLine);
							break;
						}
					}
					k++;
				}
				i++;
			}
			reader.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cAtual;
	}

	@Override
	public List<Contato> listarTodosContatos() {
		UsuarioTxtExiste cria = new UsuarioTxtExiste();
		cria.criaTxt();
		cria.criaTxtData(nomeUsuario);
		try {
			reader = new BufferedReader(new FileReader(new File("src/main/java/resources/data_u" + nomeUsuario + ".txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linha;
		List<Contato> lista = new LinkedList<Contato>();
		String[] textoSeparado = null;
		Contato contato = new Contato();
		try {
			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				contato.setNome(textoSeparado[0]);
				contato.setTelefone(textoSeparado[1]);
				contato.setEmail(textoSeparado[2]);
				contato.setEndereco(textoSeparado[3]);
				lista.add(contato);
			}
			if(lista.isEmpty()) {
				lista.add(contato);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Problema na leitura autenticadora do users.txt", null, 2);
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
