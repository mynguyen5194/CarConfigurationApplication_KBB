package model;

public class Automotive {
	private OptionSet automotive[];
	private String automotiveName;
	private float basePrice;
	
	public Automotive() {}
	public Automotive(int size, String AutomotiveName, float BasePrice) {
		automotive = new OptionSet[size];
		for(int i = 0; i < automotive.length; i++) {
			automotive[i] = new OptionSet();
		}
		automotiveName = AutomotiveName;
		basePrice = BasePrice;
	}
	
	public OptionSet[] getAutomotive() {
		return automotive;
	}
	public void setAutomotive(OptionSet[] automotive) {
		this.automotive = automotive;
	}
	public String getAutomotiveName() {
		return automotiveName;
	}
	public void setAutomotiveName(String automotiveName) {
		this.automotiveName = automotiveName;
	}
	public float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	public int findOptionSetIndex(String OptionSetName) {
		int index = -1;
		
		for(int i = 0; i < automotive.length; i++) {
			if(automotive[i].getOptionSetName().equals(OptionSetName)) {
				index = i;
			}
		}
		
		return index;
	}
	
	// Update new optionSetName
	public boolean updateAutomotiveName(String oldOptionSetName, String newOptionSetName) {
		boolean updated = false;
		int index = this.findOptionSetIndex(oldOptionSetName);
		
		if(index != -1) {
			automotive[index].setOptionSetName(newOptionSetName);
			updated = true;
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
	
	// Delete automotive based on automotiveName
	public boolean deleteOptionSet(String automotiveName) {
		boolean deleted = false;
		int index = this.findOptionSetIndex(automotiveName);
		
		if(index != -1) {
			automotive[index] = null;
			deleted = true;
		}
		
		return deleted;
	}
	
	public void printOptionSet() {
		for(int i = 0; i < automotive.length; i++) {
			automotive[i].printOption();
			System.out.printf("\n");
		}
	}
}
