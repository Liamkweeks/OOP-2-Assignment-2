package p01;

public class Hatchback extends Vehicle
{
		private String hatchType;
		
		//Setter with built in validation to ensure only valid hatch types are accepted
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
		
		//Getter
		public String getHatchType()
		{
			return this.hatchType;
		}
		
		//constructor for hatchback class, calls the super constructor then sets hatch type using setter method that has built in validation
		public Hatchback(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String hatchType)
		{
			super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
			setHatchType(hatchType);
		}

		//getDetails method to return a string with all elements displayed vertically
		//Method makes sure that elements are capitalized and formatted correctly for display
		public String getDetails(){
			String formattedHatchType = null;
			if(getHatchType().toUpperCase().equals("S"))
			{
				formattedHatchType = "Standard Liftgate";
			}
			else if(getHatchType().toUpperCase().equals("T"))
			{
				formattedHatchType = "Split Liftgate";
			}
			else if(getHatchType().toUpperCase().equals("P"))
			{
				formattedHatchType = "Power Liftgate";
			}
			return super.getDetails() + String.format("Hatch Type: %s %n", formattedHatchType);
		}
		
		// ToString method that returns a string formatted like the vehicle.txt file
		@Override
		public String toString()
		{
			return super.toString() + getHatchType();
		}
}

