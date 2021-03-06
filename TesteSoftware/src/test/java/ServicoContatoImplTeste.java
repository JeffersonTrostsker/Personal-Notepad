
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import static
org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.ServicoContatoImpl;
import model.UsuarioTxtExiste;

import java.util.LinkedList;
import java.util.List;

import model.Contato;

public class ServicoContatoImplTeste {

	@Test
	public void testInserir() {
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl("usuario1");
		ServicoContatoImpl editador = new ServicoContatoImpl("usuario1");
		UsuarioTxtExiste edita = new UsuarioTxtExiste();
		Contato c = new Contato();
		c.setNome("contato1");
		c.setTelefone("12345678");
		c.setEmail("ct@ct.com");
		c.setEndereco("av brasil");
		edita.criaTxtData("usuario1");
		assertEquals(c, classUnderTest.inserir("contato1", "12345678", "ct@ct.com", "av brasil"));
		editador.removerContato(c);
		edita.deletaTxtData("usuario1");
	}

	@Test
	public void testBuscarNome() {
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl("usuario1");
		ServicoContatoImpl editador = new ServicoContatoImpl("usuario1");
		UsuarioTxtExiste edita = new UsuarioTxtExiste();
		Contato c = new Contato();
		c.setNome("contato1");
		c.setTelefone("12345678");
		c.setEmail("ct@ct.com");
		c.setEndereco("av brasil");
		List<Contato> lista = new LinkedList<Contato>();
		lista.add(c);
		edita.criaTxtData("usuario1");
		editador.inserir("contato1", "12345678", "ct@ct.com", "av brasil");
		assertEquals(lista.size(), classUnderTest.buscarPorParteNome("cont").size());
		editador.removerContato(c);
		edita.deletaTxtData("usuario1");
	}

	@Test
	public void testRemover() {
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl("usuario1");
		ServicoContatoImpl editador = new ServicoContatoImpl("usuario1");
		UsuarioTxtExiste edita = new UsuarioTxtExiste();
		Contato c = new Contato();
		c.setNome("contato1");
		c.setTelefone("12345678");
		c.setEmail("ct@ct.com");
		c.setEndereco("av brasil");
		edita.criaTxtData("usuario1");
		editador.inserir("contato1", "12345678", "ct@ct.com", "av brasil");
		assertEquals(true, classUnderTest.removerContato(c));
		editador.removerContato(c);
		edita.deletaTxtData("usuario1");
	}
	
	@Test
	public void testAtualizar() {
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl("usuario1");
		ServicoContatoImpl editador = new ServicoContatoImpl("usuario1");
		UsuarioTxtExiste edita = new UsuarioTxtExiste();
		edita.criaTxtData("usuario1");
		Contato c = new Contato();
		c.setNome("contato2");
		c.setTelefone("12345678");
		c.setEmail("ct@ct.com");
		c.setEndereco("av brasil");
		Contato c2 = new Contato();
		c2 = editador.inserir("banana1", "987654321", "b@b.com", "rua b");
		assertEquals(c, classUnderTest.atualizarContato(c2, c));
		editador.removerContato(c);
		edita.deletaTxtData("usuario1");
	}
	
	@Test
	public void testListar() {
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl("usuario1");
		ServicoContatoImpl editador = new ServicoContatoImpl("usuario1");
		UsuarioTxtExiste edita = new UsuarioTxtExiste();
		List<Contato> lista = new LinkedList<Contato>();
		edita.criaTxtData("usuario1");
		Contato c = new Contato();
		c.setNome("contato1");
		c.setTelefone("12345678");
		c.setEmail("ct@ct.com");
		c.setEndereco("av brasil");
		lista.add(c);
		editador.inserir("contato1", "12345678", "ct@ct.com", "av brasil");
		assertEquals(lista.size(), classUnderTest.listarTodosContatos().size());
		editador.removerContato(c);
	}
}
