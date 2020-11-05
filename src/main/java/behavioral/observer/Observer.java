package behavioral.observer;

/*
The pattern consists of two actors, the observer who is interested in the updates and the subject who generates the updates.
The pattern is formally defined as a one to many dependency between objects so that when one object changes state all the dependents are notified.

 */

import java.util.ArrayList;
import java.util.Collection;

import creational.builder.IAircraft;

/*
We can imagine that an aircraft, as soon as, it is airborne would want to subscribe to updates from the air traffic controller and unsubscribe when it
lands.
 */
public class Observer {
    public static void main(String[] args) {

    }
}

interface ISubject {

    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}

interface IObserver {

    void update( Object newState);
}

class ControlTower implements ISubject {

    // The ControlTower maintains a list of
    Collection<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(IObserver observer) {
        // Logic to remove the observer goes in here
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            // We are passing null for state here but we
            // could pass 'this' the subject itself or a
            // type representing the state. These two options
            // represent the Pull vs Push models
            observer.update( null);
        }
    }

    /**
     * This is hypothetical function that runs perpetually, gathering
     * runway and weather conditions and notifying all observers of
     * them periodically.
     */
    public void run() {

        while (true) {
            // get new runway/weather conditions and update observers
            // every five minutes
            // Thread.sleep(1000 * 60 * 5)
            notifyObservers();
        }
    }
}

/*
The F-16 class would implement the IObservable as objects of the F-16 class would want updates from the ControlTower class.
 */
class F16 implements IObserver, IAircraft {

    ISubject observable;

    public F16(ISubject observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void fly() {
        System.out.println("F16 is flying ...");

    }

    @Override
    public void land() {

        // Don't forget to unsubscribe from control tower updates
        observable.removeObserver(this);
    }

    @Override
    public float getWeight() {
        return 0;
    }

    @Override
    public void update(Object newState) {
        // Take appropriate action based on newState
    }
}
