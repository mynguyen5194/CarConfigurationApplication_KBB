package model;

public class OptionSet {
	protected class Option {
		private String name;
		private double price;
		
		protected Option() {}
		protected Option(String Name, double Price) {
			name = Name;
			price = Price;
		}
		
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected double getPrice() {
			return price;
		}
		protected void setPrice(double price) {
			this.price = price;
		}
		
		protected void display() {
			StringBuffer str = new StringBuffer();
			
			str.append(name + " ");
			str.append(price);
			
			System.out.printf(" " + str + " ");
		}
	}
	
	private Option option[];
	private String optionName;
	
	protected OptionSet() {}
	protected OptionSet(String OptionName) {
		optionName = OptionName;
	}
	protected OptionSet(int size, String OptionName) {
		option = new Option [size];
		for(int i = 0; i < option.length; i++) {
			option[i] = new Option();
		}
		optionName = OptionName;
	}
	
	protected Option[] getOption() {
		return option;
	}
	protected void setOption(Option[] option) {
		this.option = option;
	}
	protected void setOption(int location, String name, double price) {
		option[location].setName(name);
		option[location].setPrice(price);
	}
	protected String getOptionName() {
		return optionName;
	}
	protected void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	private Option findOption(String name) {
		Option foundOption = new Option();
		
		foundOption.setName("-1");
		foundOption.setPrice(-1);
		
		for(int i = 0; i < option.length; i++) {
			if(option[i].getName().equals(name)) {
				foundOption = option[i];
			}
		}
		
		return foundOption;
	}
	
	private boolean updateOption(int location, String name, double price) {
		boolean updated = false;
		
		if(location < option.length) {
			this.setOption(option);
			updated = true;
		}
		
		return updated;
	}
	
	private boolean deleteOption(String name) {
		boolean deleted = false;
		
		if(!this.findOption(name).getName().equals("-1") && this.findOption(name).getPrice() != -1) {
			
		}
		
		return deleted;
	}
}
