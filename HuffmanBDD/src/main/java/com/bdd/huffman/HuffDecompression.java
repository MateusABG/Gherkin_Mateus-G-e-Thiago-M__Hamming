package com.bdd.huffman;


import java.util.Hashtable;
import java.io.*;

public class HuffDecompression {
	private String text;
	private String table;
	private String filename;
	Hashtable<String,Character> symbolTable = new Hashtable<String,Character>();

	public HuffDecompression( String text, String filename, String table){
		this.text = text;
		this.table = table;
		this.filename = filename;
		
	}


	public void decompress() throws IOException{
		

		System.out.println("Decoding text");

		int i = 1;
		
		while(text.charAt(i) != '}'){
			char aux;
			String aux2 = "";
			aux = table.charAt(i);
			i = i + 2;
			while(table.charAt(i) =='0' || table.charAt(i) == '1'){
				aux2 += table.charAt(i);
				i++;
			}
			symbolTable.put(aux2,aux);
			if (table.charAt(i) == '}') {i++;break;}
			i= i + 2;
		}
	

		String uncodedString = "";
		String aux = "";
		for(int j = 0; j< text.length();j++){
			aux += text.charAt(j);
			if(symbolTable.containsKey(aux)){
				uncodedString += symbolTable.get(aux);
				aux = "";	
			}
		}

		File file = new File(filename);
		file.createNewFile();

		System.out.println("Creating target file: " + filename);

		PrintWriter pw = new PrintWriter(filename);
		pw.write(uncodedString);
		pw.close();

		System.out.println(filename + " contains the decoded text");
	}



}

