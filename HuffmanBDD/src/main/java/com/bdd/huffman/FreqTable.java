package com.bdd.huffman;



import java.util.Hashtable;

public class FreqTable {

	public Hashtable<Character,Double> ft = new Hashtable<Character,Double>();
	private String text;



	public FreqTable(String text){
		this.text = text;
	}


	public Hashtable<Character, Double> getFT(){
		

		char  [] textC = text.toCharArray();

		for(int i = 0 ; i < textC.length; i++){

			Character key = textC[i];

			/*
			if(key.equals(' ')){
				continue;
			}
			*/
			if(ft.containsKey(key)){
				Double value = ft.get(key) + 1;

				ft.put(key, value);
			}else{
				ft.put(key, 1.0);
			}
		}

		return ft;
	}
	




}
