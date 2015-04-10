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
	
	private Option optionSet[];
	private String optionSetName;
	
	public OptionSet() {}
	public OptionSet(int size, String OptionSetName) {
		optionSet = new Option [size];
		
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new Option();
		}
		
		optionSetName = OptionSetName;
	}
	
	public Option[] getOptionSet() {
		return optionSet;
	}
	public void setOptionSet(Option[] optionSet) {
		this.optionSet = optionSet;
	}
	public String getOptionSetName() {
		return optionSetName;
	}
	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}
	
	protected void setOption(int index, String name, float price) {
		optionSet[index].setName(name);
		optionSet[index].setPrice(price);
	}
	
	protected void setOptionSet(String name, float price) {
		int index = this.findOptionSetIndex(name);
		this.setOption(index, name, price);
	}
	
	protected void setOption(int index, Option newOption) {
		optionSet[index] = newOption;
	}
	
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
	
	// Delete Option based on name
	protected boolean deleteOption(String Name) {
		boolean deleted = false;
		int index = this.findOptionSetIndex(Name);
		
		if(index != -1) {
			optionSet[index] = null;
			deleted = true;
		}
		
		return deleted;
	}
	
	protected void printOption() {
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i].print();
			System.out.printf("\n");
		}
	}
}
