package driver;

import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		Automotive auto = new Automotive(5, "Cars", 18500);
		AutoUtil autoUtil = new AutoUtil();
		
		auto = autoUtil.readFile(auto, "/Users/mynguyen5194/Documents/workspace/CarConfigurationApplication_KBB/FordZTW.txt");
		
		System.out.printf("\n\nYEAH\n\n");
		
//		autoUtil.serializeAuto(auto);
//		autoUtil.deseriallizeAuto(auto);
		
//		auto.printOptionSet();
		
		
		

	}

}
