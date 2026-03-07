package p01;

public abstract class Vehicle 
{
//	Defining the private variables for vehicle abstract class
	private long carId;
	private String vehicleType, subtype, drivetrain;
	private int speed, seats, year, price, quantity;
	private double fuel;
	
	//Setters
	public void setCarId(long carId)
	{
		this.carId = carId;
	}
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}
	public void setSubtype(String subtype)
	{
		this.subtype = subtype;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	public void setFuel(double fuel)
	{
		this.fuel = fuel;
	}
	public void setSeats(int seats)
	{
		this.seats = seats;
	}
	public void setYear(int year)
	{
		this.year = year;
	}

	// Drivetrain Validation
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
	public void setPrice(int price)
	{
		this.price = price;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	//Getters
	public long getCarId()
	{
		return this.carId;
	}
	public String getVehicleType()
	{
		return this.vehicleType;
	}
	public String getSubtype()
	{
		return this.subtype;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public double getFuel()
	{
		return this.fuel;
	}
	public int getSeats()
	{
		return this.seats;
	}
	public int getYear()
	{
		return this.year;
	}
	public String getDrivetrain()
	{
		return this.drivetrain;
	}
	public int getPrice()
	{
		return this.price;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
	
	//Constructor for vehicle class, takes in all variables as parameters and sets them using the setter methods
	public Vehicle(long carId, String vehicleType, String subtype, int speed, double fuel, int seats, int year, String drivetrain, int price, int quantity)
	{
		setCarId(carId);
		setVehicleType(vehicleType);
		setSubtype(subtype);
		setSpeed(speed);
		setFuel(fuel);
		setSeats(seats);
		setYear(year);
		setDrivetrain(drivetrain);
		setPrice(price);
		setQuantity(quantity);
	}

	//boolean method to check if the vehicle is available by checking if quantity is greater than 0
	public Boolean isAvailable()
	{
		if(getQuantity() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Checkout method, checks availability then decrements quantity by 1 if vehicle is available
	//Prints a message saying if the vehicle has been checked out or if it is not available
	public void checkout()
	{
		if(isAvailable())
		{
			setQuantity(getQuantity() - 1);
			System.out.println(String.format("The Vehicle \"%s %s\" has been checked out. ", getVehicleType(), getSubtype()));
		}
		else
		{
			System.out.println("This vehicle is not available");
		}
	}
	
	// getDetails method to return a string with all elements displayed vertically
	public String getDetails()
	{
		return String.format(
			"Car ID: %s %n Vehicle Type: %s %n Sub Type: %s %n Speed: %s %n Fuel: %s %n Number of Seats: %s %n Year: %s %n DriveTrain: %s %n Price: %s %n Available: %s %n",
			getCarId(), getVehicleType(), getSubtype(), getSpeed(), getFuel(),getSeats(), getYear(), getDrivetrain(), getPrice(),getQuantity());
	}

	//toString method to return a string formatted like the vehicle.txt file
	@Override public String toString()
	{
		return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;",getCarId(),getVehicleType(),getSubtype(),getSpeed(),getFuel(),getSeats(),getYear(),getDrivetrain(),getPrice(),getQuantity());
	}
	
	
}
