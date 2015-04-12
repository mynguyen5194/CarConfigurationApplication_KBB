package util;

import java.io.*;
import java.util.*;

import model.*;

public class AutoUtil {
	public Automotive readFile(Automotive auto, String fileName) {		
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			boolean eof = false;
			int automotiveIndex = 0;
			int optionSetIndex = 0;
			
			while(!eof) {
				auto.constructNewOptionSet(automotiveIndex, 5);
				
				for(int i = 0; i < 5; i ++) {
					String line = reader.readLine();	// Get the whole line here
					StringBuffer strBuffer = new StringBuffer();
					String str = "";
					float price = 0;
					
					if(line == null) {
						eof = true;
					}
					else {		// Parse each element
						StringTokenizer tokenizer = new StringTokenizer(line);
						
						while(tokenizer.hasMoreTokens()) {
							
							String newToken = tokenizer.nextToken();
							
							if(isInteger(newToken) == false) {
								str = newToken;
								strBuffer.append(str + " ");
							}
							else {
								price = Float.parseFloat(newToken);
								
//								System.out.printf(" " + price + " ");
							}
						}
						String name = strBuffer.toString();
						
						auto.setOption(automotiveIndex, optionSetIndex, name, price);
//						System.out.printf(str + "\n");
						optionSetIndex++;
					}
					
				}
//				System.out.printf("\n\n");
				// NEED TO MAKE A NEW OPTIONSET ARRAY HERE
				automotiveIndex++;
			}
			
			file.close();
			reader.close();
		}
		catch (IOException e) {
			System.out.printf("Error -- " + e.toString());
		}
		
		return auto;
	}
	
	public void serializeAuto(Automotive auto) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Auto.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(auto);
			
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deseriallizeAuto(Automotive auto) {
		try{
			FileInputStream fileIn = new FileInputStream("Auto.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			Automotive[] newAuto = (Automotive[]) in.readObject();
			
			for(int i= 0 ; i < newAuto.length; i++) {
				System.out.printf(" " + newAuto[i]);
			}
			
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Check if the string is an integer
	public static boolean isInteger(String string) {
		boolean isInteger = true;
			
		try {
			Integer.parseInt(string);
		}
		catch (NumberFormatException ex) {
			isInteger = false;
		}
				
		return isInteger;
	}
}
