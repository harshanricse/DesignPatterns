package decoratorPattern;

interface Coffee {
	double cost();

	String description();
}

class RegularCoffee implements Coffee {
	@Override
	public double cost() {
		return 2.0;
	}

	@Override
	public String description() {
		return "Regular Coffee";
	}
}

abstract class CoffeeDecorator implements Coffee {
	private final Coffee decoratedCoffee;

	public CoffeeDecorator(Coffee coffee) {
		this.decoratedCoffee = coffee;
	}

	@Override
	public double cost() {
		return decoratedCoffee.cost();
	}

	@Override
	public String description() {
		return decoratedCoffee.description();
	}
}

class CreamDecorator extends CoffeeDecorator {
	public CreamDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return super.cost() + 0.5;
	}

	@Override
	public String description() {
		return super.description() + ", Cream";
	}
}

class CaramelDecorator extends CoffeeDecorator {
	public CaramelDecorator(Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return super.cost() + 0.2;
	}

	@Override
	public String description() {
		return super.description() + ", Caramel";
	}
}

public class Main {
	public static void main(String[] args) {
		Coffee regularCoffee = new RegularCoffee();
		System.out.println("Cost: $" + regularCoffee.cost() + ", Description: " + regularCoffee.description());

		Coffee creamCoffee = new CreamDecorator(regularCoffee);
		System.out.println("Cost: $" + creamCoffee.cost() + ", Description: " + creamCoffee.description());

		Coffee caramelMilkCoffee = new CaramelDecorator(creamCoffee);
		System.out.println("Cost: $" + caramelMilkCoffee.cost() + ", Description: " + caramelMilkCoffee.description());
	}
}
