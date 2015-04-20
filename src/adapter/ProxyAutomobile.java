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
	
	//This function searches and prints the properties of a given Automodel.
	// ASSUME modelName is optionName SO FAR
	public void printAuto(String modelName) {
//		auto.print
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	// ASSUME modelName = oldName
	public void updateOptionSetName(String modelName, String optSetName, String newName) {
		
	}
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.
	public void updateOptionPrice(String Modelname, String optionName, String option, float newPrice) {
		
		
		
	}
}
