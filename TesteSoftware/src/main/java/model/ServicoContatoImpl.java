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
public class ServicoContatoImpl implements ServicoContato {
	
	String nomeUsuario;

	/*
	 * O construtor deve receber como parâmetro o nome do arquivo de dados de
	 * contatos (referente ao usuário específico carregado)
	 */
	public ServicoContatoImpl(String nome_arq_dados_c) {
		this.nomeUsuario = nome_arq_dados_c;
	}

	@Override
	public Contato inserir(String nome, String tel, String email, String end) {

		/*
		 * ================================ Verifica os requisitos de contato
		 * ================================
		 */
		Contato c = new Contato();
		ContatoVerificador verificador = new ContatoVerificador();

		boolean teste1 = verificador.nomeVerificador(nome);
		boolean teste2 = verificador.telVerificador(tel);
		boolean teste3 = verificador.EmailVerificador(email);
		boolean teste4 = verificador.endVerificador(end);

		c.setNome(nome);
		c.setTelefone(tel);
		c.setEmail(email);
		c.setEndereco(end);

		/*
		 * ================================ Caso todos os testes forem aceitos, chama o
		 * DAO ================================
		 */

		if (teste1 == true && teste2 == true && teste3 == true && teste4 == true) {
			ContatoDAOImpl inserir = new ContatoDAOImpl(nomeUsuario);
			inserir.inserir(c);
			return c;
		} else {
			return null;
		}
	}

	@Override
	public List<Contato> buscarPorParteNome(String parteNome) {

		ContatoDAOImpl busca = new ContatoDAOImpl(nomeUsuario);
		List<Contato> contatos = new LinkedList<Contato>();
		List<Contato> buscados = new LinkedList<Contato>();

		contatos = busca.listarTodosContatos();

		int count = 0;

		while (count < contatos.size()) {
			Contato contato = new Contato();
			if (contatos.get(count).getNome().toString().contains(parteNome)) {
				contato.setNome(contatos.get(count).getNome());
				contato.setTelefone(contatos.get(count).getTelefone());
				contato.setEmail(contatos.get(count).getEmail());
				contato.setEndereco(contatos.get(count).getEndereco());
				buscados.add(contato);
			}
			count++;
		}
		return buscados;

	}

	@Override
	public boolean removerContato(Contato c) {

		ContatoDAOImpl remover = new ContatoDAOImpl(nomeUsuario);
		boolean removido;
		removido = remover.removerContato(c);

		return removido;
	}

	@Override
	public Contato atualizarContato(Contato cAnt, Contato cAtual) {
		ContatoDAOImpl contato = new ContatoDAOImpl(nomeUsuario);
		ContatoVerificador verificador = new ContatoVerificador();

		boolean nomeTeste = verificador.nomeVerificador(cAtual.getNome());
		boolean telefoneTeste = verificador.telVerificador(cAtual.getTelefone());
		boolean emailTeste = verificador.EmailVerificador(cAtual.getEmail());
		boolean endTeste = verificador.endVerificador(cAtual.getEndereco());

		if (nomeTeste == true && telefoneTeste == true && emailTeste == true && endTeste == true) {
			contato.atualizarContato(cAnt, cAtual);
		}
		return cAtual;
	}

	@Override
	public List<Contato> listarTodosContatos() {

		ContatoDAOImpl listar = new ContatoDAOImpl(nomeUsuario);
		List<Contato> lista = new LinkedList<Contato>();

		lista = listar.listarTodosContatos();

		return lista;
	}

}
