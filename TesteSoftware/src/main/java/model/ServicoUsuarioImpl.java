/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public class ServicoUsuarioImpl implements ServicoUsuario {

	String nomeBanco;

	public ServicoUsuarioImpl(String nome_arq_dados_u) {
		this.nomeBanco = nome_arq_dados_u;
	}

	@Override
	public Usuario inserir(Usuario u) {

		/*
		 * ================================ Procedimento de verificação de requisito
		 * ===============================
		 */

		UsuarioDAOImpl cadastro = new UsuarioDAOImpl("users");

		u = cadastro.inserir(u);

		return u;
	}

	@Override
	public Usuario inserir(String nomeUsuario, String senha, List<Contato> contatos) {

		Usuario usuario = new Usuario();

		/*
		 * ================================ Procedimento de verificação de requisito
		 * ===============================
		 */

		UsuarioVerificador verificador = new UsuarioVerificador();

		boolean nomeTeste = verificador.verifica(nomeUsuario);
		boolean senhaTeste = verificador.verifica(senha);

		if (senhaTeste == true && nomeTeste == true) {

			usuario.setNomeUsuario(nomeUsuario);
			usuario.setSenha(senha);

			usuario = inserir(usuario);
		}
		return usuario;
	}

	@Override
	public Usuario buscarPorNomeUsuario(String nomeUsuario) {

		/*
		 * ================================ Procedimento de busca
		 * ===============================
		 */

		Usuario usuario = new Usuario();

		List<Usuario> listaBusca = new LinkedList<Usuario>();
		Cesar cesar = new Cesar();

		listaBusca = listarTodosUsuarios();
		int count = 0;
		while (count < listaBusca.size()) {
			String nome = cesar.encriptar(3, nomeUsuario);
			if (listaBusca.get(count).getNomeUsuario().toString().equals(nome)) {
				usuario.setNomeUsuario(listaBusca.get(count).getNomeUsuario());
				usuario.setSenha(listaBusca.get(count).getSenha());
				usuario.setContatos(listaBusca.get(count).getContatos());
			}
			count++;
		}
		return usuario;
	}

	@Override
	public boolean removerUsuario(Usuario u) {
		
		Cesar cesar = new Cesar();
		boolean deletado = false;
		List<Usuario> listar = new LinkedList<Usuario>();
		UsuarioDAOImpl arquivo = new UsuarioDAOImpl("users");
		listar = listarTodosUsuarios();
		String nomeEncriptado = cesar.encriptar(3, u.getNomeUsuario());
		for (int count = 0; count < listar.size(); count++) {
			if (listar.get(count).getNomeUsuario().equals(nomeEncriptado)) {
				deletado = arquivo.removerUsuario(u);
				break;
			}
		}

		return deletado;
	}

	@Override
	public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual) {
		UsuarioDAOImpl usuario = new UsuarioDAOImpl("users");
		uAtual = usuario.atualizarUsuario(uAnt, uAtual);

		return uAtual;
	}

	@Override
	public List<Usuario> listarTodosUsuarios() {

		UsuarioDAOImpl lista = new UsuarioDAOImpl("users");
		List<Usuario> listar = new LinkedList<Usuario>();
		List<Contato> listagem = new LinkedList<Contato>();
		listar = lista.listarTodosUsuarios();
		int count = 0;
		while (count < listar.size()) {
			ServicoContatoImpl servico = new ServicoContatoImpl(listar.get(count).getNomeUsuario());
			listagem = servico.listarTodosContatos();
			listar.get(count).setContatos(listagem);
			count++;
		}
		return listar;

	}
}
