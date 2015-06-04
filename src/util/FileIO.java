package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import model.*;

public class FileIO {
	public void parsePropertiesFile(String fileName) {
		Automobile auto = new Automobile();
		
		Properties pro = new Properties();
		
		
		try {
			FileInputStream in = new FileInputStream(fileName);
			pro.load(in);
			 
			String maker = pro.getProperty("Maker");
			
			if(!maker.equals(null)) {
				String model = pro.getProperty("Model");
				String basePrice = pro.getProperty("BasePrice");
				
				String color = pro.getProperty("ColorOptionName");
				String transmission = pro.getProperty("TransmissionOptionName");
				String break_traction = pro.getProperty("Break_TractionControlOptionName");
				String sideAirBags = pro.getProperty("SideImpactAirBagsOptionName");
				String powerMoonroof = pro.getProperty("PowerMoonroofOptionName");
				
				String colorOptionNum = pro.getProperty("ColorOptionNumber");
				int index = Integer.parseInt(colorOptionNum);
				
				for(int i = 0; i < index; i++) {
					String colorOption = pro.getProperty("ColorOption");
					
				}
				
			
				
				auto.setMaker(maker);
				auto.setModel(model);
				auto.setBasePrice(Double.parseDouble(basePrice));
				
			
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
