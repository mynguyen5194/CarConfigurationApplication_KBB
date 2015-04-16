package driver;

import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		Automotive auto = new Automotive();
		AutoUtil autoUtil = new AutoUtil();
		
		auto = autoUtil.readFile(auto, "/Users/mynguyen5194/Documents/workspace/CarConfigurationApplication_KBB/FordZTW.txt");
		
		auto.printOptionSet();
		
		autoUtil.serializeAuto(auto);
//		autoUtil.deseriallizeAuto(auto);		

	}

}
