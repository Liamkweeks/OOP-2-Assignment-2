package p01;

public class Hatchback extends Vehicle
{
		//For the additional attribute
		private String hatchType;
		
		//Hatchback-specific methods
		
		//setter
		public void setHatchType(String hatchType)
		{
			switch(hatchType.toUpperCase())
			{
			case "S":
				this.hatchType = hatchType;
				break;
			case "T":
				this.hatchType = hatchType;
				break;
			case "P":
				this.hatchType = hatchType;
				break;
			default:
				this.hatchType = null;
				System.out.println("Invalid hatch type, please input \"S\", \"T\", or \"P\"");
				break;
			}
		}
		
		//getter
		public String getHatchType()
		{
			return this.hatchType;
		}
		
		//constructor!!!! FINALLY
		public Hatchback(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String hatchType)
		{
			super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
			setHatchType(hatchType);
		}
		
		@Override
		public String toString()
		{
			return super.toString() + getHatchType();
		}
}

