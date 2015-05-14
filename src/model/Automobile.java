/*
 * Automotive class contains OptionSet array, optionSetName, and
 * basePrice. It also has many functions to access OptionSet and
 * Option classes
 */

package model;

import java.util.*;
import java.io.Serializable;

public class Automobile implements Serializable{
	// INSTANCE VARIABLES
	private ArrayList<OptionSet> optionSet;
	private String optionSetName;
	private double basePrice;
//	
	private String maker;
	private String model;
	private OptionSet.Option choice;
	private LinkedHashMap<String, Automobile> optionSets;
	
	
	// CONSTRUCTORS
	public Automobile() {
		optionSets = new LinkedHashMap<String, Automobile>();
	}
	public Automobile(String OptionSetName, double BasePrice, int size) {
		optionSet = new ArrayList<> ();
		for(int i = 0; i < size; i++) {
			optionSet.add(i, new OptionSet());
		}
		
		optionSetName = OptionSetName;
		basePrice = BasePrice;
	}
	public Automobile(String OptionSetName, double BasePrice, int size, String Maker, String Model) {
		optionSet = new ArrayList<> ();
		for(int i = 0; i < size; i++) {
			optionSet.add(i, new OptionSet());
		}
		maker = Maker;
		model = Model;
		optionSets = new LinkedHashMap<String, Automobile>();
	}

	
	// SETTERS
	// (For OptionSet)
	public void setOptionSet(ArrayList<OptionSet> optionSet) {
		this.optionSet = optionSet;
	}
	
	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public void setMake(String maker) {
		this.maker = maker;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	
	// (For Option)
	// Set values of Option
	public void setOption(int optSetIndex, int optSize, String optName) {
		optionSet.set(optSetIndex, new OptionSet(optSize, optName));
	}
	
	public void setOption(int optSetIndex, int optIndex, String Name, double Price) {
		optionSet.get(optSetIndex).setOption(optIndex, Name, Price);
	}
	
	public void setOptionChoice(String optName, String Name) {
		
	}
	
	public void getOptionChoice(String optName) {
		
	}
	
//	
	public void getOptionChoicePrice(String Name) {
		
		
		
	}
	
	public double getTotalPrice() {
		double total = 0.0;
		
		
		
		return total;
	}
	
	
	// GETTERS
	public ArrayList<OptionSet> getOptionSet() {
		return optionSet;
	}
	
	public String getOptionSetName() {
		return optionSetName;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public String getMake() {
		return maker;
	}
	
	public String getModel() {
		return model;
	}
	
	// Get an OptionSet based on index
	public OptionSet getOptionSet(int index) {
		return optionSet.get(index);
	}
	
	// Get an OptionSet based on name
	public OptionSet getOptionSet(String OptionSetName) {
		return optionSet.get(this.findOptionSetIndex(OptionSetName));
	}
	
	// Get the array length of optionSet
	public int getSize() {
		return optionSet.size();
	}
	
	// Get an Option based on name
	public OptionSet.Option getOption(String Name) {
		OptionSet.Option opt = null;
		
		for(int i = 0 ; i < optionSet.size(); i++) {
			int optSetIndex = optionSet.get(i).findOptionIndex(Name);
			
			if(optSetIndex != -1) {
				opt = optionSet.get(i).getOptionChoice(Name);
			}
		}
		
		return opt;
	}
	
	// Get Option name based on optSetIndex and optIndex
	public String getOptionName(int optSetIndex, int optIndex) {
		return optionSet.get(optSetIndex).getOption(optIndex).getName();
	}
	
	// Get Option name based on optSetIndex
	public String getOptionName(int optSetIndex) {
		return optionSet.get(optSetIndex).getOptionName();
	}
	
	// Get Option price based on optSetIndex and optIndex	
	public double getOptionPrice(int optSetIndex, int optIndex) {
		return optionSet.get(optSetIndex).getOption(optIndex).getPrice();
	}
	
	// Get an Option price based on name
	public double getOptionPrice(String optSetName) {
		return this.getOption(optSetName).getPrice();
	}
	
	// Get the array length of Option based on optSetIndex
	public int getOptionSize(int optSetIndex) {
		return optionSet.get(optSetIndex).getOption().size();
	}
	
	
	// FIND
	// Find optionSet index based on name
	public int findOptionSetIndex(String optName) {
		int index = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
			if(optionSet.get(i).getOptionName().equals(optName)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find optionSet object based on OptionSet name
	public OptionSet findOptionSet(String optSetName) {
		OptionSet optSet = null;
		int index = this.findOptionSetIndex(optSetName);
		
		if(index != -1) {
			optSet = optionSet.get(index);
		}
		
		return optSet;
	}
	
	// Find Option index based on name
	public int findOptionIndex(String Name) {
		int index = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
			index = optionSet.get(i).findOptionIndex(Name);
		}
		
		return index;
	}
	
	// Find and return optSetIndex and optIndex based on Name
	public int [] findIndex(String Name) {
		int index[] = new int[2];
		index[0] = -1;
		index[1] = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
			int optIndex = optionSet.get(i).findOptionIndex(Name); 
			
			if(optIndex != -1) {
				index[0] = i;
				index[1] = optIndex;
			}
		}
		
		return index;
	}
	
	// Find Option based on name
	public OptionSet.Option findOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0; i < optionSet.size(); i++) {
			option = optionSet.get(i).findOption(Name);
		}
		
		return option;
	}
	
	
	// UPDATE
	// Update new optionSet
	public boolean updateOptionSet(int index, OptionSet optSet) {
		boolean updated = false;
			
		if(index >= 0 && index < optionSet.size()) {
			optionSet.get(index).equals(optSet);
			updated = true;
		}
			
		return updated;
	}
	
	// Update new Option name based on the old one 
	public boolean updateOptionName(String oldName, String newName) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.size(); i++) {
			int optSetIndex = optionSet.get(i).findOptionIndex(oldName);
				
			if(optSetIndex != -1) {
				updated = optionSet.get(i).updateOptionName(oldName, newName);
			}
		}
			
		return updated;
	}
	
	// Update new Option price based on name
	public boolean updateOptionPrice(String Name, double newPrice) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.size(); i++) {
			int optIndex = optionSet.get(i).findOptionIndex(Name);
				
			if(optIndex != -1) {
				updated = optionSet.get(i).updateOptionPrice(Name, newPrice);
			}
		}
			
		return updated;
	}
	
	// Update new name and new price of Option based on optionName and old name
	public boolean updateOption(String optName, String oldName, String newName, double newPrice) {
		boolean updated = false;
		int optSetIndex = this.findOptionIndex(optName);
		
		if(optSetIndex != -1) {
			updated = optionSet.get(optSetIndex).updateOption(oldName, newName, newPrice);
		}
	
		return updated;
	}
	
	// Update new name and new price of optionSet based on old name
	public boolean updateOption(String oldName, String newName, double newPrice) {
		boolean updated = false;
		
		for(int i = 0; i < optionSet.size(); i++) {
			int optIndex = optionSet.get(i).findOptionIndex(oldName);
			
			if(optIndex != -1) {
				updated = optionSet.get(i).updateOption(optIndex, newName, newPrice);
			}
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete an optionSet based on optionSet index
	public boolean deleteOption(int optSetIndex) {
		boolean deleted = false;
		
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			optionSet.set(optSetIndex, null);
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete an option based on Option name
	public boolean deleteOption(String optName) {
		boolean deleted = false;
		int optSetIndex = this.findOptionSetIndex(optName);
		if(optSetIndex != -1) {
			deleted = this.deleteOption(optSetIndex);
		}
		
		return deleted;
	}
	
	
	// PRINT
	// Print the whole optionSet[]
	public void printOptionSet() {
		System.out.printf("Option Set Name: " + this.optionSetName +
				"\nBase Price: " + this.basePrice + "\n\n");
		for(int i = 0; i < optionSet.size(); i++) {
			optionSet.get(i).printOption();
			System.out.printf("\n");
		}
	}
	
	// Print the option[] based on optSetIndex
	public void printOption(int optSetIndex) {
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			optionSet.get(optSetIndex).printOption();
		}
	}
	
	// Print the option[] based on optName
	public void printOption(String optName) {
		int optSetIndex = this.findOptionSetIndex(optName);
		
		if(optSetIndex != -1) {
			this.printOption(optSetIndex);
		}
	}
	
	// Print name and price based on optSetIndex and optIndex
	public void printNameAndPrice(int optSetIndex, int optIndex) {
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
			optionSet.get(optSetIndex).printOption(optIndex);
		}
	}
	
	// Print name and price based on Name
	public void printNameAndPrice(String Name) {
		int index[] = this.findIndex(Name);
		
		if(index[0] != -1 && index[1] != -1) {
			this.printNameAndPrice(index[0], index[1]);
		}
	}
}
