package DesginPatterns.Behavioral;
import java.util.ArrayList;
import java.util.List;
// Observer Interface
interface Observer {
    void update(int temperature);
}

// Subject Interface
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}

// Concrete Observers
class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone display: " + temperature);
    }
}

class TVDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("TV display: " + temperature);
    }
}

// Client code
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        station.attach(new PhoneDisplay());
        station.attach(new TVDisplay());

        station.setTemperature(30);
        station.setTemperature(35);
    }
}
