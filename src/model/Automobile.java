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
//	private OptionSet optionSet[];
	private ArrayList<OptionSet> optionSet;
	private String optionSetName;
	private float basePrice;
	
	
	// CONSTRUCTORS
	public Automobile() {}
	public Automobile(String OptionSetName, float BasePrice, int size) {
//		optionSet = new OptionSet[size];
		optionSet = new ArrayList<> (size);
		for(int i = 0; i < optionSet.size(); i++) {
//			optionSet[i] = new OptionSet();
			optionSet.set(i, new OptionSet());
		}
		
		optionSetName = OptionSetName;
		basePrice = BasePrice;
	}

	
	// SETTERS
	// (For OptionSet)
	public void setOptionSet(ArrayList<OptionSet> optionSet) {
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
//		optionSet[optSetIndex] = new OptionSet(optSize, optName);
		optionSet.get(optSetIndex).constructOptionSet(optSize, optName);
//		optionSet.get(optSetIndex).equals(new OptionSet(optSize, optName));
	}
	
	public void setOption(int optSetIndex, int optIndex, String Name, float Price) {
//		optionSet[optSetIndex].setOption(optIndex, Name, Price);
		optionSet.get(optSetIndex).setOption(optIndex, Name, Price);
	}
	
	
	// GETTERS
	public ArrayList<OptionSet> getOptionSet() {
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
//		return optionSet[index];
		return optionSet.get(index);
	}
	
	// Get an OptionSet based on name
	public OptionSet getOptionSet(String OptionSetName) {
//		return optionSet[this.findOptionSetIndex(OptionSetName)];
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
//			int optSetIndex = optionSet[i].findOptionIndex(Name);
			int optSetIndex = optionSet.get(i).findOptionIndex(Name);
			
			if(optSetIndex != -1) {
//				opt = optionSet[i].getOption(Name);
				opt = optionSet.get(i).getOption(Name);
			}
		}
		
		return opt;
	}
	
	// Get Option name based on optSetIndex and optIndex
	public String getOptionName(int optSetIndex, int optIndex) {
//		return optionSet[optSetIndex].getOption(optIndex).getName();
		return optionSet.get(optSetIndex).getOption(optIndex).getName();
	}
	
	// Get Option name based on optSetIndex
	public String getOptionName(int optSetIndex) {
//		return optionSet[optSetIndex].getOptionName();
		return optionSet.get(optSetIndex).getOptionName();
	}
	
	// Get Option price based on optSetIndex and optIndex	
	public float getOptionPrice(int optSetIndex, int optIndex) {
//		return optionSet[optSetIndex].getOption(optIndex).getPrice();
		return optionSet.get(optSetIndex).getOption(optIndex).getPrice();
	}
	
	// Get an Option price based on name
	public float getOptionPrice(String optSetName) {
		return this.getOption(optSetName).getPrice();
	}
	
	// Get the array length of Option based on optSetIndex
	public int getOptionSize(int optSetIndex) {
//		return optionSet[optSetIndex].getOption().size();
		return optionSet.get(optSetIndex).getOption().size();
	}
	
	
	// FIND
	// Find optionSet index based on name
	public int findOptionSetIndex(String optName) {
		int index = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
//			if(optionSet[i].getOptionName().equals(optName)) {
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
//			optSet = optionSet[index];
			optSet = optionSet.get(index);
		}
		
		return optSet;
	}
	
	// Find Option index based on name
	public int findOptionIndex(String Name) {
		int index = -1;
		
		for(int i = 0; i < optionSet.size(); i++) {
//			index = optionSet[i].findOptionIndex(Name);
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
			
//			if(optionSet[i].findOptionIndex(Name) != -1) {
			if(optIndex != -1) {
				index[0] = i;
//				index[1] = optionSet[i].findOptionIndex(Name);
				index[1] = optIndex;
			}
		}
		
		return index;
	}
	
	// Find Option based on name
	public OptionSet.Option findOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0; i < optionSet.size(); i++) {
//			option = optionSet[i].findOption(Name);
			option = optionSet.get(i).findOption(Name);
		}
		
		return option;
	}
	
	
	// UPDATE
	// Update new optionSet
	public boolean updateOptionSet(int index, OptionSet optSet) {
		boolean updated = false;
			
		if(index >= 0 && index < optionSet.size()) {
//			optionSet[index] = optSet;
			optionSet.get(index).equals(optSet);
			updated = true;
		}
			
		return updated;
	}
	
	// Update new Option name based on the old one 
	public boolean updateOptionName(String oldName, String newName) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.size(); i++) {
//			int optionSetIndex = optionSet[i].findOptionIndex(oldName);
			int optSetIndex = optionSet.get(i).findOptionIndex(oldName);
				
			if(optSetIndex != -1) {
//				updated = optionSet[i].updateOptionName(oldName, newName);
				updated = optionSet.get(i).updateOptionName(oldName, newName);
			}
		}
			
		return updated;
	}
	
	// Update new Option price based on name
	public boolean updateOptionPrice(String Name, float newPrice) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.size(); i++) {
//			int optIndex = optionSet[i].findOptionIndex(Name);
			int optIndex = optionSet.get(i).findOptionIndex(Name);
				
			if(optIndex != -1) {
//				updated = optionSet[i].updateOptionPrice(Name, newPrice);
				updated = optionSet.get(i).updateOptionPrice(Name, newPrice);
			}
		}
			
		return updated;
	}
	
	// Update new name and new price of Option based on optionName and old name
	public boolean updateOption(String optName, String oldName, String newName, float newPrice) {
		boolean updated = false;
		int optSetIndex = this.findOptionIndex(optName);
		
		if(optSetIndex != -1) {	
//			updated = optionSet[optSetIndex].updateOption(oldName, newName, newPrice);
			updated = optionSet.get(optSetIndex).updateOption(oldName, newName, newPrice);
		}
	
		return updated;
	}
	
	// Update new name and new price of optionSet based on old name
	public boolean updateOption(String oldName, String newName, float newPrice) {
		boolean updated = false;
		
		for(int i = 0; i < optionSet.size(); i++) {
//			int optIndex = optionSet[i].findOptionIndex(oldName);
			int optIndex = optionSet.get(i).findOptionIndex(oldName);
			
			if(optIndex != -1) {
//				updated = optionSet[i].updateOption(optIndex, newName, newPrice);
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
//			optionSet[optSetIndex] = null;
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
//			optionSet[i].printOption();
			optionSet.get(i).printOption();
			System.out.printf("\n");
		}
	}
	
	// Print optionSet[] based on modelName
//	public void printOptionSet()
	
	// Print the option[] based on optSetIndex
	public void printOption(int optSetIndex) {
		if(optSetIndex >= 0 && optSetIndex < optionSet.size()) {
//			optionSet[optSetIndex].printOption();
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
//			optionSet[optSetIndex].printOption(optIndex);
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
