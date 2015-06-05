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
				double basePrice = Double.parseDouble(pro.getProperty("BasePrice"));
				int optSetSize = Integer.parseInt(pro.getProperty("ColorOptionNumber"));
				
				auto = new Automobile(model, maker, basePrice, optSetSize);
				
				String color = pro.getProperty("ColorOptionName");
				auto.setOptionName(0, color);
				int colorOptionSize = Integer.parseInt(pro.getProperty("ColorOptionSize"));
				
				for(int optIndex = 0; optIndex < colorOptionSize; optIndex++) {
					String colorOption = pro.getProperty("ColorOption");
					double colorPrice = Double.parseDouble(pro.getProperty("ColorOptionPrice"));
					
					auto.setOption(0, optIndex, colorOption, colorPrice);
				}
				
				String transmission = pro.getProperty("TransmissionOptionName");
				auto.setOptionName(1, transmission);
				int transmissionOptionSize = Integer.parseInt(pro.getProperty("TransmissionOptionSize"));
			
				for(int optIndex = 0; optIndex < transmissionOptionSize; optIndex++) {
					String transmissionOption = pro.getProperty("TransmissionOption");
					double transmissionPrice = Double.parseDouble(pro.getProperty("TransmissionOptionPrice"));
					
					auto.setOption(0, optIndex, transmissionOption, transmissionPrice);
				}
				
				String break_tractionControl = pro.getProperty("Break_TractionControlOptionName");
				auto.setOptionName(2, break_tractionControl);
				int brakes_TractionControlOptionSize = Integer.parseInt(pro.getProperty("Brakes_TractionControlOptionSize"));
				
				for(int optIndex = 0; optIndex < brakes_TractionControlOptionSize; optIndex++) {
					String brakes_TractionControlOption = pro.getProperty("Break_tractionControlOption");
					double brakes_TractionControlPrice = Double.parseDouble(pro.getProperty("Break_tractionControlOptionPrice"));
					
					auto.setOption(0, optIndex, brakes_TractionControlOption, brakes_TractionControlPrice);
				}
				
				String sideAirBags = pro.getProperty("SideImpactAirBagsOptionName");
				auto.setOptionName(3, sideAirBags);
				int sideImpactAirBagsOptionSize = Integer.parseInt(pro.getProperty("SizeImpactAirBagsOptionSize"));
				
				for(int optIndex = 0; optIndex < sideImpactAirBagsOptionSize; optIndex++) {
					String sideImpactAirBagsOption = pro.getProperty("SideImpactAirBagsOption");
					double sideImpactAirBagsPrice = Double.parseDouble(pro.getProperty("SideImpactAirBagsOptionPrice"));
					
					auto.setOption(0, optIndex, sideImpactAirBagsOption, sideImpactAirBagsPrice);
				}
				
				String powerMoonroof = pro.getProperty("PowerMoonroofOptionName");
				auto.setOptionName(4, powerMoonroof);
				int powerMoonroofOptionSize = Integer.parseInt(pro.getProperty("PowerMoonroofOptionSize"));
				
				for(int optIndex = 0; optIndex < powerMoonroofOptionSize; optIndex++) {
					String powerMoonroofOption = pro.getProperty("PowerMoonroofOption");
					double powerMoonroofPrice = Double.parseDouble(pro.getProperty("PowerMoonroofOptionPrice"));
					
					auto.setOption(0, optIndex, powerMoonroofOption, powerMoonroofPrice);
				}
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
