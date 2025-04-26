package flyweightPattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Car {
	void drive();
}

// Concrete Flyweight class
class SmallCar implements Car {
	@Override
	public void drive() {
		System.out.println("Driving a small car.");
	}
}

class MediumCar implements Car {
	@Override
	public void drive() {
		System.out.println("Driving a medium car.");
	}
}

class CarFactory {
	private static final Map<String, Car> carMap = new HashMap<>();

	public static Car getCar(String type) {
		Car car = carMap.get(type);

		if (car == null) {
			switch (type) {
			case "small":
				car = new SmallCar();
				break;
			case "medium":
				car = new MediumCar();
				break;
			default:
				throw new IllegalArgumentException("Invalid car type: " + type);
			}
			carMap.put(type, car);
		}

		return car;
	}
}

public class Main {
	public static void main(String[] args) {
		Car smallCar1 = CarFactory.getCar("small");
		Car smallCar2 = CarFactory.getCar("small");
		Car mediumCar = CarFactory.getCar("medium");

		smallCar1.drive(); // Output: Driving a small car.
		smallCar2.drive(); // Output: Driving a small car. (Same instance as smallCar1)
		mediumCar.drive(); // Output: Driving a medium car.
	}
}