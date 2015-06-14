package server;

import model.*;

import java.util.*;

import util.FileIO;

public class BuildCarModelOptions {
	public Automobile createAuto(Properties pro) {
		Automobile auto = new Automobile();
		
		auto = new FileIO().parsePropertiesFile(pro); 
		
		return auto;
	}
	
	public Fleet addAutoToLHM(Fleet fleet, Automobile auto) {
		fleet.setFleet(auto.getModel(), auto);
		
		return fleet;
	}
}
