package model;

import java.util.*;

public class Fleet {
	private static LinkedHashMap<String, Automobile> fleet;
	
	public Fleet() {
		fleet = new LinkedHashMap<String, Automobile>();
	}
	
	public static LinkedHashMap<String, Automobile> getFleet() {
		return fleet;
	}

	public static void setFleet(LinkedHashMap<String, Automobile> fleet) {
		Fleet.fleet = fleet;
	}


	public Automobile searchAuto(String autoName) {
		Automobile auto = null;
				
		if(fleet.containsKey(autoName)) {
			auto = fleet.get(autoName);
		}
		
		return auto;
	}
	
	public boolean removeAuto(String autoName) {
		boolean removed = false;
		
		if(fleet.containsKey(autoName)) {
			fleet.remove(autoName);
			removed = true;
		}
		
		return removed;
	}
	
	public boolean updateAuto(String autoName, Automobile newAuto) {
		boolean updated = false;
		
		if(fleet.containsKey(autoName)) {
			fleet.replace(autoName, newAuto);
			updated = true;
		}
		
		return updated;
	}
}
