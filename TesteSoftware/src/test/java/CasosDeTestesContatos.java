import static
org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import model.ContatoVerificador;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

public class CasosDeTestesContatos {

	@Test
	public void NomeTest1() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.nomeVerificador("");
		assertEquals(false, test);
	}

	@Test
	public void NomeTest2() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.nomeVerificador("     ");
		assertEquals(false, test);
	}

	@Test
	public void NomeTest3() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.nomeVerificador("@");
		assertEquals(false, test);
	}

	@Test
	public void NomeTest4() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.nomeVerificador("teste");
		assertEquals(true, test);
	}

	@Test
	public void TelefoneTest1() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("");
		assertEquals(false, test);
	}

	@Test
	public void TelefoneTest2() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("abcdefgh");
		assertEquals(false, test);
	}

	@Test
	public void TelefoneTest3() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("12345678@");
		assertEquals(false, test);
	}

	@Test
	public void TelefoneTest4() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("123451234512345123451");
		assertEquals(false, test);
	}

	@Test
	public void TelefoneTest5() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("1234567");
		assertEquals(false, test);
	}

	@Test
	public void TelefoneTest6() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("12345678");
		assertEquals(true, test);
	}

	@Test
	public void TelefoneTest7() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.telVerificador("12345123451234512345");
		assertEquals(true, test);
	}

	@Test
	public void EmailTest1() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("");
		assertEquals(false, test);
	}

	@Test
	public void EmailTest2() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("a");
		assertEquals(false, test);
	}

	@Test
	public void EmailTest3() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("1");
		assertEquals(false, test);
	}

	@Test
	public void EmailTest4() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("/");
		assertEquals(false, test);
	}

	@Test
	public void EmailTest5() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("a@1.1");
		assertEquals(false, test);
	}

	@Test
	public void EmailTest6() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("1@a.");
		assertEquals(false, test);
	}

	@Test
	public void EmailTest7() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.EmailVerificador("a@a.com");
		assertEquals(true, test);
	}

	@Test
	public void EnderecoTest1() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador("ab");
		assertEquals(false, test);
	}

	@Test
	public void EnderecoTest2() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador("judas perdeu as botas");
		assertEquals(false, test);
	}

	@Test
	public void EnderecoTest3() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador("casa da m�e joana");
		assertEquals(false, test);
	}

	@Test
	public void EnderecoTest4() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador("num sei");
		assertEquals(false, test);
	}

	@Test
	public void EnderecoTest5() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador("lugar nenhum");
		assertEquals(false, test);
	}

	@Test
	public void EnderecoTest6() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador("abc");
		assertEquals(true, test);
	}

	@Test
	public void EnderecoTest7() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(true, test);
	}
	
	@Test
	public void EnderecoTest8() {
		ContatoVerificador verificador = new ContatoVerificador();
		boolean test = verificador.endVerificador(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(false, test);
	}
}