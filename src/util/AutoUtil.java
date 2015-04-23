/*
 * AutoUtil class has three functions, including:
 * 	- readFile: reads the file and returns the Automotive object
 * 	- serializeAuto: serializes the Automotive object
 *  - deserializeAuto: reads the serialized file and return the
 *    Automotive object 
 */

package util;

import java.io.*;
import java.util.*;
import model.*;
import exceptionHandler.*;

public class AutoUtil {
	public Automobile readFile(Automobile auto, String fileName) {		
		
	boolean problemFixed = false;	
	ProblemGenerator newProblem = new ProblemGenerator("noneExitFileName.txt");
	newProblem.setFileName(fileName);
	
	do {
		try {
			problemFixed = newProblem.openFile();
			
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			
			
			// Get optSetName, basePrice, and autoSize and instantiate new Automotive
			String optSetName = reader.readLine();
			float basePrice = Float.parseFloat(reader.readLine());
			int optSetSize = Integer.parseInt(reader.readLine());
			
			auto = new Automobile(optSetName, basePrice, optSetSize);
				
			for(int optSetIndex = 0; optSetIndex < optSetSize; optSetIndex++) {
				// Get optSetName and optSetSize and instantiate new Option
				String optName = reader.readLine();
				int optSize = Integer.parseInt(reader.readLine());
				
				auto.setOption(optSetIndex, optSize, optName);
				
				for(int optIndex = 0; optIndex < optSize; optIndex++) {
					StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
					StringBuffer Name = new StringBuffer("");
					
					// Get the name and price and set them at the appropriate position
					Name.append(tokenizer.nextToken(","));
					float Price = Float.parseFloat(tokenizer.nextToken());
					
					auto.setOption(optSetIndex, optIndex, Name.toString(), Price);
				}	
			}
				
			file.close();
			reader.close();
	
		}
		catch(FileIOException r) {
//			newProblem.setFileName(r.fixProblemReadFromConsole());
			newProblem.processErrorNum(r);
		}
		catch (IOException e) {
			System.out.printf("Error -- " + e.toString() + "\n");
		}
	}
	while(problemFixed == false);

		return auto;
	}
	
	public void serializeAuto(Automobile auto) {
		try {
			FileOutputStream fileOut = new FileOutputStream("Auto.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(auto);
			
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Automobile deseriallizeAuto(String fileName) {
		Automobile newAuto = new Automobile();
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			newAuto = (Automobile) in.readObject();
			
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return newAuto;
	}
}
