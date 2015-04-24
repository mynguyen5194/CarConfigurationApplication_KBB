package adapter;

import model.*;
import util.*;

public abstract class ProxyAutomobile {
	private static Automobile auto;
	
	public ProxyAutomobile() {}

	public static Automobile getAuto() {
		return auto;
	}
	public static void setAuto(Automobile auto) {
		ProxyAutomobile.auto = auto;
	}

	public void buildAuto(String fileName) {
		AutoUtil autoUtil = new AutoUtil();
		auto = autoUtil.readFile(auto, fileName);
	}
	
	//This function searches and prints the properties of a given modelName.
	public void printAuto(String modelName) {
		if(auto != null) {
			if(auto.getOptionSetName().equals(modelName)) {
				auto.printOptionSet();
			}
		}
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	public void updateOptionSetName(String modelName, String optSetName, String newName) {
		if(auto != null) {
			if(auto.getOptionSetName().equals(modelName)) {
				if(auto.getOptionSetName().equals(optSetName)) {
					auto.setOptionSetName(newName);
				}
			}
		}
	}
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.
	public void updateOptionPrice(String modelName, String optName, String name, float newPrice) {
		if(auto != null) {
			if(auto.getOptionSetName().equals(modelName)) {
				auto.updateOptionPrice(name, newPrice);
			}
		}
	}
}
