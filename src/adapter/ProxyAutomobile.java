package adapter;

import model.*;
import util.*;
import exceptionHandler.*;
import java.util.*;

public abstract class ProxyAutomobile {
//	private static Automobile auto;
	private static Fleet fleet;
	
	public ProxyAutomobile() {
		fleet = new Fleet();
	}

//	public static Automobile getAuto() {
//		return auto;
//	}
//	public static void setAuto(Automobile auto) {
//		ProxyAutomobile.auto = auto;
//	}
	
	public static void setFleet(Fleet fleet) {
		ProxyAutomobile.fleet = fleet;
	}
	
	public static Fleet getFleet() {
		return fleet;
	}

	
	public void buildFleet(String fileName) {
		AutoUtil autoUtil = new AutoUtil();	
		fleet = autoUtil.readFile(fleet, fileName);
	}
	
	

	//This function searches and prints the properties of a given modelName.
	public void printAuto(String Model) {
//		if(fleet.)
		
//		if(auto != null) {
//			if(auto.getModel().equals(modelName)) {
//				auto.printOptionSet();
//			}
//		}
//		else {
//			System.out.printf("* " + modelName + " is empty\n\n");
//		}
	}
	
	
	// Add choice to the Choices LinkedHashMap
	public void addOptionChoice(String model, String optName, String Name) {
		fleet.setOptionChoice(model, optName, Name);
//		auto.setOptionChoice(optName, Name);
	}
	
//	public void addAuto(String Model) {
//		fleet.setFleet(Model, auto);
//	}
	
	public double getTotalPrice(String Model) {
		return fleet.getModelTotalPrice(Model);
	}
	
	public void printFleet() {
		fleet.printFleet();
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	public void updateOptionSetName(String modelName, String optSetName, String newName) {
//		if(auto != null) {
//			if(auto.getModel().equals(modelName)) {
//				if(auto.getModel().equals(optSetName)) {
//					auto.setModel(newName);
//					System.out.printf("* " + newName + " is updated\n\n");
//				}
//			}
//		}
//		else {
//			System.out.printf("* Unable to update " + modelName + "\n\n");
//		}
	}
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.
	public void updateOptionPrice(String modelName, String optName, String name, double newPrice) {
//		boolean updated = false;
//		if(auto != null) {
//			if(auto.getModel().equals(modelName)) {
//				updated = auto.updateOptionPrice(name, newPrice);
//			}
//			
//			if(updated == false) {
//				System.out.printf("* " + name + " cannot be found\n" + "* Fail updating new price\n\n");
//			}
//			else {
//				System.out.printf("* " + name + " is found\n" + "* Successfully updating new price\n\n");
//			}
//		}
	}
	
	public void fixProblem(ExceptionHandler exp) {
		exp.printmyproblem();
	}
}
