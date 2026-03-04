package p01;

public class Hybrid extends Vehicle
{
	//For the additional attribute
	private String powerTrain;
	
	private int electricRange;
	
	public void setElectricRange(int electricRange)
	{
		this.electricRange = electricRange;
	}
	public int getElectricRange()
	{
		return this.electricRange;
	}
	
	//Hybrid-specific methods
	
	//setter
	public void setPowerTrain(String powerTrain)
	{
		switch(powerTrain.toUpperCase())
		{
		case "E":
			this.powerTrain = powerTrain;
			break;
		case "A":
			this.powerTrain = powerTrain;
			break;
		case "PHEV":
			this.powerTrain = powerTrain;
			break;
		default:
			this.powerTrain = null;
			System.out.println("Invalid power train, please input \"E\", \"A\", or \"PHEV\"");
			break;
		}
	}
	
	//getter
	public String getPowerTrain()
	{
		return this.powerTrain;
	}
	
	//constructor!!!! FINALLY
	public Hybrid(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String powerTrain, int electricRange)
	{
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
		setPowerTrain(powerTrain);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + getPowerTrain() + ";" + getElectricRange();
	}
}
