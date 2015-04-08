package model;

public class Automobile {
	private OptionSet optionSet[];
	private String name;
	
	public Automobile() {}
	public Automobile(int size, String Name) {
		optionSet = new OptionSet[size];
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new OptionSet();
		}
		name = Name;
	}
	
	public OptionSet[] getOptionSet() {
		return optionSet;
	}
	public void setOptionSet(OptionSet[] optionSet) {
		this.optionSet = optionSet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
