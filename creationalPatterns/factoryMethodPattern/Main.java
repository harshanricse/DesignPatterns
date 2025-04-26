package factoryMethodPattern;

//Shape interface
interface Shape {
	void draw();
}

//Concrete Circle class
class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing a circle");
	}
}

//Concrete Square class
class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing a square");
	}
}

//ShapeFactory interface
interface ShapeFactory {
	Shape createShape();
}

//CircleFactory class
class CircleFactory implements ShapeFactory {
	@Override
	public Shape createShape() {
		return new Circle();
	}
}

//SquareFactory class
class SquareFactory implements ShapeFactory {
	@Override
	public Shape createShape() {
		return new Square();
	}
}

public class Main {
	public static void main(String[] args) {
		ShapeFactory circleFactory = new CircleFactory();
		Shape circle = circleFactory.createShape();
		circle.draw();

		ShapeFactory squareFactory = new SquareFactory();
		Shape square = squareFactory.createShape();
		square.draw();
	}
}