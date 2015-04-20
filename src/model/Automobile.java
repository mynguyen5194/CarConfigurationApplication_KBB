/*
 * Automotive class contains OptionSet array, optionSetName, and
 * basePrice. It also has many functions to access OptionSet and
 * Option classes
 */

package model;

import java.io.Serializable;

public class Automobile implements Serializable{
	// INSTANCE VARIABLES
	private OptionSet optionSet[];
	private String optionSetName;
	private float basePrice;
	
	
	// CONSTRUCTORS
	public Automobile() {}
	public Automobile(String OptionSetName, float BasePrice, int size) {
		optionSet = new OptionSet[size];
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new OptionSet();
		}
		
		optionSetName = OptionSetName;
		basePrice = BasePrice;
	}

	
	// SETTERS
	// (For OptionSet)
	public void setOptionSet(OptionSet[] optionSet) {
		this.optionSet = optionSet;
	}
	
	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}
	
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	// (For Option)
	// Set values of Option
	public void setOption(int optSetIndex, int optSize, String optName) {
		optionSet[optSetIndex] = new OptionSet(optSize, optName);
	}
	
	public void setOption(int optSetIndex, int optIndex, String Name, float Price) {
		optionSet[optSetIndex].setOption(optIndex, Name, Price);
	}
	
	
	// GETTERS
	public OptionSet[] getOptionSet() {
		return optionSet;
	}
	
	public String getOptionSetName() {
		return optionSetName;
	}
	
	public float getBasePrice() {
		return basePrice;
	}
	
	// Get an OptionSet based on index
	public OptionSet getOptionSet(int index) {
		return optionSet[index];
	}
	
	// Get an OptionSet based on name
	public OptionSet getOptionSet(String OptionSetName) {
		return optionSet[this.findOptionSetIndex(OptionSetName)];
	}
	
	// Get the array length of optionSet
	public int getLength() {
		return optionSet.length;
	}
	
	// Get an Option based on name
	public OptionSet.Option getOption(String Name) {
		OptionSet.Option opt = null;
		
		for(int i = 0 ; i < optionSet.length; i++) {
			int optSetIndex = optionSet[i].findOptionIndex(Name);
			
			if(optSetIndex != -1) {
				opt = optionSet[i].getOption(Name);
			}
		}
		
		return opt;
	}
	
	// Get Option name based on optSetIndex and optIndex
	public String getOptionName(int optSetIndex, int optIndex) {
		return optionSet[optSetIndex].getOption(optIndex).getName();
	}
	
	// Get Option name based on optSetIndex
	public String getOptionName(int optSetIndex) {
		return optionSet[optSetIndex].getOptionName();
	}
	
	// Get Option price based on optSetIndex and optIndex	
	public float getOptionPrice(int optSetIndex, int optIndex) {
		return optionSet[optSetIndex].getOption(optIndex).getPrice();
	}
	
	// Get an Option price based on name
	public float getOptionPrice(String optSetName) {
		return this.getOption(optSetName).getPrice();
	}
	
	// Get the array length of Option based on optSetIndex
	public int getOptionLength(int optSetIndex) {
		return optionSet[optSetIndex].getOption().length;
	}
	
	
	// FIND
	// Find optionSet index based on name
	public int findOptionSetIndex(String optName) {
		int index = -1;
		
		for(int i = 0; i < optionSet.length; i++) {
			if(optionSet[i].getOptionName().equals(optName)) {
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
			optSet = optionSet[index];
		}
		
		return optSet;
	}
	
	// Find Option index based on name
	public int findOptionIndex(String optName) {
		int index = -1;
		
		for(int i = 0; i < optionSet.length; i++) {
			index = optionSet[i].findOptionIndex(optName);
		}
		
		return index;
	}
	
	// Find and return optSetIndex and optIndex based on Name
	public int [] findIndex(String Name) {
		int index[] = new int[2];
		index[0] = -1;
		index[1] = -1;
		
		for(int i = 0; i < optionSet.length; i++) {
			if(optionSet[i].findOptionIndex(Name) != -1) {
				index[0] = i;
				index[1] = optionSet[i].findOptionIndex(Name);
			}
		}
		
		return index;
	}
	
	// Find Option based on name
	public OptionSet.Option findOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0; i < optionSet.length; i++) {
			option = optionSet[i].findOption(Name);
		}
		
		return option;
	}
	
	
	// UPDATE
	// Update new optionSet
	public boolean updateOptionSet(int index, OptionSet optSet) {
		boolean updated = false;
			
		if(index >= 0 && index < optionSet.length) {
			optionSet[index] = optSet;
			updated = true;
		}
			
		return updated;
	}
	
	// Update new Option name based on the old one 
	public boolean updateOptionName(String oldName, String newName) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.length; i++) {
			int optionSetIndex = optionSet[i].findOptionIndex(oldName);
				
			if(optionSetIndex != -1) {
				updated = optionSet[i].updateOptionName(oldName, newName);
			}
		}
			
		return updated;
	}
	
	// Update new Option price based on name
	public boolean updateOptionPrice(String Name, float newPrice) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.length; i++) {
			int optIndex = optionSet[i].findOptionIndex(Name);
				
			if(optIndex != -1) {
				updated = optionSet[i].updateOptionPrice(Name, newPrice);
			}
		}
			
		return updated;
	}
	
	// Update new name and new price of Option based on optionName and old name
	public boolean updateOption(String optName, String oldName, String newName, float newPrice) {
		boolean updated = false;
		int optSetIndex = this.findOptionIndex(optName);
		
		if(optSetIndex != -1) {	
			updated = optionSet[optSetIndex].updateOption(oldName, newName, newPrice);
		}
	
		return updated;
	}
	
	// Update new name and new price of optionSet based on old name
	public boolean updateOption(String oldName, String newName, float newPrice) {
		boolean updated = false;
		
		for(int i = 0; i < optionSet.length; i++) {
			int optIndex = optionSet[i].findOptionIndex(oldName);
			
			if(optIndex != -1) {
				updated = optionSet[i].updateOption(optIndex, newName, newPrice);
			}
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete an optionSet based on optionSet index
	public boolean deleteOption(int optSetIndex) {
		boolean deleted = false;
		
		if(optSetIndex >= 0 && optSetIndex < optionSet.length) {
			optionSet[optSetIndex] = null;
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
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i].printOption();
			System.out.printf("\n");
		}
	}
	
	// Print optionSet[] based on modelName
//	public void printOptionSet()
	
	// Print the option[] based on optSetIndex
	public void printOption(int optSetIndex) {
		if(optSetIndex >= 0 && optSetIndex < optionSet.length) {
			optionSet[optSetIndex].printOption();
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
		if(optSetIndex >= 0 && optSetIndex < optionSet.length) {
			optionSet[optSetIndex].printOption(optIndex);
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
