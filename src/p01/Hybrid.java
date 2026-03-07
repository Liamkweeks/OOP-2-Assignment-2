package p01;

public class Hybrid extends Vehicle
{
	private String powerTrain;
	private int electricRange;
	
	// setter
	public void setElectricRange(int electricRange)
	{
		this.electricRange = electricRange;
	}
	
	//setter for powertrain that has built in validation to ensure only valid power train types are accepted
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
	
	//Getters
	public String getPowerTrain()
	{
		return this.powerTrain;
	}
	
	public int getElectricRange()
	{
		return this.electricRange;
	}

	//Constructor for Hybrid class, calls the super constructor from Vehicle class then sets power train and electric range using setter methods
	public Hybrid(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String powerTrain, int electricRange)
	{
		super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
		setPowerTrain(powerTrain);
		setElectricRange(electricRange);
	}
	
	//getDetails method to return a string with all elements displayed vertically
	//Method makes sure that elements are capitalized and formatted correctly for display	
	public String getDetails()
	{
		String formattedPowerTrain = null;
		if(getPowerTrain().toUpperCase().equals("E"))
		{
			formattedPowerTrain = "Series Hybrid";
		}
		else if(getPowerTrain().toUpperCase().equals("A"))
		{
			formattedPowerTrain = "Parallel Hybrid";
		}
		else if(getPowerTrain().toUpperCase().equals("PHEV"))
		{
			formattedPowerTrain = "Plug-in Hybrid";
		}
		return super.getDetails() + String.format("Power Train: %s %n Electric Range: %s %n", formattedPowerTrain, getElectricRange());
	}

	// ToString method that returns a string formatted like the vehicle.txt file
	@Override
	public String toString()
	{
		return super.toString() + getPowerTrain() + ";" + getElectricRange();
	}
}
