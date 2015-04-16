package model;

public class OptionSet {
	protected class Option {
		private String name;
		private float price;
		
		public Option() {}
		public Option(String Name, float Price) {
			name = Name;
			price = Price;
		}
		
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected float getPrice() {
			return price;
		}
		protected void setPrice(float price) {
			this.price = price;
		}
		
		protected void print() {
			StringBuffer str = new StringBuffer();
			
			str.append(name + " ");
			str.append(price);
			
			System.out.printf(" " + str + " ");
		}
	}
	
	// INSTANCE VARIABLES
	private Option optionSet[];
	private String optionSetName;
	
	
	// CONSTRUCTORS
	public OptionSet() {}
	
	public OptionSet(int size) {
		optionSet = new Option[size];
		for(int i = 0; i < size; i++) {
			optionSet[i] = new Option();
		}
	}

	public OptionSet(int size, String OptionSetName) {
		optionSet = new Option [size];
		
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new Option();
		}
		
		optionSetName = OptionSetName;
	}
	
	// Return the initialized optionSet []
	protected Option [] constructNewOption(int size) {
		optionSet = new Option [size];
		
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new Option();
		}
		
		return optionSet;
	}

	// SETTERS
	protected void setOptionSet(Option[] optionSet) {
		this.optionSet = optionSet;
	}
	
	protected void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}
	
	protected void setOption(Option [] opt, int index, String name, float price) {
		opt[index].setName(name);
		opt[index].setPrice(price);
	}
	
	protected void setOption(int index, String name, float price) {
		optionSet[index].setName(name);
		optionSet[index].setPrice(price);
	}
	
	protected void setOption(int index, Option newOption) {
		optionSet[index] = newOption;
	}
	
	protected void setOptionSet(String name, float price) {
		this.setOption(this.findOptionSetIndex(name), name, price);
	}
	
	
	// GETTERS
	protected Option[] getOptionSet() {
		return optionSet;
	}
	
	protected String getOptionSetName() {
		return optionSetName;
	}
	
	// Get an Option based on index
	protected Option getOption(int index) {
		return optionSet[index];
	}
	
	// Get an Option based on name
	protected Option getOption(String Name) {
		return optionSet[this.findOptionSetIndex(Name)];
	}

	
	// FIND
	// Find the OptionSet index based on name only
	protected int findOptionSetIndex(String name) {
		int index = -1;
		
		for(int i = 0; i < optionSet.length; i++) {
			if(optionSet[i].getName().equals(name)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find the OptionSet index based on name and price
	protected int findOptionSetIndex(String Name, float Price) {
		int index = -1;
		
		for(int i = 0; i < optionSet.length; i++) {
			if((optionSet[i].getName().equals(Name)
					&& optionSet[i].getPrice() == Price)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find the OptionSet index based on Option object
	protected int findOptionSetIndex(Option Option) {
		return this.findOptionSetIndex(Option.getName(), Option.getPrice());
	}
	
	// Find and return the Option object based on name only
	protected Option findOption(String Name) {
		Option foundOption = new Option("", -1);
		int index = this.findOptionSetIndex(Name); 
		
		if(index != -1) {
			foundOption = optionSet[index];
		}
		
		return foundOption;
	}
	
	// Find and return the Option object based on exact name and price
	protected Option findOption(String Name, float Price) {
		Option foundOption = new Option("", -1);
		int index = this.findOptionSetIndex(Name);
		
		if(index != -1 && optionSet[index].getPrice() == Price) {
			foundOption = optionSet[index];
		}
		
		return foundOption;
	}
	
	
	// UPDATE
	// Update new name and new price at a specific location
	protected boolean updateOption(int index, String newName, float newPrice) {
		boolean updated = false;
		
		if(index < optionSet.length) {
			this.setOption(index, newName, newPrice);
			updated = true;
		}
		
		return updated;
	}
	
	// Update new name and new price based on old name
	protected boolean updateOption(String oldName, String newName, float newPrice) {
		boolean updated = false;
		int index = this.findOptionSetIndex(oldName);
		
		if(index != -1) {
			updated = this.updateOption(index, newName, newPrice);
		}
		
		return updated;
	}
	
	// Update new price and new price based on Option object
	protected boolean updateOption(String oldName, Option newOption) {
		return this.updateOption(oldName, newOption.getName(), newOption.getPrice());
	}
	
	// Update new price based on name
	protected boolean updateOptionPrice(String Name, float newPrice) {
		boolean updated = false;
		int index = this.findOptionSetIndex(Name);
		
		if(index != -1) {
			updated = this.updateOption(index, Name, newPrice);
		}
		
		return updated;
	}
	
	// Update new name based on old name
	protected boolean updateOptionName(String oldOptionName, String newOptionName) {
		boolean updated = false;
		int index = this.findOptionSetIndex(oldOptionName);
		
		if(index != -1) {
			updated = this.updateOption(index, newOptionName, optionSet[index].getPrice());
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete option based on index
	protected boolean deleteOption(int index) {
		boolean deleted = false;
		
		if(index >= 0 && index < optionSet.length) {
			optionSet[index] = null;
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete Option based on name
	protected boolean deleteOption(String Name) {
		return this.deleteOption(this.findOptionSetIndex(Name));
	}
	
	
	// PRINT
	protected void printOption() {
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i].print();
			System.out.printf("\n");
		}
	}
}
