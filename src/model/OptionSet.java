package model;

public class OptionSet {
	protected class Option {
		private String name;
		private double price;
		
		public Option() {}
		public Option(String Name, double Price) {
			name = Name;
			price = Price;
		}
		
		private String getName() {
			return name;
		}
		private void setName(String name) {
			this.name = name;
		}
		private double getPrice() {
			return price;
		}
		private void setPrice(double price) {
			this.price = price;
		}
		
		private void display() {
			StringBuffer str = new StringBuffer();
			
			str.append(name + " ");
			str.append(price);
			
			System.out.printf(" " + str + " ");
		}
	}
	
	private Option option[];
	private String optionName;
	
	public OptionSet() {}
	public OptionSet(String OptionName) {
		optionName = OptionName;
	}
	public OptionSet(int size, String OptionName) {
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
	
	private int findOptionLocation(String name) {
		int location = -1;
		
		for(int i = 0; i < option.length; i++) {
			if(option[i].getName().equals(name)) {
				location = i;
			}
		}
		
		return location;
	}
	
	private Option findOption(String name) {
		Option foundOption = new Option();
		
		foundOption.setName("-1");
		foundOption.setPrice(-1);
		
		if(this.findOptionLocation(name) != -1) {
				foundOption = option[this.findOptionLocation(name)];
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
			deleted = this.updateOption(this.findOptionLocation(name), "", -1);
		}
		
		return deleted;
	}
}
