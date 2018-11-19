
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import static
org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import model.ServicoContato;
import model.ServicoContatoImpl;
import model.UsuarioTxtExiste;

import model.Contato;

public class MockServicoContatoImplTeste {

	@Mock
	private ServicoContato servicoContato;
	
	public MockServicoContatoImplTeste() {
		
		servicoContato = (ServicoContato) Mockito.mock(ServicoContatoImpl.class);
	}

	@Test
	public void testInserir() {
		UsuarioTxtExiste edita = new UsuarioTxtExiste();
		Contato c = new Contato();
		c.setNome("contato1");
		c.setTelefone("12345678");
		c.setEmail("ct@ct.com");
		c.setEndereco("av brasil");
		edita.criaTxtData("usuario1");
		Mockito.when(servicoContato.inserir("contato1", "12345678", "ct@ct.com", "av brasil")).thenReturn(c);
		assertEquals(c, servicoContato.inserir("contato1", "12345678", "ct@ct.com", "av brasil"));
		
	}
}