package p01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MenuMethods 
{
Scanner userInput = new Scanner(System.in);
	
	//method to generate the list from the txt file
	//reads the file line by line, splits the line into parts, and adds a new vehicle of the requisite type to the arraylist
	public ArrayList<Vehicle> generateList()
	{	
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		File vehicleFile = new File("res/vehicles.txt");

		try (Scanner fileReader = new Scanner(vehicleFile))
		{
			while (fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				// Split the line separate parts, trim any whitespace, and populate a set length array.
				// Doesn't matter if the full array is used or not as the switch statement will only use the parts it needs for the respective vehicle type
				String[] parts = new String[11];
				parts = line.split(";");
				for (int i = 0; i < parts.length; i++) 
		        {
		            parts[i] = parts[i].trim();
		        }
				
				//adds a new vehicle of the requisite type to the arraylist
				switch(parts[1])
					{
					case "Sedan":
						vehicles.add(new Sedan(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
											 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10]));
						break;
					case "Hatchback":
						vehicles.add(new Hatchback(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10]));
						break;
					case "SUV":
						vehicles.add(new SUV(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9])));
						break;
					case "Hybrid":
						vehicles.add(new Hybrid(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10],Integer.parseInt(parts[11])));
						break;
						case "Pickup Truck":
							vehicles.add(new PickupTruck(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10],Integer.parseInt(parts[11])));
						break;
					}		
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		// Return the now populated list
		return vehicles;
	}
	
	// Method to search for vehicles by vehicle type
	// Asks the user for a vehicle type if it is a valid type iterate through all the vehicles for that type
	// Uses the getDetails method to print out all of the details for the respective type of vehicle
	public void vehicleSearch(ArrayList<Vehicle> Vehicles)
	{
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String carType = userInput.nextLine().toUpperCase();
		
		// switch statement to check what type of vehicle the user inputed
		switch(carType)
		{
			case "SEDAN":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("SEDAN"))
					{
						System.out.println(((Sedan)vehicle).getDetails());
					}
				}
				break;
			case "SUV":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("SUV"))
					{
						System.out.println(((SUV)vehicle).getDetails());
					}
				}
				break;
			case "HATCHBACK":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("HATCHBACK"))
					{
						System.out.println(((Hatchback)vehicle).getDetails());
					}
				}
				break;
			case "PICKUP TRUCK":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("PICKUP TRUCK"))
					{
						System.out.println(((PickupTruck)vehicle).getDetails());
					}
				}
				break;
			case "HYBRID":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("HYBRID"))
					{
						System.out.println(((Hybrid)vehicle).getDetails());
					}
				}
				break;
			// default case if the user inputed an invalid vehicle type
			default:
				System.out.println("Invalid vehicle type, please input \"Sedan\", \"SUV\", \"Hatchback\", \"Pickup Truck\" or \"Hybrid\"");
				break;
		}
	}	

	// Method to search for vehicles by both vehicle type and subtype
	public void subtypeSearch(ArrayList<Vehicle> vehicles)
	{
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String carType = userInput.nextLine().toUpperCase();
		
		// Switch statement to check what type of vehicle the user inputed
		switch(carType)
		{
			case "SEDAN":
				System.out.print("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): ");
				String sedanType = userInput.nextLine().toUpperCase();

				carList : for (Vehicle vehicle : vehicles) {
					if(vehicle.getVehicleType().toUpperCase().equals("SEDAN"))
					{
						// Switch statement to check what type of sedan subtype the user inputed
						switch (sedanType) 
						{
							case "S":
								if (((Sedan)vehicle).getTrunkSize().toUpperCase().equals("S")) 
								{
									System.out.println(((Sedan)vehicle).getDetails());
								}
								break;
							case "M":
								if (((Sedan)vehicle).getTrunkSize().toUpperCase().equals("M"))
								{
									System.out.println(((Sedan)vehicle).getDetails());
								}
								break;
							case "L":
								if(((Sedan)vehicle).getTrunkSize().toUpperCase().equals("L"))
								{
									System.out.println(((Sedan)vehicle).getDetails());
								}
								break;
							default:
								System.out.println("Invalid sedan subtype.");
								break carList;
						}
					}
				}     
				break;

			case "SUV":
				System.out.print("Enter Drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive, FWD for Front Wheel Drive): ");
				String SUVType = userInput.nextLine().toUpperCase();

				carList : for (Vehicle vehicle : vehicles) {
					if(vehicle.getVehicleType().toUpperCase().equals("SUV"))
					{
						// Switch statement to check what type of SUV subtype the user inputed
						switch (SUVType) 
						{
							case "AWD":
								if (vehicle.getDrivetrain().toUpperCase().equals("AWD")) 
								{
									System.out.println(vehicle.getDetails());
								}
								break;
							case "4WD":
								if (vehicle.getDrivetrain().toUpperCase().equals("4WD"))
								{
									System.out.println(vehicle.getDetails());
								}
								break;
							case "FWD":
								if(vehicle.getDrivetrain().toUpperCase().equals("FWD"))
								{
									System.out.println(vehicle.getDetails());
								}
								break;
							default:
								System.out.println("Invalid SUV subtype.");
								break carList;
						}
					}
				}     
				break;
			case "HATCHBACK":
				System.out.print("Enter Hatchback Type (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
				String hatchbackType = userInput.nextLine().toUpperCase();
				carList : for (Vehicle vehicle : vehicles) {
					if(vehicle.getVehicleType().toUpperCase().equals("HATCHBACK"))
					{
						// Switch statement to check what type of hatchback subtype the user inputed
						switch (hatchbackType) 
						{
							case "S":
								if (((Hatchback)vehicle).getHatchType().toUpperCase().equals("S")) 
								{
									System.out.println(((Hatchback)vehicle).getDetails());
								}
								break;
							case "M":
								if (((Hatchback)vehicle).getHatchType().toUpperCase().equals("T"))
								{
									System.out.println(((Hatchback)vehicle).getDetails());
								}
								break;
							case "L":
								if(((Hatchback)vehicle).getHatchType().toUpperCase().equals("T"))
								{
									System.out.println(((Hatchback)vehicle).getDetails());
								}
								break;
							default:
								System.out.println("Invalid hatchback subtype.");
								break carList;
						}
					}
				}     
				break;
			case "PICKUP TRUCK":
				System.out.print("Enter Cargo Bed Type (SB for Short Bed, EB for Extended Bed, DB for Dump Bed): ");
				String bedType = userInput.nextLine().toUpperCase();
				carList : for (Vehicle vehicle : vehicles) {
					if(vehicle.getVehicleType().toUpperCase().equals("PICKUP TRUCK"))
					{
						// Switch statement to check what type of pickup truck subtype the user inputed
						switch (bedType) 
						{
							case "SB":
								if (((PickupTruck)vehicle).getCargoBed().toUpperCase().equals("SB")) 
								{
									System.out.println(((PickupTruck)vehicle).getDetails());
								}
								break;
							case "EB":
								if (((PickupTruck)vehicle).getCargoBed().toUpperCase().equals("EB"))
								{
									System.out.println(((PickupTruck)vehicle).getDetails());
								}
								break;
							case "DB":
								if(((PickupTruck)vehicle).getCargoBed().toUpperCase().equals("DB"))
								{
									System.out.println(((PickupTruck)vehicle).getDetails());
								}
								break;
							default:
								System.out.println("Invalid Pickup Truck subtype.");
								break carList;
						}
					}
				}     
				break;
			case "HYBRID":
				System.out.print("Enter Power Train Type (E for Series Hybrid, A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
				String powerTrainType = userInput.nextLine().toUpperCase();
				carList : for (Vehicle vehicle : vehicles) {
					if(vehicle.getVehicleType().toUpperCase().equals("HYBRID"))
					{
						// Switch statement to check what type of Hybrid subtype the user inputed
						switch (powerTrainType) 
						{
							case "E":
								if (((Hybrid)vehicle).getPowerTrain().toUpperCase().equals("E")) 
								{
									System.out.println(((Hybrid)vehicle).getDetails());
								}
								break;
							case "A":
								if (((Hybrid)vehicle).getPowerTrain().toUpperCase().equals("A"))
								{
									System.out.println(((Hybrid)vehicle).getDetails());
								}
								break;
							case "PHEV":
								if(((Hybrid)vehicle).getPowerTrain().toUpperCase().equals("PHEV"))
								{
									System.out.println(((Hybrid)vehicle).getDetails());
								}
								break;
							default:
								System.out.println("Invalid Hybrid subtype.");
								break carList;
						}
					}
				} 
				break;
			default:
				System.out.println("Invalid vehicle type, please input \"Sedan\", \"SUV\", \"Hatchback\", \"Pickup Truck\" or \"Hybrid\"");
				break;
		}
			
	}
	
	// Method to display a random vehicle from the list
	// Asks the user how many random vehicles they want to see
	// Prints out a random vehicle from the list for the number of times specified by the user
	// Checks what vehicles was grabbed and prints the details of the vehicle using the getDetails method for the respective type of vehicle
	public void randomVehicle(ArrayList<Vehicle> vehicleList)
	{
		Random rand = new Random();
		int length = vehicleList.size();

		System.out.print("Enter the number of vehicles to display: ");
		int vehicleCount = Integer.parseInt(userInput.nextLine());

		for(int i = 0; i < vehicleCount; i++)
		{
			int randomIndex = rand.nextInt(length);
			Vehicle vehicle = vehicleList.get(randomIndex);
			System.out.println(vehicle.getDetails());
		}
	}
	
	// Method to purchase a vehicle that is in stock
	// returns the updated array list after the vehicle has been purchased and quantity has been decremented by 1
	// If an invalid car id is entered send a message and exit the method.
	public ArrayList<Vehicle> purchaseVehicle(ArrayList<Vehicle> Vehicles)
	{
		boolean foundCar = false; 
		System.out.print("Enter Car ID: ");
		long carId = Long.parseLong(userInput.nextLine());
		
		loop : for(int i = 0; i < Vehicles.size(); i++)
		{
			Vehicle vehicle = Vehicles.get(i);
			if(vehicle.getCarId() == carId)
			{
				vehicle = vehicle.checkout(vehicle);
				// replaces current vehicle in the list with the updated vehicle that has the decremented quantity
				Vehicles.set(i, vehicle);
				foundCar = true;
				break loop;	
			}
		}
		
		if(foundCar == false)
		{
			System.out.println("Invalid Car ID, No car found.");
			return Vehicles;
		}
		else
		{
			return Vehicles;
		}
	}

	public void saveAndExit(ArrayList<Vehicle> Vehicles)
	{
		// Method to save the updated vehicle list to the text file before exiting the program
		File vehicleFile = new File("res/vehicles.txt");
		try (PrintWriter writer = new PrintWriter(vehicleFile))
		{
			for (Vehicle vehicle : Vehicles) 
			{
				writer.println(vehicle.toString());
			}
			System.out.println("Successfully wrote to vehicles.txt");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
