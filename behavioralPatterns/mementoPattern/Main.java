package mementoPattern;

//Memento class
class Memento {
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}

//Originator class
class Originator {
	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void restoreStateFromMemento(Memento memento) {
		state = memento.getState();
	}
}

public class Main {
	public static void main(String[] args) {
		Originator originator = new Originator();

		originator.setState("State 1");
		Memento memento = originator.saveStateToMemento();

		originator.setState("State 2");

		System.out.println("Current State: " + originator.getState());

		originator.restoreStateFromMemento(memento);

		System.out.println("Restored State: " + originator.getState());
	}
}