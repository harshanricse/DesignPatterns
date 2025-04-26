package mediatorPattern;

import java.util.ArrayList;
import java.util.List;

interface AirTrafficControlMediator {
	void registerAircraft(AirCraft aircraft);

	void communicate(String message, AirCraft sender);
}

class AirTrafficControlTower implements AirTrafficControlMediator {

	private List<AirCraft> aircrafts;

	public AirTrafficControlTower() {
		this.aircrafts = new ArrayList<>();
	}

	@Override
	public void registerAircraft(AirCraft aircraft) {
		aircrafts.add(aircraft);

	}

	@Override
	public void communicate(String message, AirCraft sender) {
		System.out.println("Tower: " + message);
		for (AirCraft aircraft : aircrafts) {
			if (aircraft != sender) {
				aircraft.receive(message);
			}
		}
	}
}

abstract class AirCraft {
	protected AirTrafficControlMediator mediator;
	protected String name;

	public AirCraft(AirTrafficControlMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public abstract void send(String message);

	public abstract void receive(String message);
}

class Airplane extends AirCraft {

	public Airplane(AirTrafficControlMediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String message) {
		System.out.println(name + " sends " + message);
		mediator.communicate(message, this);
	}

	@Override
	public void receive(String message) {
		System.out.println(name + " recieves " + message);
	}
}

public class Main {
	public static void main(String[] args) {
		AirTrafficControlMediator tower = new AirTrafficControlTower();

		AirCraft airplane1 = new Airplane(tower, "Flight 001");
		AirCraft airplane2 = new Airplane(tower, "Flight 002");

		tower.registerAircraft(airplane1);
		tower.registerAircraft(airplane2);

		airplane1.send("Requesting landing clearance");
		airplane2.send("Roger, Flight 001. You are clear to land.");
	}
}
