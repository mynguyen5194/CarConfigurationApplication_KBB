package adapter;

import model.*;
import util.*;

public abstract class ProxyAutomobile implements CreateAuto, UpdateAuto {
	private static Automobile auto;
	
	public ProxyAutomobile() {}

	public static Automobile getAuto() {
		return auto;
	}
	public static void setAuto(Automobile auto) {
		ProxyAutomobile.auto = auto;
	}

	public void buildAuto(String fileName) {
		auto = new AutoUtil().readFile(auto, fileName);
	}
	
	//This function searches and prints the properties of a given Automodel.
	// ASSUME modelName IS optionName SO FAR
	public void printAuto(String modelName) {
		int optSetIndex = auto.findOptionSetIndex(modelName);
		
		if(optSetIndex != -1) {
			
		}
		
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {
		
		
		
		
	}
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) {
		
		
		
	}
}
