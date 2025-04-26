package templateMethodPattern;

//Abstract class defining the template
abstract class AbstractClass {
	public void templateMethod() {
		stepOne();
		stepTwo();
		stepThree();
	}

	protected abstract void stepOne();

	protected abstract void stepTwo();

	protected abstract void stepThree();
}

//Concrete subclass implementing the template
class ConcreteClass extends AbstractClass {
	@Override
	protected void stepOne() {
		System.out.println("Step One");
	}

	@Override
	protected void stepTwo() {
		System.out.println("Step Two");
	}

	@Override
	protected void stepThree() {
		System.out.println("Step Three");
	}
}

public class Main {
	public static void main(String[] args) {
		AbstractClass template = new ConcreteClass();
		template.templateMethod();
	}
}