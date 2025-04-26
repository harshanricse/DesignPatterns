package interpreterPattern;

//Abstract Expression
interface Expression {
	int interpret();
}

//Terminal Expression
class Number implements Expression {
	private int value;

	public Number(int value) {
		this.value = value;
	}

	@Override
	public int interpret() {
		return value;
	}
}

//Non-terminal Expression
class Add implements Expression {
	private Expression leftOperand;
	private Expression rightOperand;

	public Add(Expression leftOperand, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int interpret() {
		return leftOperand.interpret() + rightOperand.interpret();
	}
}

//Client
public class Main {
	public static void main(String[] args) {
		// 10 + (2 + 3)
		Expression expression = new Add(new Number(10), new Add(new Number(2), new Number(3)));

		int result = expression.interpret();
		System.out.println("Result: " + result); // Output: Result: 15
	}
}
