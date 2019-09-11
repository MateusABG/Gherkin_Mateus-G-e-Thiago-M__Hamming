package huffman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.Test;

class FreqTableTest{
	FreqTable vazio = new FreqTable("");
	FreqTable charsAleatorios = new FreqTable("aaaabbbccd");
	FreqTable simbolosAleatorios = new FreqTable ("..**,,--^^");
	FreqTable espaçosEntrePalavras = new FreqTable ("texto com 3 espaços");
	FreqTable linhas = new FreqTable ("Tenha \nUm \nBom \nDia \nAmigo.");

	@Test
	void testVazia() {
		assertTrue(vazio.ft.isEmpty()); // Teste passou.
	}
	
	@Test
	void testCharacters() {
		Hashtable<Character,Double> ftTeste = new Hashtable<Character,Double>();
		ftTeste.put('a',4.0);
		ftTeste.put('b',3.0);
		ftTeste.put('c',2.0);
		ftTeste.put('d',1.0);
		assertEquals(ftTeste,charsAleatorios.getFT()); // Teste passou.
	}
	@Test
	void testSimbolos() {
		Hashtable<Character,Double> ftTeste = new Hashtable<Character,Double>();
		ftTeste.put('.',2.0);
		ftTeste.put('*',2.0);
		ftTeste.put(',',2.0);
		ftTeste.put('^',2.0);
		ftTeste.put('-',2.0);
		assertEquals(ftTeste,simbolosAleatorios.getFT()); // Teste passou.
	}
	@Test
	void testEspaços() {
		double expected = 3.0;
		double actual = espaçosEntrePalavras.getFT().get(' ');
		assertEquals(expected,actual ); // Teste passou.
	}
	@Test
	void testNroLinhas() {
		double expected = 4.0;
		double actual = linhas.getFT().get('\n');
		assertEquals(expected,actual ); // Teste passou.
	}
		
}

