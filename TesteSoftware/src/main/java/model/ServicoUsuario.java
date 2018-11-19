/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public interface ServicoUsuario {
	public Usuario inserir(Usuario u);

	public Usuario inserir(String nomeUsuario, String senha, List<Contato> contatos);

	/*
	 * Deve retornar um objeto completo, incluindo seus contatos.
	 */
	public Usuario buscarPorNomeUsuario(String nomeUsuario);

	/*
	 * A remo��o de um usu�rio deve remover os contatos associados, via chamada de
	 * servi�o de contatos.
	 */
	public boolean removerUsuario(Usuario u);

	/*
	 * Uma atualiza��o de usu�rio pode, por exemplo, simplesmente alterar os seus
	 * contatos, afetando a lista do objeto e os arquivos de dados.
	 */
	public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual);

	/*
	 * monta uma lista de objetos completos de usu�rio, contendo inclusive todos os
	 * contatos de cada usu�rio
	 */
	public List<Usuario> listarTodosUsuarios();
}
