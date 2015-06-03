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
				
				String color = pro.getProperty("ColorOption");
				String transmission = pro.getProperty("TransmissionOption");
				String break_traction = pro.getProperty("Break_TractionControlOption");
				String sideAirBags = pro.getProperty("SideImpactAirBagsOption");
				String powerMoonroof = pro.getProperty("PowerMoonroofOption");
				
				String colorOption1 = pro.getProperty("ColorOption1");
				String colorOption2 = pro.getProperty("ColorOption2");
				String colorOption3 = pro.getProperty("ColorOption3");
				String colorOption4 = pro.getProperty("ColorOption4");
				String colorOption5 = pro.getProperty("ColorOption5");
				String colorOption6 = pro.getProperty("ColorOption6");
				String colorOption7 = pro.getProperty("ColorOption7");
				String colorOption8 = pro.getProperty("ColorOption8");
				String colorOption9 = pro.getProperty("ColorOption9");
				String colorOption10 = pro.getProperty("ColorOption10");
				
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
