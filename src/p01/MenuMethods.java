package p01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MenuMethods 
{
Scanner userInput = new Scanner(System.in);
	
	//list method
	public ArrayList<Vehicle> generateList()
	{	
		ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
		File VehicleFile = new File("res/vehicles.txt");
		try (Scanner fileReader = new Scanner(VehicleFile))
		{
			while (fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				
				// Split the line into parts and trim any whitespace.
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
						Vehicles.add(new Sedan(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
											 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10]));
						break;
					case "Hatchback":
						Vehicles.add(new Hatchback(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10]));
						break;
					case "SUV":
						Vehicles.add(new SUV(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9])));
						break;
					case "Hybrid":
						Vehicles.add(new Hybrid(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10],Integer.parseInt(parts[11])));
						break;
					case "Pickup Truck":
						Vehicles.add(new PickupTruck(Long.parseLong(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),Double.parseDouble(parts[4]),Integer.parseInt(parts[5]),
								 Integer.parseInt(parts[6]),parts[7],Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),parts[10],Integer.parseInt(parts[11])));
						break;
					}
					
						
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return Vehicles;
	}
	
	
	public void subtypeSearch(ArrayList<Vehicle> Vehicles)
	{
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String carType = userInput.nextLine().toUpperCase();
		
		switch(carType)
		{
		            case "SEDAN":
		                System.out.print("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk):");
		                String sedanType = userInput.nextLine().toUpperCase();
		                for (Vehicle vehicle : Vehicles) {
		                    if(vehicle.getVehicleType().toUpperCase().equals("SEDAN"))
		                    {
		                    String formattedTrunkSize = null;
		                        switch (sedanType) 
		                        {
		                            case "S":
		                                if (((Sedan)vehicle).getTrunkSize().toUpperCase().equals("S")) 
		                                {
		                                	formattedTrunkSize = "Small Trunk";
		                                	System.out.println(String.format(
		                							"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Trunk Size: %s %n",
		                							vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedTrunkSize));
		                                }
		                                break;
		                            case "M":
		                                if (((Sedan)vehicle).getTrunkSize().toUpperCase().equals("M"))
		                                {
		                                	formattedTrunkSize = "Moderate Trunk";
		                                	System.out.println(String.format(
		                							"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Trunk Size: %s %n",
		                							vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedTrunkSize));
		                                }
		                                break;
		                            case "L":
		                                if(((Sedan)vehicle).getTrunkSize().toUpperCase().equals("L"))
		                                {
		                                	formattedTrunkSize = "Large/Spacious Trunk";
		                                	System.out.println(String.format(
		                							"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Trunk Size: %s %n",
		                							vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedTrunkSize));
		                                }
		                                break;
		                            default:
		                                System.out.println("Invalid sedan type.");
		                        }
		                    }
		                }
		              
				break;
			case "SUV":
				for(Vehicle vehicle : Vehicles)
				{
				}
				break;
			case "HATCHBACK":
				for(Vehicle vehicle : Vehicles)
				{
				}
				break;
			case "PICKUP TRUCK":
				for(Vehicle vehicle : Vehicles)
				{
				}
				break;
			case "HYBRID":
				for(Vehicle vehicle : Vehicles)
				{	
				}
		}
			
	}
	
	
	public void randomVehicle(ArrayList<Vehicle> vehicleList)
	{
		
		Random rand = new Random();
		
		int length = vehicleList.size();
		
		System.out.print("Enter the number of vehicles to display: ");
		
		int vehicleCount = Integer.parseInt(userInput.nextLine());
		
		for(int i = 0; i < vehicleCount; i++)
		{
			int randomIndex = rand.nextInt(length);
			System.out.println(vehicleList.get(randomIndex));
		}
		
		
	}
	
	
	public ArrayList<Vehicle> purchaseVehicle(ArrayList<Vehicle> Vehicles)
	{
		
		boolean foundCar = false; 
		
		System.out.print("Enter Car ID: ");
		
		long carId = Long.parseLong(userInput.nextLine());
		
		loop : for(Vehicle vehicle : Vehicles)
		{
			if(vehicle.getCarId() == carId)
			{
				vehicle.checkout();
				foundCar = true;
				break loop;	
			}
			
		}
		
		if(foundCar = false)
		{
			System.out.println("Invalid Car ID, No car found.");
			return Vehicles;
		}
		else
		{
			return Vehicles;
		}
		
	}
	
	
	public void vehicleSearch(ArrayList<Vehicle> Vehicles)
	{
		System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
		String carType = userInput.nextLine().toUpperCase();
		
		switch(carType)
		{
			case "SEDAN":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("SEDAN"))
					{
						String formattedTrunkSize = null;
						if(((Sedan)vehicle).getTrunkSize().equals("S"))
						{
							formattedTrunkSize = "Small Trunk";
						}
						else if(((Sedan)vehicle).getTrunkSize().equals("M"))
						{
							formattedTrunkSize = "Moderate Trunk";
						}
						else if(((Sedan)vehicle).getTrunkSize().equals("L"))
						{
							formattedTrunkSize = "Large/Spacious Trunk";
						}
						System.out.println(String.format(
							"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Trunk Size: %s %n",
							vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedTrunkSize));
					}
				}
				break;
			case "SUV":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("SUV"))
					{
						System.out.println(String.format(
								"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n",
								vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity()));
					}
				}
				break;
			case "HATCHBACK":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("HATCHBACK"))
					{
						String formattedHatchType = null;
						if(((Hatchback)vehicle).getHatchType().equals("S"))
						{
							formattedHatchType = "Standard Liftgate";
						}
						else if(((Hatchback)vehicle).getHatchType().equals("T"))
						{
							formattedHatchType = "Split Liftgate";
						}
						else if(((Hatchback)vehicle).getHatchType().equals("P"))
						{
							formattedHatchType = "Power Liftgate";
						}
						System.out.println(String.format(
							"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Hatch Type: %s %n",
							vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedHatchType));
					}
				}
				break;
			case "PICKUP TRUCK":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("PICKUP TRUCK"))
					{
						String formattedCargoBed = null;
						if(((PickupTruck)vehicle).getCargoBed().equals("SB"))
						{
							formattedCargoBed = "Short Bed";
						}
						else if(((PickupTruck)vehicle).getCargoBed().equals("EB"))
						{
							formattedCargoBed = "Extended Bed";
						}
						else if(((PickupTruck)vehicle).getCargoBed().equals("DB"))
						{
							formattedCargoBed = "Dump Bed";
						}
						
						
						System.out.println(String.format(
								"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Cargo Bed: %s %n Cargo Capacity: %s %n",
								vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedCargoBed,((PickupTruck)vehicle).getCargoCapacity()));
					}
				}
				break;
			case "HYBRID":
				for(Vehicle vehicle : Vehicles)
				{
					if(vehicle.getVehicleType().toUpperCase().equals("HYBRID"))
					{
						String formattedPowerTrain = null;
						if(((Hybrid)vehicle).getPowerTrain().equals("E"))
						{
							formattedPowerTrain = "Series Hybrid";
						}
						else if(((Hybrid)vehicle).getPowerTrain().equals("A"))
						{
							formattedPowerTrain = "Parallel Hybrid";
						}
						else if(((Hybrid)vehicle).getPowerTrain().equals("PHEV"))
						{
							formattedPowerTrain = "Plug-in Hybrid";
						}
						System.out.println(String.format(
								"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n Power Train: %s %n Electric Range: %s %n",
								vehicle.getCarId(), vehicle.getVehicleType(), vehicle.getSubtype(), vehicle.getSpeed(), vehicle.getFuel(),vehicle.getSeats(), vehicle.getYear(), vehicle.getDrivetrain(), vehicle.getPrice(),vehicle.getQuantity(),formattedPowerTrain,((Hybrid)vehicle).getElectricRange()));
					}
				}	
		}
	}	
}
