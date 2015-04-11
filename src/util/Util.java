package util;

import java.io.*;
import java.util.*;
import model.*;

public class Util {
	public void readFile(String fileName) {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			boolean eof = false;
			
			while(!eof) {
				
				for(int i = 0; i < 5; i ++) {
					String line = reader.readLine();
					StringBuffer str = new StringBuffer();
					String name = "";
					float price = 0;
					
					if(line == null) {
						eof = true;
					}
					
					
					else {
						StringTokenizer tokenizer = new StringTokenizer(line);
						
						while(tokenizer.hasMoreTokens()) {
							
							String newToken = tokenizer.nextToken();
							
							if(isInteger(newToken) == false) {
								name = newToken;
								str.append(name + " ");
							}
							else {
								price = Float.parseFloat(newToken);
								System.out.printf(" " + price + " ");
							}
							
						}
					}
					System.out.printf(str + "\n");
				}
				System.out.printf("\n");
			}
			
			file.close();
			reader.close();
		}
		catch (IOException e) {
			System.out.printf("Error -- " + e.toString());
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
