package p01;

// This class does not need a custom toString, getDetails, or setter as it only has the same variables as the vehicle super class
public class SUV extends Vehicle
{
	// Constructor for SUV class, as it has no custom variables just calls the super constructor from Vehicle class
	public SUV(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity)
	{	
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);	
	}
}
