package bridgePattern;

//Shape interface
interface IShape {
	void create();
}

//Concrete implementation of IShape - Circle
class Circle implements IShape {
	@Override
	public void create() {
		System.out.println("Drawing Circle");
	}
}

//Concrete implementation of IShape - Square
class Square implements IShape {
	@Override
	public void create() {
		System.out.println("Drawing Square");
	}
}

//IColor interface
interface IColor {
	void addColor();
}

//Concrete implementation of IColor - Red
class Red implements IColor {
	@Override
	public void addColor() {
		System.out.println("Applying Red Color");
	}
}

//Concrete implementation of Color - Blue
class Blue implements IColor {
	@Override
	public void addColor() {
		System.out.println("Applying Blue Color");
	}
}

//Bridge that connects shapes with colors
abstract class ShapeColorBridge {
	protected IShape shape;
	protected IColor color;

	public ShapeColorBridge(IShape shape, IColor color) {
		this.shape = shape;
		this.color = color;
	}

	public abstract void drawShapeWithColor();
}

//Concrete implementation of ShapeColorBridge for Circle
class CircleBridge extends ShapeColorBridge {
	public CircleBridge(IShape shape, IColor color) {
		super(shape, color);
	}

	@Override
	public void drawShapeWithColor() {
		shape.create();
		color.addColor();
	}
}

//Concrete implementation of ShapeColorBridge for Square
class SquareBridge extends ShapeColorBridge {
	public SquareBridge(IShape shape, IColor color) {
		super(shape, color);
	}

	@Override
	public void drawShapeWithColor() {
		shape.create();
		color.addColor();
	}
}

public class Client {
	public static void main(String[] args) {
		ShapeColorBridge redCircle = new CircleBridge(new Circle(), new Red());
		ShapeColorBridge blueSquare = new SquareBridge(new Square(), new Blue());

		redCircle.drawShapeWithColor();
		blueSquare.drawShapeWithColor();
	}
}