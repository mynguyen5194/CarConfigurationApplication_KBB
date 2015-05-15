package model;

import java.util.*;

public class Fleet {
	private LinkedHashMap<String, Automobile> fleet;	// String (key) = model
	
	
	// CONSTRUCTORS
	public Fleet() {
		fleet = new LinkedHashMap<String, Automobile>();
	}
	
	public Fleet(LinkedHashMap<String, Automobile> Fleet) {
		fleet = Fleet;
	}
	
	
	// SETTERS
	public void setFleet(LinkedHashMap<String, Automobile> fleet) {
		this.fleet = fleet;
	}
	
	public void setFleet(String model, Automobile auto) {
		fleet.put(model, auto);
	}
	
	
	// GETTERS
	public LinkedHashMap<String, Automobile> getFleet() {
		return fleet;
	}
	
	public Automobile getAuto(String Model) {
		Automobile auto = null;
		
		if(fleet.containsKey(Model)) {
			auto = fleet.get(Model);
		}
		
		return auto;
	}
	
	
	// SEARCH
	// Search and return automobile if found. Otherwise return null
	public Automobile searchAuto(String Model) {		
		return this.getAuto(Model);
	}
	
	
	// UPDATE
	public boolean updateAuto(String Model, Automobile newAuto) {
		boolean updated = false;
		
		if(fleet.containsKey(Model)) {
			fleet.replace(Model, newAuto);
			updated = true;
		}
		
		return updated;
	}
	
// NEED TO ADD MORE UPDATE OR SEARCH FUNCTION TO ACCESS optionSet or Option	
	
	public boolean removeAuto(String modelName) {
		boolean removed = false;
		
		if(fleet.containsKey(modelName)) {
			fleet.remove(modelName);
			removed = true;
		}
		
		return removed;
	}	
}
