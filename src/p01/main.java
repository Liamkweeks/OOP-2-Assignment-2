package p01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class main
{
	public static void main(String[] args)
	{
		MenuMethods menu = new MenuMethods(); 
		menuLoop : while(true)
		{
			ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
			vehicleList = menu.generateList();
			//scanner for user input
			Scanner userInput2 = new Scanner(System.in);
			
			System.out.print(String.format("%nWelcome to DriveMasters%nPlease choose any option below%n---------------------------------%n1\tPurchase Vehicle%n2\tDisplay Vehicles by Type%n3\tDisplay Vehicles by Subtype%n4\tProduce a Random List of Vehicles%n5\tSave & Exit%nEnter Option: "));
			
			String menuInput = userInput2.nextLine();
            
			switch (menuInput) {
                case "1":
                	vehicleList = menu.purchaseVehicle(vehicleList);
                    break;
                case "2":
                    menu.vehicleSearch(vehicleList);
                    break;
                case "3":
                    menu.subtypeSearch(vehicleList);
                    break;
                case "4":
                    menu.randomVehicle(vehicleList);
                    break;
                case "5":
                    System.out.println("You have chosen to save and exit. Goodbye!");
                    userInput2.close();
                    break menuLoop;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
		}
		
		
		
//TESTING AREA
//		
//		
//		for(Vehicle vehicle : Vehicles)
//		{
//		System.out.println(vehicle);
//		}
	}
	
}
		

          
	