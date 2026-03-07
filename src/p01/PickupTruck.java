package p01;

public class PickupTruck extends Vehicle
{
	//For the additional attribute
		private String cargoBed;
		private int cargoCapacity;
		
		public void setCargoCapacity(int cargoCapacity)
		{
			this.cargoCapacity = cargoCapacity;
		}
		
		//setter for cargo bed that has built in validation to ensure only valid cargo bed types are accepted
		public void setCargoBed(String cargoBed)
		{
			switch(cargoBed.toUpperCase())
			{
			case "SB":
				this.cargoBed = cargoBed;
				break;
			case "EB":
				this.cargoBed = cargoBed;
				break;
			case "DB":
				this.cargoBed = cargoBed;
				break;
			default:
				this.cargoBed = null;
				System.out.println("Invalid cargo bed, please input \"SB\", \"EB\", or \"DB\"");
				break;
			}
		}
		
		//getters
		public String getCargoBed()
		{
			return this.cargoBed;
		}
		
		public int getCargoCapacity()
		{
			return this.cargoCapacity;
		}
		
		//constructor for pickup truck class, calls the super constructor then sets cargo bed and cargo capacity using setter method that has built in validation
		public PickupTruck(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String cargoBed, int cargoCapacity)
		{
			super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
			setCargoBed(cargoBed);
			setCargoCapacity(cargoCapacity);
		}

		//getDetails method to return a string with all elements displayed vertically
		//Method makes sure that elements are capitalized and formatted correctly for display
		public String getDetails(){
			String formattedCargoBed = null;
			if(getCargoBed().toUpperCase().equals("SB"))
			{
				formattedCargoBed = "Short Bed";
			}
			else if(getCargoBed().toUpperCase().equals("EB"))
			{
				formattedCargoBed = "Extended Bed";
			}
			else if(getCargoBed().toUpperCase().equals("DB"))
			{
				formattedCargoBed = "Dump Bed";
			}
			return super.getDetails() + String.format("Cargo Bed: %s %n Cargo Capacity: %s %n", formattedCargoBed, getCargoCapacity());
		}
		
		// ToString method that returns a string formatted like the vehicle.txt file
		@Override
		public String toString()
		{
			return super.toString() + getCargoBed() + ";" + getCargoCapacity();
		}
}
