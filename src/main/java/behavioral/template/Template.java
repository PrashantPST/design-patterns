package behavioral.template;

/*
The template method pattern is similar, it defines the skeleton or steps of an algorithm but leaves opportunities for subclasses to override some of the
steps with their own implementations.
 */

/*
Formally, the pattern is defined as allowing subclasses to define parts of an algorithm without modifying the overall structure of the algorithm.
 */

/*
The template pattern method is very suitable for frameworks. A framework generally defines the application control flow and gives developers the
opportunity to override certain methods to customize the flow of their application needs
 */

/*
Let's take our aircraft example. Before each flight there's a list of tasks the pilots must go through that is called the "pre-flight checklist".
You can well imagine that for most of the aircrafts this list would have a lot of commonalities. Therefore, it makes sense to model an abstract class
that captures all the tasks in the preflight checklist in the order they should be performed.
 */

abstract class AbstractPreFlightCheckList {

    // This method captures the template or the skeleton
    // of the algorithm for the pre-flight checklist.
    final public void runChecklist() {

        // Check fuel guage
        IsFuelEnough();

        // Check doors are locked
        doorsLocked();

        // Check air pressure
        checkAirPressure();
    }

    // Don't let subclasses override this method, this is a
    // mandatory check
    final protected void IsFuelEnough() {
        System.out.println("check fuel gauge");
    }

    // Some airplanes may or may not have doors so allow this
    // method to be overridden by subclasses
    protected boolean doorsLocked() {
        return true;
    }

    // Force subclasses to provide their own way of checking for
    // cabin or cockpit air pressure
    abstract void checkAirPressure();
}

class F16PreFlightCheckList extends AbstractPreFlightCheckList {

    @Override
    void checkAirPressure() {
        // Implement the custom logic for checking cockpit
        // air pressure for F-16
    }

    @Override
    protected boolean doorsLocked() {
        // F-16 unlike a Boeing-747 has no doors
        // so always return true;
        return true;
    }
}
