package commandPattern;

//Command interface
interface Command {
	void execute();
}

//Concrete command
class ConcreteCommand implements Command {
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.performAction();
	}
}

//Receiver
class Receiver {
	public void performAction() {
		System.out.println("Action performed by the receiver");
	}
}

//Invoker
class Invoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}
}

//Client
public class Main {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.executeCommand();
	}
}