package behavioral.mediator;

/*
Formally, the pattern is defined as encouraging loose coupling among interacting objects by encapsulating their interactions in a mediator object,
thus avoiding the need for individual objects to refer to each other directly and allowing to vary object interactions independently.
 */

/*
Also note that in the absence of the mediator, the objects are engaged in many-to-many interactions but when the mediator is introduced the interactions
become one-to-many between the mediator and the other participating objects.
 */

import java.util.ArrayList;
import java.util.List;

import creational.builder.IAircraft;

/*
Imagine an airport without an air-traffic control tower. All the airplanes in flight, about to land and about to take-off need to be aware of every other
airplane to coordinate the use of the runways as well as the airspace. There are in a sense dependent on each other to avoid a disaster but this leads
to having too many interconnections among objects. With a single runway, the worst case is every airplane has to know about every other airplane about
to land or take-off to avoid collisions. The control tower object can act as a mediator and communication hub for all the airplanes and ensure
a smooth working of the airport.
 */
public class Mediator {
    public static void main(String[] args) {

    }
}

class ControlTower {

    List<IAircraft> queuedForLanding = new ArrayList<>();

    // An aircraft just notifies the control tower that it wants to
    // land and doesn't coordinate with other aircraft
    synchronized public void requestToLand(IAircraft aircraft) {
        queuedForLanding.add(aircraft);
    }

    public void run() {

        // perpetual loop
        while (true) {

            // inefficient busy wait till aircraft requests to land
            while(queuedForLanding.size() == 0);

            IAircraft aircraft;
            synchronized (this) {
                aircraft = queuedForLanding.remove(0);
            }
            // We have only one runway available so only allow a single
            // aircraft to land.
            aircraft.land();
        }
    }
}

class F16 implements IAircraft {

    ControlTower controlTower;

    public F16(ControlTower controlTower) {
        this.controlTower = controlTower;
    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {
        System.out.println("F16 landing...");
    }

    @Override
    public float getWeight() {
        return 0;
    }

    public void requestControlTowerToLand() {
        controlTower.requestToLand(this);

    }
}
