package builderPattern;

class Car {
	private String make;
	private String model;
	private int year;

	public Car(CarBuilder builder) {
		this.make = builder.getMake();
		this.model = builder.getModel();
		this.year = builder.getYear();
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public Car setYear(int year) {
		this.year = year;
		return this;
	}
}

class CarBuilder {
	private String make;
	private String model;
	private int year;

	public CarBuilder(String make, String model) {
		this.make = make;
		this.model = model;
	}

	public CarBuilder setYear(int year) {
		this.year = year;
		return this;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public Car build() {
		return new Car(this);
	}
}

public class Client {
	public static void main(String[] args) {
		Car car = new CarBuilder("Toyota", "Camry").setYear(2020).build();
		System.out.println(car.getMake()+" "+car.getModel()+" "+car.getYear());
	}
}