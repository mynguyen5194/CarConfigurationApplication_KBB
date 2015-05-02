package adapter;

import model.*;
import util.*;
import exceptionHandler.*;

public abstract class ProxyAutomobile {
	private static Automobile auto;
//	private ExceptionHandler exception;
	
	public ProxyAutomobile() {}

	public static Automobile getAuto() {
		return auto;
	}
	public static void setAuto(Automobile auto) {
		ProxyAutomobile.auto = auto;
	}

	public void buildAuto(String fileName) {
//		try {
			AutoUtil autoUtil = new AutoUtil();
		
			auto = autoUtil.readFile(auto, fileName);
//			throw new ExceptionHandler(505);
//		}
//		
//		catch(ExceptionHandler e) {
//			this.fixProblem(e);
//		}		
	}
	
	//This function searches and prints the properties of a given modelName.
	public void printAuto(String modelName) {
		if(auto != null) {
			if(auto.getOptionSetName().equals(modelName)) {
				auto.printOptionSet();
			}
		}
		else {
			System.out.printf("* " + modelName + " is empty\n\n");
		}
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	public void updateOptionSetName(String modelName, String optSetName, String newName) {
		if(auto != null) {
			if(auto.getOptionSetName().equals(modelName)) {
				if(auto.getOptionSetName().equals(optSetName)) {
					auto.setOptionSetName(newName);
					System.out.printf("* " + newName + " is updated\n\n");
				}
			}
		}
		else {
			System.out.printf("* Unable to update " + modelName + "\n\n");
		}
	}
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.
	public void updateOptionPrice(String modelName, String optName, String name, float newPrice) {
		boolean updated = false;
		if(auto != null) {
			if(auto.getOptionSetName().equals(modelName)) {
				updated = auto.updateOptionPrice(name, newPrice);
			}
			
			if(updated == false) {
				System.out.printf("* " + name + " cannot be found\n" + "* Fail updating new price\n\n");
			}
			else {
				System.out.printf("* " + name + " is found\n" + "* Successfully updating new price\n\n");
			}
		}
	}
	
	public void fixProblem(ExceptionHandler exp) {
		exp.printmyproblem();
	}
}
