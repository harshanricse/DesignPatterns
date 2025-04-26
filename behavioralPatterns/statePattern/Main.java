package statePattern;

//Context class
class TrafficLight {
	private TrafficLightState state;

	public TrafficLight() {
		state = new RedLight();
	}

	public void setState(TrafficLightState state) {
		this.state = state;
	}

	public void performAction() {
		state.handle();
	}
}

//State interface
interface TrafficLightState {
	void handle();
}

//Concrete State classes
class RedLight implements TrafficLightState {
	@Override
	public void handle() {
		System.out.println("Stop! Red Light");
	}
}

class GreenLight implements TrafficLightState {
	@Override
	public void handle() {
		System.out.println("Go! Green Light");
	}
}

class YellowLight implements TrafficLightState {
	@Override
	public void handle() {
		System.out.println("Prepare to stop! Yellow Light");
	}
}

public class Main {
	public static void main(String[] args) {
		TrafficLight trafficLight = new TrafficLight();

		trafficLight.performAction(); // Stop! Red Light

		trafficLight.setState(new GreenLight());
		trafficLight.performAction(); // Go! Green Light

		trafficLight.setState(new YellowLight());
		trafficLight.performAction(); // Prepare to stop! Yellow Light
	}
}