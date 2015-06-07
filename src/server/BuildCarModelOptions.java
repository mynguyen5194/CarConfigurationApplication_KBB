package server;

import model.*;

import java.util.*;

import util.FileIO;

public class BuildCarModelOptions {
	public static Automobile auto;
	
	public Automobile createAuto(Properties pro, String fileName) {
		auto = new FileIO().parsePropertiesFile(pro, fileName); 
		
		return auto;
	}
	
	public Fleet addAutoToLHM(Automobile auto) {
		Fleet fleet = new Fleet();
		
		fleet.setFleet(auto.getModel(), auto);
		
		return fleet;
	}
}
