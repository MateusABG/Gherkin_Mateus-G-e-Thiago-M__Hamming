package com.bdd.jbehave;

import java.util.Hashtable;

import org.jbehave.core.annotations.*; 

import com.bdd.huffman.FreqTable;

import junit.framework.Assert;

public class HuffmanSteps { 
		private String text;
		private FreqTable huff;
		private double numLinhas;
		private Hashtable<Character,Double> x;
		
	@Given( "Texto de entrada $texto")
	public void textoEntrada(String texto) { 
		this.text=texto;
		huff=new FreqTable(text);
		System.out.println("Frequence table iniciada,recebeu: "+text);
	}
	@When("Calcula a frequence table")
	public void textoEntrada2() {  
		this.x= huff.getFT();
		System.out.println("textoEntrada2 um ");
	}
	@Then("Sua hashtable deve ser $entrada")
	public void resultado(String entrada) { 
		System.out.println("resultado um "+entrada);
		System.out.println("resultado um "+x.toString());
		 
		Assert.assertEquals(entrada,x.toString() ); // Teste passou.
		
	}
}
