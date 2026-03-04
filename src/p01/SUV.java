package p01;

public class SUV extends Vehicle
{
	public String drivetrain;
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
			System.out.println("Invalid drivetrain, please input \"ADW\", \"4WD\", or \"FWD\"");
			break;
		}
		
	}

	public SUV(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity)
	{
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
	}
}
