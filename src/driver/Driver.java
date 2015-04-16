package driver;

import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		Automotive auto = new Automotive("Cars", 18500, 5);
		AutoUtil autoUtil = new AutoUtil();
		
		auto = autoUtil.readFile(auto, "/Users/mynguyen5194/Documents/workspace/CarConfigurationApplication_KBB/FordZTW.txt");
		
		
//		autoUtil.serializeAuto(auto);
//		autoUtil.deseriallizeAuto(auto);
		
		auto.printOptionSet();
		
		
		

	}

}
