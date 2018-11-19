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

public class UsuarioDAOImpl implements UsuarioDAO {

	BufferedWriter bw = null;
	BufferedReader reader = null;
	FileWriter fw = null;
	Writer out = null;

	String nomeBanco;

	public UsuarioDAOImpl(String nome_arq_dados_u) {
		this.nomeBanco = nome_arq_dados_u;
	}

	@Override
	public Usuario inserir(Usuario u) {
		/*
		 * ================================ Verifica Existencia de Arquivo
		 * ===============================
		 */
		UsuarioTxtExiste existe = new UsuarioTxtExiste();

		existe.criaTxt();

		/*
		 * ================================ Da as permissoes de escrita no arquivo
		 * ===============================
		 */

		File file = new File("src/main/java/resources/" + nomeBanco + ".txt");

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Problema na leitura do arquivo users.txt", null, 2);
		}
		String newLine = System.getProperty("line.separator");

		/*
		 * ================================ Procedimento encriptação do nome e senha
		 * ===============================
		 */

		Cesar cesar = new Cesar();
		String nomeEncriptado = cesar.encriptar(3, u.getNomeUsuario());
		String senhaEncriptada = cesar.encriptar(3, u.getSenha());

		/*
		 * ================================ Procedimento de gravação em users.txt
		 * ===============================
		 */

		List<String> lista = new ArrayList<String>();
		List<String> lnome = new ArrayList<String>();
		try {
			String linha;
			String[] textoSeparado;

			int p = 0;
			int k = 0;
			int i = 0;

			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				lnome.add(textoSeparado[0]);
				lista.add(textoSeparado[0]);
				lista.add(textoSeparado[1]);

			}
			while (p < lnome.size()) {
				if (!lnome.contains(nomeEncriptado)) {
					lnome.add(nomeEncriptado);
					lista.add(nomeEncriptado);
					lista.add(senhaEncriptada);
				}
				p++;
			}

			Collections.sort(lnome);

			out = new FileWriter(file);
			out.write("");
			out.flush();
			out = new FileWriter(file.getAbsoluteFile(), true);
			if (lista.size() == 0) {
				out.write(nomeEncriptado + ";" + senhaEncriptada + newLine);
			}
			while (i < lnome.size()) {
				k = 0;
				while (k < lista.size()) {
					if (k == 0 || k % 2 == 0) {
						if (lnome.get(i).toString().equals(lista.get(k).toString())) {
							out.write(lista.get(k).toString() + ";" + lista.get(k + 1).toString() + newLine);
						}
					}
					k++;
				}
				i++;
			}
			out.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		existe.criaTxtData(nomeEncriptado);
		return u;
	}

	@Override
	public List<Usuario> listarTodosUsuarios() {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("src/main/java/resources/" + nomeBanco + ".txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linha;
		LinkedList<Usuario> lista = new LinkedList<Usuario>();
		String[] textoSeparado;
		try {
			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				Usuario usuario = new Usuario();
				usuario.setNomeUsuario(textoSeparado[0]);
				usuario.setSenha(textoSeparado[1]);
				lista.add(usuario);
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

	@Override
	public Usuario buscarPorNomeUsuario(String nomeUsuario) {

		List<Usuario> lista = new LinkedList<Usuario>();
		List<Contato> listaContato = new LinkedList<Contato>();
		ServicoContatoImpl contato = new ServicoContatoImpl(nomeUsuario);
		Usuario usuario = new Usuario();
		lista = listarTodosUsuarios();
		int count = 0;

		while (count < lista.size()) {
			if (lista.get(count).getNomeUsuario().equals(nomeUsuario)) {
				usuario.setNomeUsuario(lista.get(count).getNomeUsuario());
				usuario.setSenha(lista.get(count).getSenha());
				listaContato = contato.listarTodosContatos();
				usuario.setContatos(listaContato);
			}
			count++;
		}
		return usuario;
	}

	@Override
	public boolean removerUsuario(Usuario u) {

		/*
		 * ================================ Verifica Existencia de Arquivo
		 * ===============================
		 */
		File file = new File("src/main/java/resources/" + nomeBanco + ".txt");

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Problema na leitura do arquivo users.txt", null, 2);
		}
		String newLine = System.getProperty("line.separator");
		Cesar cesar = new Cesar();
		String nomeUsuario = cesar.encriptar(3, u.getNomeUsuario());
		List<String> lista = new ArrayList<String>();
		List<String> lnome = new ArrayList<String>();
		int i = 0;
		int k = 0;

		try {
			String linha;
			String[] textoSeparado = null;
			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				lnome.add(textoSeparado[0]);
				lista.add(textoSeparado[0]);
				lista.add(textoSeparado[1]);

			}
		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(lnome);
		try {
			out = new FileWriter(file);
			out.write("");
			out.flush();
			out = new FileWriter(file.getAbsoluteFile(), true);
			
			if(lnome.size()==1) {
				UsuarioTxtExiste deleta = new UsuarioTxtExiste();
				deleta.deletaTxtData(nomeUsuario);
			}

			while (i < lnome.size()) {
				k = 0;
				while (k < lista.size()) {
					if (k == 0 || k % 2 == 0) {
						if (lnome.get(i).toString().equals(lista.get(k).toString())) {
							if (!lista.get(k).toString().equals(nomeUsuario)) {
								UsuarioTxtExiste deleta = new UsuarioTxtExiste();
								deleta.deletaTxtData(nomeUsuario);
								out.write(lista.get(k).toString() + ";" + lista.get(k + 1).toString() + ";" + newLine);
							}
						}
					}
					k++;
				}
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			reader.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual) {
		/*
		 * ================================ Verifica Existencia de Arquivo
		 * ===============================
		 */

		/*
		 * ================================ Da as permissoes de escrita no arquivo
		 * ===============================
		 */

		File file = new File("src/main/java/resources/" + nomeBanco + ".txt");

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Problema na leitura do arquivo users.txt", null, 2);
		}
		String newLine = System.getProperty("line.separator");

		/*
		 * ================================ Procedimento encriptação do nome e senha
		 * ===============================
		 */

		/*
		 * ================================ Procedimento de gravação em users.txt
		 * ===============================
		 */

		List<String> lista = new ArrayList<String>();
		List<String> lnome = new ArrayList<String>();
		try {
			String linha;
			String[] textoSeparado;

			int k = 0;
			int i = 0;

			while ((linha = reader.readLine()) != null) {
				textoSeparado = linha.split(";");
				lnome.add(textoSeparado[0]);
				lista.add(textoSeparado[0]);
				lista.add(textoSeparado[1]);
			}
			
			Cesar cesar = new Cesar();
			String antNomeEnc = cesar.encriptar(3, uAnt.getNomeUsuario());
			String antSenhaEnc = cesar.encriptar(3, uAnt.getNomeUsuario());
			
			lista.remove(antNomeEnc);
			lista.remove(antSenhaEnc);
			
			String uaNomeEnc = cesar.encriptar(3, uAtual.getNomeUsuario());
			String uaSenhaEnc = cesar.encriptar(3, uAtual.getNomeUsuario());
			UsuarioTxtExiste cria = new UsuarioTxtExiste();
			cria.criaTxtData(uaNomeEnc);
			cria.deletaTxtData(uAnt.getNomeUsuario());
			if (!lnome.contains(uaNomeEnc)) {
				lnome.add(uaNomeEnc);
				lista.add(uaNomeEnc);
				lista.add(uaSenhaEnc);
			}

			Collections.sort(lnome);

			out = new FileWriter(file);
			out.write("");
			out.flush();
			out = new FileWriter(file.getAbsoluteFile(), true);

			while (i < lnome.size()) {
				k = 0;
				while (k < lista.size()) {
					if (k == 0 || k % 2 == 0) {
						if (lnome.get(i).toString().equals(lista.get(k).toString())) {
							out.write(lista.get(k).toString() + ";" + lista.get(k + 1).toString() + newLine);
							break;
						}
					}
					k++;
				}
				i++;
			}
			out.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uAtual;
	}
}
