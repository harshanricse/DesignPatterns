package visitorPattern;

//Visitor interface
interface Visitor {
	void visit(Circle circle);

	void visit(Square square);
}

//Concrete Visitor
class AreaCalculator implements Visitor {
	@Override
	public void visit(Circle circle) {
		double area = Math.PI * circle.getRadius() * circle.getRadius();
		System.out.println("Area of Circle: " + area);
	}

	@Override
	public void visit(Square square) {
		double area = square.getSide() * square.getSide();
		System.out.println("Area of Square: " + area);
	}
}

//Element interface
interface Shape {
	void accept(Visitor visitor);
}

//Concrete Elements
class Circle implements Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Square implements Shape {
	private double side;

	public Square(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

public class Main {
	public static void main(String[] args) {
		Shape[] shapes = { new Circle(5.0), new Square(4.0) };

		Visitor areaCalculator = new AreaCalculator();

		for (Shape shape : shapes) {
			shape.accept(areaCalculator);
		}
	}
}