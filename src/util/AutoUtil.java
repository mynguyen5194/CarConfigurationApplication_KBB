package util;

import java.io.*;
import java.util.*;

import model.*;

public class AutoUtil {
	public AutoUtil() {}
	public Automotive readFile(String fileName) {
		Automotive auto = new Automotive();
		
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			boolean eof = false;
			int automotiveIndex = 0;
			int optionSetIndex = 0;
			
			while(!eof) {
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
						String name = str;
						auto.setOption(automotiveIndex, optionSetIndex, name, price);
//						System.out.printf(str + "\n");
						optionSetIndex++;
					}
					
				}
//				System.out.printf("\n\n");
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
