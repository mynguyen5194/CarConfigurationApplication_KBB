package model;

public class Automotive {
	// INSTANCE VARIABLES
	private OptionSet automotive[] = new OptionSet[5];
	private String automotiveName;
	private float basePrice;
	
	
	// CONSTRUCTORS
	public Automotive() {
		for(int i = 0; i < automotive.length; i++) {
			automotive[i] = new OptionSet();
		}
	}
	public Automotive(int size, String AutomotiveName, float BasePrice) {
		automotive = new OptionSet[size];
		for(int i = 0; i < automotive.length; i++) {
			automotive[i] = new OptionSet();
		}
		automotiveName = AutomotiveName;
		basePrice = BasePrice;
	}
	
	
	// SETTERS
	public void setAutomotive(OptionSet[] automotive) {
		this.automotive = automotive;
	}
	
	public void setAutomotiveName(String automotiveName) {
		this.automotiveName = automotiveName;
	}
	
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	// Set values of OptionSet
	public void setOptionSet(int index, OptionSet optionSet) {
		automotive[index] = optionSet;
	}
	
	// Set values of Option (in context of OptionSet)
	public void setOption(int automotiveIndex, int optionSetIndex, String Name, float Price) {
		automotive[automotiveIndex].setOption(optionSetIndex, Name, Price);
	}
	
	
	// GETTERS
	public OptionSet[] getAutomotive() {
		return automotive;
	}
	
	public String getAutomotiveName() {
		return automotiveName;
	}
	
	public float getBasePrice() {
		return basePrice;
	}
	
	// Get an OptionSet based on index
	public OptionSet getOptionSet(int index) {
		return automotive[index];
	}
	
	// Get an OptionSet based on name
	public OptionSet getOptionSet(String OptionSetName) {
		return automotive[this.findOptionSetIndex(OptionSetName)];
	}
	
	// Get an Option based on name
	public OptionSet.Option getOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0 ; i < automotive.length; i++) {
			int optionSetIndex = automotive[i].findOptionSetIndex(Name);
			
			if(optionSetIndex != -1) {
				option = automotive[i].getOption(Name);
			}
		}
		
		return option;
	}
	
	// Get an Option price based on name
	public float getOptionPrice(String OptionSetName) {
		return this.getOption(OptionSetName).getPrice();
	}
	
	
	// FIND
	// Find optionSet with name
	public int findOptionSetIndex(String OptionSetName) {
		int index = -1;
		
		for(int i = 0; i < automotive.length; i++) {
			if(automotive[i].getOptionSetName().equals(OptionSetName)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find Option with name (in context of OptionSet)
	public OptionSet.Option findOption(String Name) {
		OptionSet.Option option = null;
		
		for(int i = 0; i < automotive.length; i++) {
			option = automotive[i].findOption(Name);
		}
		
		return option;
	}
	
	
	// UPDATE
	// Update new name of optionSet based on old name
	public boolean updateOptionSetName(String oldName, String newName) {
		boolean updated = false;
			
		for(int i = 0; i < automotive.length; i++) {
			int optionSetIndex = automotive[i].findOptionSetIndex(oldName);
				
			if(optionSetIndex != -1) {
				updated = automotive[i].updateOptionName(oldName, newName);
			}
		}
			
		return updated;
	}
	
	// Update new name of optionSet based on old name
	public boolean updateOptionSetPrice(String Name, float newPrice) {
		boolean updated = false;
			
		for(int i = 0; i < automotive.length; i++) {
			int optionSetIndex = automotive[i].findOptionSetIndex(Name);
				
			if(optionSetIndex != -1) {
				updated = automotive[i].updateOptionPrice(Name, newPrice);
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
			int optionSetIndex = automotive[index].findOptionSetIndex(oldName);
			
			if(optionSetIndex != -1) {
				updated = automotive[index].updateOption(optionSetIndex, newName, newPrice);
			}
		}
	
		return updated;
	}
	
	// Update new name and new price of optionSet based on old name
	public boolean updateOptionSet(String oldName, String newName, float newPrice) {
		boolean updated = false;
		
		for(int i = 0; i < automotive.length; i++) {
			int optionSetIndex = automotive[i].findOptionSetIndex(oldName);
			
			if(optionSetIndex != -1) {
				updated = automotive[i].updateOption(optionSetIndex, newName, newPrice);
			}
		}
		
		return updated;
	}

	// Update values of Automotive
	public boolean updateAutomotive(int index, OptionSet optionSet) {
		boolean updated = false;
		
		if(index >= 0 && index < automotive.length) {
			automotive[index] = optionSet;
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
			automotive[index] = null;
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete an option based on name
	public boolean deleteOption(String Name) {
		boolean deleted = false;
		
		for(int i = 0; i < automotive.length; i++) {
			int optionSetIndex = automotive[i].findOptionSetIndex(Name);
			
			if(optionSetIndex != -1) {
				deleted = automotive[i].deleteOption(Name);
			}
		}
		
		return deleted;
	}
	
	
	// PRINT
	public void printOptionSet() {
		for(int i = 0; i < automotive.length; i++) {
			automotive[i].printOption();
			System.out.printf("\n");
		}
	}
}
