package model;

import java.util.*;

public class Fleet {
	private static Fleet fleet;
	
	public Fleet() {}

	public static Fleet getFleet() {
		return fleet;
	}

	public static void setFleet(Fleet fleet) {
		Fleet.fleet = fleet;
	}
	
	public void searchAuto(String autoName) {
		
	}
}
