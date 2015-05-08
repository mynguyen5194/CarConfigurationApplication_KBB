/*
 * Option is the inner class, which contains name and price, of
 * the OptionSet class. The OptionSet class has the Option array
 * and optionName.
 */

package model;

import java.util.*;
import java.io.Serializable;

public class OptionSet implements Serializable {
	protected class Option implements Serializable {
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
			
			str.append(name + "\t");
			str.append(price);
			
			System.out.printf("   " + str + " ");
		}
	}
	
	// INSTANCE VARIABLES
	private ArrayList<Option> option;
	private String optionName;
	
	
	// CONSTRUCTORS
	public OptionSet() {}
	
	public OptionSet(int size) {
		option = new ArrayList<> (size);
		for(int i = 0; i < size; i++) {
			option.set(i, new Option());
		}
	}

	public OptionSet(int size, String OptionName) {
		option = new ArrayList<> ();
		
		for(int i = 0; i < size; i++) {
			option.add(i, new Option());	
		}
		
		optionName = OptionName;
	}
	
	protected void constructOptionSet(int size, String OptionName) {
		new OptionSet(size, OptionName);
	}
	

	// SETTERS
	protected void setOption(ArrayList<Option> option) {
		this.option = option;
	}
	
	protected void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	protected void setOption(int optIndex, String Name, float Price) {
		option.get(optIndex).setName(Name);
		option.get(optIndex).setPrice(Price);
	}
	
	protected void setOption(int optIndex, Option newOption) {
		option.set(optIndex, newOption);
	}
	
	protected void setOption(String Name, float Price) {
		this.setOption(this.findOptionIndex(Name), Name, Price);
	}
	
	
	// GETTERS
	protected ArrayList<Option> getOption() {
		return option;
	}

	protected String getOptionName() {
		return optionName;
	}
	
	// Get an Option based on index
	protected Option getOption(int optIndex) {
		return option.get(optIndex);
	}
	
	// Get an Option based on name
	protected Option getOption(String Name) {
		return option.get(this.findOptionIndex(Name));
	}

	
	// FIND
	// Find the Option index based on name
	protected int findOptionIndex(String Name) {
		int index = -1;
		
		for(int i = 0; i < option.size(); i++) {
			if(option.get(i).getName().equals(Name)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find the Option index based on name and price
	protected int findOptionIndex(String Name, float Price) {
		int index = -1;
		
		for(int i = 0; i < option.size(); i++) {
			if(option.get(i).getName().equals(Name)
					&& option.get(i).getPrice() == Price) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Find the Option index based on Option object
	protected int findOptionIndex(Option Option) {
		return this.findOptionIndex(Option.getName());
	}
	
	// Find and return the Option object based on name only
	protected Option findOption(String Name) {
		Option foundOption = new Option("", -1);
		int index = this.findOptionIndex(Name); 
		
		if(index != -1) {
			foundOption = option.get(index);
		}
		
		return foundOption;
	}
	
	// Find and return the Option object based on exact name and price
	protected Option findOption(String Name, float Price) {
		Option foundOption = new Option("", -1);
		int index = this.findOptionIndex(Name);
		
		if(index != -1 && option.get(index).getPrice() == Price) {
			foundOption = option.get(index);
		}
		
		return foundOption;
	}
	
	
	// UPDATE
	// Update new name and new price based on the index
	protected boolean updateOption(int index, String newName, float newPrice) {
		boolean updated = false;
		
		if(index >= 0 && index < option.size()) {
			this.setOption(index, newName, newPrice);
			updated = true;
		}
		
		return updated;
	}
	
	// Update new name and new price based on the old name
	protected boolean updateOption(String oldName, String newName, float newPrice) {
		boolean updated = false;
		int index = this.findOptionIndex(oldName);
		
		if(index != -1) {
			updated = this.updateOption(index, newName, newPrice);
		}
		
		return updated;
	}
	
	// Update new price and new price
	protected boolean updateOption(String oldName, Option newOption) {
		return this.updateOption(oldName, newOption.getName(), newOption.getPrice());
	}
	
	// Update new price based on name
	protected boolean updateOptionPrice(String Name, float newPrice) {
		boolean updated = false;
		int index = this.findOptionIndex(Name);
		
		if(index != -1) {
			updated = this.updateOption(index, Name, newPrice);
		}
		
		return updated;
	}
	
	// Update new name based on old name
	protected boolean updateOptionName(String oldName, String newName) {
		boolean updated = false;
		int index = this.findOptionIndex(oldName);
		
		if(index != -1) {
			updated = this.updateOption(index, newName, option.get(index).getPrice());
		}
		
		return updated;
	}
	
	
	// DELETE
	// Delete option based on index
	protected boolean deleteOption(int index) {
		boolean deleted = false;
		
		if(index >= 0 && index < option.size()) {
			option.set(index, null);
			deleted = true;
		}
		
		return deleted;
	}
	
	// Delete Option based on name
	protected boolean deleteOption(String Name) {
		return this.deleteOption(this.findOptionIndex(Name));
	}
	
	
	// PRINT
	// Print the whole option array
	protected void printOption() {
		System.out.printf("Option Name: " + this.optionName + "\n");
		for(int i = 0; i < option.size(); i++) {
			option.get(i).print();
			System.out.printf("\n");
		}
	}
	
	// Print name and price based on optIndex
	protected void printOption(int optIndex) {
		if(optIndex >= 0 && optIndex < option.size()) {
			option.get(optIndex).print();
		}
	}
	
	// Print name and price based on name
	protected void printOption(String Name) {
		int optIndex = this.findOptionIndex(Name);
		
		if(optIndex != -1) {
			option.get(optIndex).print();
		}
	}
}
