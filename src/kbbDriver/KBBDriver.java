/*
 * Name: My Nguyen
 * Course: CIS 35B - 63Y
 * Assignment: #3
 * Data submitted: 05/16/2015
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

import adapter.*;
import scale.EditOptions;

public class KBBDriver extends BuildAuto {
	public static void main(String[] args) {
		KBBDriver driver = new KBBDriver();
		
		driver.buildFleet("FordZTW.txt");
//		
//		driver.addOptionChoice("Ford's Focus Wagon ZTW", "Transmission", "Manual");
//		driver.addOptionChoice("Ford's Focus Wagon ZTW", "Brakes/Traction Control", "ABS with Advance Trac");
//		driver.addOptionChoice("Ford's Focus Wagon ZTW","Power Moonroof", "Power Moonroof Present");
//		driver.printChoices("Ford's Focus Wagon ZTW");
//		driver.printTotalPrice("Ford's Focus Wagon ZTW");
//
//		driver.printFleet();

		// String [0] Model/oldModelName, String [1] newModelName, String [2] Name/oldName,
		// String [3] newName, String [4] newPrice = double
		
		String [] name = new String[5];
		name[0] = "Ford's Focus Wagon ZTW";
		name[1] = "Honda";
		name[2] = "Automatic";
		name[3] = "Automatic Transimission";
		name[4] = "130";
		
		ScaleThread t1 = new EditOptions(0, name);
		
//		try {
//			Thread.sleep(1000);
//			System.out.printf("Sleeping\n");
//		} catch(InterruptedException e) {
//		
//		}
		
		EditOptions t2 = new EditOptions(0, name);

		
		
//		driver.printFleet();		
	}
}

/*
 * OUTPUT:
Done!

	***Chosen Option***
Model: Ford's Focus Wagon ZTW
   Manual	-815.0
   ABS with Advance Trac	1625.0
   Power Moonroof Present	595.0
********************************
Model: Ford's Focus Wagon ZTW
Total Price: 19850.0
********************************
********************************
Model: Ford's Focus Wagon ZTW
Maker: Ford
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
   Air Bags Present	350.0 
   Air Bags Not Present	0.0 

Option Name: Power Moonroof
   Power Moonroof Present	595.0 
   Power Moonroof Not Present	0.0 

********************************
********************************
Model: Honda Accord 2001
Maker: Honda
Base Price: 20000.0

Option Name: Color
   Basque Red Pearl II	0.0 
   Hematite Metallic	0.0 
   Obsidian Blue Pearl	0.0 
   Crystal Black Pearl	0.0 
   Modern Steel Metallic	0.0 
   White Orchid Pearl	0.0 
   Alabaster Silver Metallic	0.0 

Option Name: Transmission
   Automatic	0.0 
   Manual	-815.0 

Option Name: Brakes/Traction Control
   Standard	0.0 
   ABS	400.0 
   ABS with Advance Trac	1625.0 

Option Name: Side Impact Air Bags
   Air Bags Present	350.0 
   Air Bags Not Present	0.0 

Option Name: Power Moonroof
   Power Moonroof Present	405.0 
   Power Moonroof Not Present	0.0 

********************************
 */
