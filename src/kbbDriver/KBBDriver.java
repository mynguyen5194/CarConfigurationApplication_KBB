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

public class KBBDriver {
	public static void main(String[] args) {
		Automobile auto = new Automobile();
		Automobile newAuto = new Automobile();
		AutoUtil autoUtil = new AutoUtil();
		
		auto = autoUtil.readFile(auto, "FordZTW.txt");
		
		System.out.printf("***Print Auto Before Serialization/Deserialization***\n");
		auto.printOptionSet();
		
		autoUtil.serializeAuto(auto);
		newAuto = autoUtil.deseriallizeAuto("Auto.ser");
		
		System.out.printf("***Print New Auto After Serialization/Deserialization***\n");
		newAuto.printOptionSet();
	}
}

/*
 * OUTPUT:
 * 
***Print Auto Before Serialization/Deserialization***
Option Set Name: Ford's Focus Wagon ZTW
Base Price: 18445.0

Option Name: Color
   Fort Knox Gold Clearcoat Metallic	0.0 
   Liquid Grey Clearcoat Metallic	0.0 
   Infra-Red Clearcoat	0.0 
   Grabber Green Clearcoat Metallic	0.0 
   Sangria Red Clearcoat Metallic	0.0 
   French Blue Clearcoat Metallic	0.0 
   Twilight Blue Clearcoat Metallic	0.0 
   CD Silver Clearcoat Metallic	0.0 
   Pitch Black Clearcoat	0.0 
   Cloud 9 White Clearcoat	0.0 

Option Name: Transmission
   Automatic	0.0 
   Manual	-815.0 

Option Name: Brakes/Traction Control
   Standard	0.0 
   ABS	400.0 
   ABS with Advance Trac	1625.0 

Option Name: Side Impact Air Bags
   Present	350.0 
   Not present	0.0 

Option Name: Power Moonroof
   Present	595.0 
   Not present	0.0 

***Print New Auto After Serialization/Deserialization***
Option Set Name: Ford's Focus Wagon ZTW
Base Price: 18445.0

Option Name: Color
   Fort Knox Gold Clearcoat Metallic	0.0 
   Liquid Grey Clearcoat Metallic	0.0 
   Infra-Red Clearcoat	0.0 
   Grabber Green Clearcoat Metallic	0.0 
   Sangria Red Clearcoat Metallic	0.0 
   French Blue Clearcoat Metallic	0.0 
   Twilight Blue Clearcoat Metallic	0.0 
   CD Silver Clearcoat Metallic	0.0 
   Pitch Black Clearcoat	0.0 
   Cloud 9 White Clearcoat	0.0 

Option Name: Transmission
   Automatic	0.0 
   Manual	-815.0 

Option Name: Brakes/Traction Control
   Standard	0.0 
   ABS	400.0 
   ABS with Advance Trac	1625.0 

Option Name: Side Impact Air Bags
   Present	350.0 
   Not present	0.0 

Option Name: Power Moonroof
   Present	595.0 
   Not present	0.0 


 */