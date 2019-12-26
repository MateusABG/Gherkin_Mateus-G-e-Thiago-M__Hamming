package com.bdd.huffman;


import java.util.Hashtable;
import java.io.*;
import java.util.BitSet;

public class HuffCompress{
	
	private HuffmanEncoding hf;
	private String text;
	private String filename;
	private String tableFile;

	public HuffCompress(HuffmanEncoding hf, String text, String filename, String tableFile){
		this.hf = hf;
		this.text = text;
		this.filename = filename;
		this.tableFile = tableFile;
	}

	public void compress() throws IOException{


		System.out.println("Compressing text");
		
		char [] textC = text.toCharArray();
		Hashtable<Character, String> codeTable = hf.getCodeTable();
		String tableString = hf.getCodeTable().toString() + "\n";
		String encoded = "";
		

		for(int i = 0 ; i < textC.length; i++){
			encoded += codeTable.get(textC[i]);
		}

		BitSet bitSet = new BitSet(encoded.length());
		int bitcounter = 0;
		for(Character c : encoded.toCharArray()) {
    		if(c.equals('1')) {
        		bitSet.set(bitcounter);
    		}
    		bitcounter++;
		}

		File table = new File(tableFile);
		table.createNewFile();
		System.out.println("Creating table target file: " + tableFile);

		PrintWriter pw = new PrintWriter(tableFile);
		pw.write(tableString);
		pw.close();

		System.out.println(tableFile + " contains the table for decoding");


		File file = new File(filename);
		file.createNewFile();
		System.out.println("Creating compressed text target file: " + filename);

		FileOutputStream out1 = new FileOutputStream(filename);
		out1.write(bitSet.toByteArray());
		out1.close();

		System.out.println(filename + " contains the decoded text");	
	}

}

