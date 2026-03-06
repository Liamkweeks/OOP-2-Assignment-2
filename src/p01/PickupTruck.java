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
		public int getCargoCapacity()
		{
			return this.cargoCapacity;
		}
		
		//PickupTruck-specific methods
		
		//setter
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
		
		//getter
		public String getCargoBed()
		{
			return this.cargoBed;
		}
		
		//constructor!!!! FINALLY
		public PickupTruck(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity, String cargoBed, int cargoCapacity)
		{
			super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain,  price, quantity);
			setCargoBed(cargoBed);
			setCargoCapacity(cargoCapacity);
		}
		
		@Override
		public String toString()
		{
			return super.toString() + getCargoBed() + ";" + getCargoCapacity();
		}
}
