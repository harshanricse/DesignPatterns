package observerPattern;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherStation {
	void registerObserver(WeatherObserver observer);

	void removeObserver(WeatherObserver observer);

	void notifyObservers(String weatherUpdate);
}

//Concrete Subject class
class LocalWeatherStation implements WeatherStation {
	private List<WeatherObserver> observers = new ArrayList<>();

	@Override
	public void registerObserver(WeatherObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(WeatherObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String weatherUpdate) {
		for (WeatherObserver observer : observers) {
			observer.update(weatherUpdate);
		}
	}

	public void updateWeather(String update) {
		notifyObservers(update);
	}
}

//Observer interface
interface WeatherObserver {
	void update(String weatherUpdate);
}

//Concrete Observer classes
class LocalWeatherObserver implements WeatherObserver {
	private String location;

	public LocalWeatherObserver(String location) {
		this.location = location;
	}

	@Override
	public void update(String weatherUpdate) {
		System.out.println("Weather update for " + location + ": " + weatherUpdate);
	}
}

public class Main {
	public static void main(String[] args) {
		LocalWeatherStation weatherStation = new LocalWeatherStation();

		WeatherObserver observer1 = new LocalWeatherObserver("City A");
		WeatherObserver observer2 = new LocalWeatherObserver("City B");

		weatherStation.registerObserver(observer1);
		weatherStation.registerObserver(observer2);

		weatherStation.updateWeather("Clear skies and warm temperatures.");
	}
}