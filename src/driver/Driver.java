package driver;

import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		AutoUtil util = new AutoUtil();
		
		Automotive auto = util.readFile("/Users/mynguyen5194/Documents/workspace/CarConfigurationApplication_KBB/FordZTW.txt");
		
		auto.printOptionSet();
		
		
		

	}

}
