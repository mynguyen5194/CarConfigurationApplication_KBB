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



	public void searchAuto(String autoName) {
		Automobile auto = new Automobile();
		
		
		
	}
	
	public void removeAuto(String autoName) {
		
		
		
	}
}
