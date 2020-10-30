package creational.factory;

/*
Formally, the abstract factory pattern is defined as defining an interface to create families of related or dependent objects without
specifying their concrete classes.
The formal definition of the abstract factory pattern says abstract factory pattern defines an interface for creating families
of related products without specifying the concrete classes.
 */

import java.util.ArrayList;
import java.util.Collection;


public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // Instantiate a concrete factory for F-16
        F16Factory f16Factory = new F16Factory();

        // Instantiate a concrete factory for Boeing-747
        Boeing747Factory boeing747Factory = new Boeing747Factory();

        // Lets create a list of all our airplanes
        Collection<Aircraft> myPlanes = new ArrayList<>();

        // Create a new F-16 by passing in the f16 factory
        myPlanes.add(new Aircraft(f16Factory));

        // Create a new Boeing-747 by passing in the boeing factory
        myPlanes.add(new Aircraft(boeing747Factory));

        // Fly all your planes
        for (Aircraft aircraft : myPlanes) {
            aircraft.fly();
        }
    }
}


interface IEngine {

    void start();
}

interface IWings {

}

interface ICockpit {

}

/*
Here the IAircraftFactory is that interface in the formal definition and note how its create methods are not returning concrete parts
but rather interfaces that'll be implemented by the concrete parts' classes.
 */

interface IAircraftFactory {

    IEngine createEngine();

    IWings createWings();

    ICockpit createCockpit();
}

class F16Factory implements IAircraftFactory {

    @Override
    public IEngine createEngine() {
        return new F16Engine();
    }

    @Override
    public IWings createWings() {
        return new F16Wings();
    }

    @Override
    public ICockpit createCockpit() {
        return new F16Cockpit();
    }
}

class Boeing747Factory implements IAircraftFactory {

    @Override
    public IEngine createEngine() {
        return new Boeing747Engine();
    }

    @Override
    public IWings createWings() {
        return new Boeing747Wings();
    }

    @Override
    public ICockpit createCockpit() {
        return new Boeing747Cockpit();
    }
}

class Aircraft {

    IEngine engine;
    ICockpit cockpit;
    IWings wings;
    IAircraftFactory factory;

    public Aircraft(IAircraftFactory factory) {
        this.factory = factory;
    }

    protected Aircraft makeAircraft() {
        engine = factory.createEngine();
        cockpit = factory.createCockpit();
        wings = factory.createWings();
        return this;
    }

    private void taxi() {
        System.out.println("Taxing on runway");
    }

    public void fly() {
        Aircraft aircraft = makeAircraft();
        aircraft.taxi();
        System.out.println("Flying");
    }
}
