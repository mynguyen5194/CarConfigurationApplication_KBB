package model;

public class Automobile {
	private OptionSet optionSet[];
	private String optionSetName;
	
	public Automobile() {}
	public Automobile(int size, String OptionSetName) {
		optionSet = new OptionSet[size];
		for(int i = 0; i < optionSet.length; i++) {
			optionSet[i] = new OptionSet();
		}
		optionSetName = OptionSetName;
	}
	
	public OptionSet[] getOptionSet() {
		return optionSet;
	}
	public void setOptionSet(OptionSet[] optionSet) {
		this.optionSet = optionSet;
	}
	public String getOptionSetName() {
		return optionSetName;
	}
	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}
	
	public int findOption(String optionName) {
		int index = -1;
		
		
		
		return index;
	}
	
	public boolean updateOption(String optionName) {
		boolean updated = false;
		
		
	
		return updated;
	}
}
