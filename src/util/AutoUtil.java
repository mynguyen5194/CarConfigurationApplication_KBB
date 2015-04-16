package util;

import java.io.*;
import java.util.*;
import model.*;

public class AutoUtil {
	public Automotive readFile(Automotive auto, String fileName) {		
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			
			// Get optSetName, basePrice, and autoSize
			String optSetName = reader.readLine();
			float basePrice = Float.parseFloat(reader.readLine());
			int optSetSize = Integer.parseInt(reader.readLine());
			
			auto = new Automotive(optSetName, basePrice, optSetSize);
				
			for(int optSetIndex = 0; optSetIndex < optSetSize; optSetIndex++) {
				// Get optSetName and optSetSize and construct a
				String optName = reader.readLine();
				int optSize = Integer.parseInt(reader.readLine());
				
				auto.setOption(optSetIndex, optSize, optName);
				
				for(int optIndex = 0; optIndex < optSize; optIndex++) {
					StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
					
					StringBuffer Name = new StringBuffer();
					
					Name.append(tokenizer.nextToken(","));
					float Price = Float.parseFloat(tokenizer.nextToken());
					
					auto.setOption(optSetIndex, optIndex, Name.toString(), Price);
				}			
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
	
	// Check if the string of date is an integer
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
