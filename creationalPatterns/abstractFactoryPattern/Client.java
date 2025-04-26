package abstractFactoryPattern;

//Shape interface
interface Shape {
	void draw();
}

//Color interface
interface Color {
	void fill();
}

//Concrete implementation of Shape interface - Circle
class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

//Concrete implementation of Shape interface - Square
class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}

//Concrete implementation of Color interface - Red
class Red implements Color {
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}

//Concrete implementation of Color interface - Blue
class Blue implements Color {
	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}
}

//Abstract Factory interface
interface AbstractFactory {
	Shape createShape();

	Color createColor();
}

//Concrete implementation of AbstractFactory for creating red shapes
class RedShapeFactory implements AbstractFactory {
	@Override
	public Shape createShape() {
		return new Circle();
	}

	@Override
	public Color createColor() {
		return new Red();
	}
}

//Concrete implementation of AbstractFactory for creating blue shapes
class BlueShapeFactory implements AbstractFactory {
	@Override
	public Shape createShape() {
		return new Square();
	}

	@Override
	public Color createColor() {
		return new Blue();
	}
}

public class Client {
	public static void main(String[] args) {
		// Create a RedShapeFactory and use it to create red circle
		AbstractFactory redFactory = new RedShapeFactory();
		Shape redCircle = redFactory.createShape();
		Color redColor = redFactory.createColor();
		redCircle.draw();
		redColor.fill();

		// Create a BlueShapeFactory and use it to create blue square
		AbstractFactory blueFactory = new BlueShapeFactory();
		Shape blueSquare = blueFactory.createShape();
		Color blueColor = blueFactory.createColor();
		blueSquare.draw();
		blueColor.fill();
	}
}