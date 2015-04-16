package util;

import java.io.*;
import java.util.*;
import model.*;

public class AutoUtil {
	public Automotive readFile(Automotive auto, String fileName) {		
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			
			String autoName = reader.readLine();
			float basePrice = Float.parseFloat(reader.readLine());
			int autoSize = Integer.parseInt(reader.readLine());
			
			auto = new Automotive(autoName, basePrice, autoSize);
			
			int optSetSize = 0;
			String optSetName = "";
			String line = "";
			float Price = 0;
				
			for(int autoIndex = 0; autoIndex < autoSize; autoIndex++) {
				optSetName = reader.readLine();
				optSetSize = Integer.parseInt(reader.readLine());
				
				 auto.setOptionSet(autoIndex, optSetSize, optSetName);
				
				for(int optSetIndex = 0; optSetIndex < optSetSize; optSetIndex++) {
					line = reader.readLine();
					StringTokenizer tokenizer = new StringTokenizer(line);
					
					StringBuffer Name = new StringBuffer();
					
					Name.append(tokenizer.nextToken(","));
					Price = Float.parseFloat(tokenizer.nextToken());
					
					auto.setOption(autoIndex, optSetIndex, Name.toString(), Price);
					
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
