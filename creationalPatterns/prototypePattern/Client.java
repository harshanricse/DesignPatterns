package prototypePattern;

//Prototype interface
interface Prototype {
	Prototype clone();
}

//Concrete implementation of Prototype interface - Circle
class Circle implements Prototype {
	private int x;
	private int y;
	private int radius;

	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// Copy constructor to perform deep copy
	public Circle(Circle source) {
		this.x = source.x;
		this.y = source.y;
		this.radius = source.radius;
	}

	@Override
	public Prototype clone() {
		return new Circle(this);
	}

	// Other methods specific to Circle, if any...
}

public class Client {
	public static void main(String[] args) {
		// Create a Circle object using the constructor
		Circle originalCircle = new Circle(10, 20, 5);

		// Clone the originalCircle using the clone() method
		Circle clonedCircle = (Circle) originalCircle.clone();

		// Verify that the two objects are separate instances
		System.out.println("Original Circle: " + originalCircle);
		System.out.println("Cloned Circle: " + clonedCircle);
		System.out.println("Are they the same object? " + (originalCircle == clonedCircle));
	}
}