/*
 * Name: My Nguyen
 * Course: CIS 35B - 63Y
 * Assignment: #1
 * Data submitted: 05/02/2015
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

public class KBBDriver extends BuildAuto {
	public static void main(String[] args) {
		KBBDriver driver = new KBBDriver();
		
		driver.buildFleet("FordZTW.txt");
		
//		driver.printAuto("Ford's Focus Wagon ZTW");
//		driver.printAuto("Honda Accord 2001");
		
		driver.addOptionChoice("Ford's Focus Wagon ZTW", "Transmission", "Manual");
		driver.addOptionChoice("Ford's Focus Wagon ZTW", "Brakes/Traction Control", "ABS with Advance Trac");
//		driver.addOptionChoice("Ford's Focus Wagon ZTW","Power Moonroof", "Power Moonroof Present");
		
		System.out.printf("TOTAL PRICE: " + driver.getTotalPrice("Ford's Focus Wagon ZTW"));
		
//		driver.addAuto("Ford's Focus Wagon ZTW");
		driver.printFleet();
		
		
//		driver.addAuto("Ford's Focus Wagon ZTW");
		
		
//		driver.updateOptionPrice("Ford's Focus Wagon ZTW", "Color", "Liquid", 5000000.45);
//		driver.updateOptionPrice("Ford's Focus Wagon ZTW", "Color", "Power Moonroof Not Present", 5000000.15);
//		driver.updateOptionSetName("Ford's Focus Wagon ZTW", "Ford's Focus Wagon ZTW", "Honda Accord");
//		
//		driver.printAuto("Honda Accord");
	}
}

/*
 * OUTPUT:
 * 1) With Error
FixProblems [Error Number = 505, Error Message = No such file or directory]
Got here ---> Please Fix Problem Read From Console
Done!

* Ford's Focus Wagon ZTW is empty

* Unable to update Ford's Focus Wagon ZTW

* Honda Accord is empty 

 * 2) Without Error
Done!

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
   Air Bags Present	350.0 
   Air Bags Not Present	0.0 

Option Name: Power Moonroof
   Power Moonroof Present	595.0 
   Power Moonroof Not Present	0.0 

* Liquid cannot be found
* Fail updating new price

* Fort Knox Gold Clearcoat Metallic is found
* Successfully updating new price

* Honda Accord is updated

Option Set Name: Honda Accord
Base Price: 18445.0

Option Name: Color
   Fort Knox Gold Clearcoat Metallic	5000000.0 
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
   Power Moonroof Not Present	5000000.0 

 */
