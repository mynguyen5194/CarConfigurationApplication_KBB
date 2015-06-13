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
	
	public Fleet addAutoToLHM(Automobile auto) {
		Fleet fleet = new Fleet();
		
		fleet.setFleet(auto.getModel(), auto);
		
		return fleet;
	}
}
