package p01;

public class Sedan extends Vehicle
{
	//For the additional attribute
	private String trunkSize;
	
	//sedan-specific methods
	
	//setter
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
	
	//constructor!!!! FINALLY
	public Sedan(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String trunkSize)
	{
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
		setTrunkSize(trunkSize);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + getTrunkSize();
	}
}
