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
	
	public void addAutoToLHM(Automobile auto) {
		new Fleet().setFleet(auto.getModel(), auto);
	}
}
