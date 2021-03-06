
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import static
org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.Cesar;


public class CesarTeste {

	@Test
	public void testEncriptar() {
		
		Cesar cesar = new Cesar();
		
		String palavra = cesar.encriptar(3, "abc");
		
		assertEquals("def" , palavra);
	}
	
	@Test
	public void testDecriptar() {
		
		Cesar cesar = new Cesar();
		
		String palavra = cesar.decriptar(3, "def");
		
		assertEquals("abc", palavra);
		
	}
}
