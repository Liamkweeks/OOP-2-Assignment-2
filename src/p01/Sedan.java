package p01;

public class Sedan extends Vehicle
{
	private String trunkSize;
	
	//setter with built in validation to ensure only valid trunk size types are accepted
	public void setTrunkSize(String trunkSize)
	{
		switch(trunkSize.toUpperCase())
		{
		case "S":
			this.trunkSize = trunkSize;
			break;
		case "M":
			this.trunkSize = trunkSize;
			break;
		case "L":
			this.trunkSize = trunkSize;
			break;
		default:
			this.trunkSize = null;
			System.out.println("Invalid trunk size, please input \"S\", \"M\", or \"L\"");
			break;
		}
	}
	
	//getter
	public String getTrunkSize()
	{
		return this.trunkSize;
	}
	
	//constructor for sedan class, calls the super constructor then sets trunk size using setter method that has built in validation
	public Sedan(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String trunkSize)
	{
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
		setTrunkSize(trunkSize);
	}
	
	//getDetails method to return a string with all elements displayed vertically
	//Method makes sure that elements are capitalized and formatted correctly for display
	public String getDetails(){
		String formattedTrunkSize = null;
		if(getTrunkSize().equals("S"))
		{
			formattedTrunkSize = "Small Trunk";
		}
		else if(getTrunkSize().equals("M"))
		{
			formattedTrunkSize = "Moderate Trunk";
		}
		else if(getTrunkSize().equals("L"))
		{
			formattedTrunkSize = "Large/Spacious Trunk";
		}
		return super.getDetails() + String.format("Trunk Size: %s %n", formattedTrunkSize);
	}

	// ToString method that returns a string formatted like the vehicle.txt file
	@Override
	public String toString()
	{
		return super.toString() + getTrunkSize();
	}
}
