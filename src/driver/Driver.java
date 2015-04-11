package driver;

import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		AutoUtil util = new AutoUtil();
		
		Automotive auto = new Automotive(3, "Cars", 18500);
		
		auto = util.readFile("/Users/mynguyen5194/Documents/workspace/CarConfigurationApplication_KBB/FordZTW.txt");
		System.out.printf("\n\nYEAH\n\n");
		auto.printOptionSet();
		
		
		

	}

}
