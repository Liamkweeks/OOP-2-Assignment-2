package p01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class main
{

	public static void main(String[] args)
	{
		ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
		
		File VehicleFile = new File("vehicles.txt");
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
		for(Vehicle vehicle : Vehicles)
		{
		System.out.println(vehicle);
		}
	}
	
}
		

          
	