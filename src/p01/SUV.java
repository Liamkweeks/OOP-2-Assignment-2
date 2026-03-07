package p01;

// This class does not need a custom toString or getDetails as it only has the same variables as the vehicle super class
public class SUV extends Vehicle
{
	public String drivetrain;

	// override the setDrivetrain method to ensure that only valid drivetrain types are accepted for SUVs
	@Override
	public void setDrivetrain(String drivetrain)
	{
		
		switch(drivetrain.toUpperCase())
		{
		case "AWD":
			this.drivetrain = drivetrain;
			break;
		case "4WD":
			this.drivetrain = drivetrain;
			break;
		case "FWD":
			this.drivetrain = drivetrain;
			break;
		default:
			this.drivetrain = null;
			System.out.println("Invalid drivetrain, please input \"AWD\", \"4WD\", or \"FWD\"");
			break;
		}
		
	}

	// Constructor for SUV class, as it has no custom variables just calls the super constructor from Vehicle class
	public SUV(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity)
	{
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
	}
}
