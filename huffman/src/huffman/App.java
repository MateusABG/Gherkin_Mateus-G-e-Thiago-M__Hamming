package huffman;

import java.util.Hashtable;
import java.io.*;
import java.util.BitSet; 

public class App {
	
	public static void main(String[] args) throws Exception {
		

		if(args.length < 1) {System.out.println("-c <filename to compress> <compressed filename> <table filename>" + "\n-d <compressed filename> <decompressed filename> <table filename>");
System.exit(0);}

		if(args[0].equals("-c")){

			if(args.length < 4) {System.out.println("Not enough arguments"); System.exit(0);}
			File file = new File(args[1]); 
  
   			BufferedReader br = new BufferedReader(new FileReader(file));
	
   			String st = "";
			String aux;

			while((aux = br.readLine()) != null){
				st += aux;
				st += '\n';
			}


			FreqTable ft = new FreqTable(st);

			Hashtable<Character, Double> table = ft.getFT();

			//System.out.println(table.toString());
		
			HuffmanEncoding hf = new HuffmanEncoding(table);
		
			//System.out.println(hf.getCodeTable().toString());

			HuffCompress compressor = new HuffCompress(hf,st, args[2], args[3]);
			compressor.compress();			
		}else if(args[0].equals("-d")){
			if(args.length < 4) {System.out.println("Not enough arguments"); System.exit(0);}
			
			
			File file = new File(args[1]);

			File tableFile = new File(args[3]);

			BufferedReader br = new BufferedReader(new FileReader(tableFile));

			String table = "";
			String aux;

			while((aux = br.readLine()) != null){
				table += aux;
				table += '\n';
			}


			FileInputStream fin = null;
        	try {
            // create FileInputStream object
            fin = new FileInputStream(file);
 
            byte fileContent[] = new byte[(int)file.length()];
             
            // Reads up to certain bytes of data from this input stream into an array of bytes.
            fin.read(fileContent);
            //create string from byte array
            BitSet set = BitSet.valueOf(fileContent);

            String st = "";

            for(int i = 0; i <= set.length(); i++){
            	if(set.get(i)){
            		st += "1";
            	}else{
            		st += "0";
            	}
            }

            HuffDecompression decompressor = new HuffDecompression(st, args[2], table);
			decompressor.decompress();

       	    }
       		 catch (FileNotFoundException e) {
            	System.out.println("File not found" + e);
        	}
        	catch (IOException ioe) {
            	System.out.println("Exception while reading file " + ioe);
        	}
        	finally {
            // close the streams using close method
            	try {
                	if (fin != null) {
                    	fin.close();
                	}
            	}
            	catch (IOException ioe) {
                	System.out.println("Error while closing stream: " + ioe);
            	}
        	}

		}else{

			System.out.println("-c <filename to compress> <compressed filename> <table filename>" + "\n-d <compressed filename> <decompressed filename> <table filename");
		}
	
	}
	
}
