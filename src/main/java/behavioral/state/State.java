package behavioral.state;

/*
Without the use of the pattern, the code becomes inflexible and littered with if-else conditionals.

 */

/*
// Pilot takes the taxi action
public void pilotTaxies(String currentState) {

        if (currentState == "Parked") {

        currentState = "Taxi";
        System.out.println("Plane is taxing on the runway.");

        } else if (currentState == "Airborne") {

        System.out.println("This is an invalid operation for this state");

        } else if (currentState == "Land") {

        System.out.println("This is an invalid operation for this state");

        } else if (currentState == "Crashed") {

        System.out.println("This is an invalid operation for this state");

        } else if(currentState == "Taxi"){
        System.out.println("Plane is already taxing on the runway.");
        }

        }
*/

/*
The state pattern will create classes for each of the possible states and each class implements the state-specific behavior.
 */

import creational.builder.F16;

/**
 * This interface defines the actions a pilot
 * can take against the aircraft object. Each
 * action will move the aircraft into a different
 * state
 */
interface IPilotActions {

    void pilotTaxies(F16 f16);

    void pilotFlies(F16 f16);

    void pilotEjects(F16 f16);

    void pilotLands(F16 f16);

    void pilotParks(F16 f16);
}


public class ParkedState implements IPilotActions {

    F16 f16;

    // Notice, how the state class is composed with the context object
    public ParkedState(F16 f16) {
        this.f16 = f16;
    }

    @Override
    public void pilotTaxies(F16 f16) {
        f16.setState(f16.getTaxiState());
    }

    @Override
    public void pilotFlies(F16 f16) {
        System.out.println("This is an invalid operation for this state");
    }

    @Override
    public void pilotEjects(F16 f16) {
        f16.setState(f16.getCrashState());

    }

    @Override
    public void pilotLands(F16 f16) {
        System.out.println("This is an invalid operation for this state");
    }

    @Override
    public void pilotParks(F16 f16) {
        System.out.println("This is an invalid operation for this state");
    }
}

public class State {
    public static void main(String[] args) {
        F16 f16 = new F16();
        f16.startsEngine();
        f16.fliesPlane();
        f16.ejectsPlane();
    }
}
