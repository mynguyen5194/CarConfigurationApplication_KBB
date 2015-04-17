package model;

import java.io.Serializable;

public class Automotive implements Serializable{
	// INSTANCE VARIABLES
	private OptionSet optionSet[];
	private String optionSetName;
	private float basePrice;
	
	
	// CONSTRUCTORS
	public Automotive() {}
	
	public Automotive(String OptionSetName, float BasePrice, int size) {
		optionSet = new OptionSet[size];
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new OptionSet();
		}
		
		optionSetName = OptionSetName;
		basePrice = BasePrice;
	}

	
	// SETTERS
	public void setOptionSet(OptionSet[] optionSet) {
		this.optionSet = optionSet;
	}
	
	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}
	
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	// Set values of OptionSet
	public void setOption(int optSetIndex, int optSize, String optName) {
		optionSet[optSetIndex] = new OptionSet(optSize, optName);
	}
	
	public void setOption(int autoIndex, int optIndex, String Name, float Price) {
		OptionSet opt = optionSet[autoIndex];
		opt.setOption(optIndex, Name, Price);
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
	
	// Get an Option based on name
	public OptionSet.Option getOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0 ; i < optionSet.length; i++) {
			int optionSetIndex = optionSet[i].findOptionIndex(Name);
			
			if(optionSetIndex != -1) {
				option = optionSet[i].getOption(Name);
			}
		}
		
		return option;
	}
	
	public String getOptionName(int optSetIndex, int optIndex) {
		return optionSet[optSetIndex].getOption(optIndex).getName();
	}
	public float getOptionPrice(int optSetIndex, int optIndex) {
		return optionSet[optSetIndex].getOption(optIndex).getPrice();
	}
	
	// Get an Option price based on name
	public float getOptionPrice(String OptionSetName) {
		return this.getOption(OptionSetName).getPrice();
	}
	
	public String getOptionName(int optIndex) {
		return optionSet[optIndex].getOptionName();
	}
	
	public int getOptionLength(int optIndex) {
		return optionSet[optIndex].getOption().length;
	}
	
	
	public int getLength() {
		return optionSet.length;
	}
	
	
	// FIND
	// Find optionSet with name
	public int findOptionSetIndex(String OptionSetName) {
		int index = -1;
		
		for(int i = 0; i < optionSet.length; i++) {
			if(optionSet[i].getOptionName().equals(OptionSetName)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find Option with name (in context of OptionSet)
	public OptionSet.Option findOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0; i < optionSet.length; i++) {
			option = optionSet[i].findOption(Name);
		}
		
		return option;
	}
	
	
	// UPDATE
	// Update new name of optionSet based on old name
	public boolean updateOptionSetName(String oldName, String newName) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.length; i++) {
			int optionSetIndex = optionSet[i].findOptionIndex(oldName);
				
			if(optionSetIndex != -1) {
				updated = optionSet[i].updateOptionName(oldName, newName);
			}
		}
			
		return updated;
	}
	
	// Update new name of optionSet based on old name
	public boolean updateOptionSetPrice(String Name, float newPrice) {
		boolean updated = false;
			
		for(int i = 0; i < optionSet.length; i++) {
			int optionSetIndex = optionSet[i].findOptionIndex(Name);
				
			if(optionSetIndex != -1) {
				updated = optionSet[i].updateOptionPrice(Name, newPrice);
			}
		}
			
		return updated;
	}
	
	// Update new name and new price of optionSet based on optionSetName and old name
	public boolean updateOptionSet(String optionSetName, String oldName, String newName, float newPrice) {
		boolean updated = false;
		
		// Find the index in the automotive[]
		int index = this.findOptionSetIndex(optionSetName);
		
		if(index != -1) {
			// Find the index in the optionSet[]
			int optionSetIndex = optionSet[index].findOptionIndex(oldName);
			
			if(optionSetIndex != -1) {
				updated = optionSet[index].updateOption(optionSetIndex, newName, newPrice);
			}
		}
	
		return updated;
	}
	
	// Update new name and new price of optionSet based on old name
	public boolean updateOptionSet(String oldName, String newName, float newPrice) {
		boolean updated = false;
		
		for(int i = 0; i < optionSet.length; i++) {
			int optionSetIndex = optionSet[i].findOptionIndex(oldName);
			
			if(optionSetIndex != -1) {
				updated = optionSet[i].updateOption(optionSetIndex, newName, newPrice);
			}
		}
		
		return updated;
	}

	// Update values of Automotive
	public boolean updateAutomotive(int index, OptionSet optSet) {
		boolean updated = false;
		
		if(index >= 0 && index < optionSet.length) {
			optionSet[index] = optSet;
			updated = true;
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete an optionSet based on automotiveName
	public boolean deleteOptionSet(String automotiveName) {
		boolean deleted = false;
		int index = this.findOptionSetIndex(automotiveName);
		
		if(index != -1) {
			optionSet[index] = null;
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete an option based on name
	public boolean deleteOption(String Name) {
		boolean deleted = false;
		
		for(int i = 0; i < optionSet.length; i++) {
			int optionSetIndex = optionSet[i].findOptionIndex(Name);
			
			if(optionSetIndex != -1) {
				deleted = optionSet[i].deleteOption(Name);
			}
		}
		
		return deleted;
	}
	
	
	// PRINT
	public void printOptionSet() {
		System.out.printf("Option Set Name: " + this.optionSetName +
				"\nBase Price: " + this.basePrice + "\n\n");
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i].printOption();
			System.out.printf("\n");
		}
	}
}
