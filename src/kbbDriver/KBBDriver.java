/*
 * Name: My Nguyen
 * Course: CIS 35B - 63Y
 * Assignment: #1
 * Due date: 04/19/2015
 * Data submitted: 04/18/2015
 * 
 * This program builds a Ford's Focus Wagon ZTW model with these options:
 * - Color - Fort Knox Gold Clearcoat Metallic, Liquid Grey Clearcoat Metallic,
 *    Infra-Red Clearcoat, Grabber Green Clearcoat Metallic, Sangria Red Clearcoat
 *    Metallic, French Blue Clearcoat Metallic, Twilight Blue Clearcoat Metallic,
 *    CD Silver Clearcoat Metallic, Pitch Black Clearcoat, Cloud 9 White Clearcoat
 *    ($0.0 for all colors)
 * - Transmission - automatic ($0.00) or manual ($-815)
 * - Brakes/Traction Control - Standard ($0), ABS ($400), or ABS with Advance Trac ($1625)
 * - Side Impact Air Bags - present ($350) or not present ($0)
 * - Power Moonroof - present ($595) or not present ($0)
 * 
 * The program reads the file and saves the names and prices in the appropriate position. 
 * It then displays the Automotive object before and after serializing/deserializing
 */

package kbbDriver;

import model.*;
import util.*;
import adapter.*;

public class KBBDriver extends BuildAuto {
	public static void main(String[] args) {
		KBBDriver driver = new KBBDriver();
		
		driver.buildAuto("FordZTW.txt");
		
		driver.printAuto("Ford's Focus Wagon ZTW");
		
		driver.updateOptionPrice("Ford's Focus Wagon ZTW", "Color", "Infra-Red Clearcoat", 5000000);
		
		driver.printAuto("Ford's Focus Wagon ZTW");
		
//		Automobile auto = new Automobile();
//		Automobile newAuto = new Automobile();
//		AutoUtil autoUtil = new AutoUtil();
//		
//		auto = autoUtil.readFile(auto, "FordZTW.txt");
//		
//		System.out.printf("***Print Auto Before Serialization/Deserialization***\n");
//		auto.printOptionSet();
//		
//		autoUtil.serializeAuto(auto);
//		newAuto = autoUtil.deseriallizeAuto("Auto.ser");
//		
//		System.out.printf("***Print New Auto After Serialization/Deserialization***\n");
//		newAuto.printOptionSet();
	}
}