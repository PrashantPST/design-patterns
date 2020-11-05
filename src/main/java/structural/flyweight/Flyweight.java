package structural.flyweight;

/*

What is it ?
Flyweight is a category in boxing competitions for light weight boxers. The intent of the pattern is somewhat similar in that it tries to reduce
bloated code to a more compact and lean representation, which uses less memory.

Formally, the pattern is defined as sharing state among a large number of fine-grained objects for efficiency.

 */

/*

Using the flyweight pattern, we can move the extrinsic state of the object outside of the class and only keep the intrinsic state within the class.
This change would allow us to reuse the same F-16 object for all the F-16s that are currently airborne and show up on the radar.
The number of objects required to represent the flying F-16s would drastically reduce. The extrinsic state of the planes can always be passed-in
to the methods that use it.

 */

/*

The astute reader would immediately question where do we keep the extrinsic state? That can be kept in a separate context object.
But then you may retort that it is like going back to square one, for now, we are creating more objects and the whole purpose of the pattern was to
reduce the number of objects. Your observation is correct, however, note that the context object only contains that information which varies per
instance of F-16. The information which is common across the F-16 instances is stored in a flyweight object. Earlier, we had a single heavyweight
object that contained both kinds of information and was needed per instance of F-16. With the break-up, the single heavyweight object becomes a
flyweight object used by all F-16s consisting of information that'll not change and an additional context object per F-16 instance consisting of
information that'll change for each instance of the F-16. Since we are keeping a single copy of the non-varying information, we'll witness memory savings.

 */

import creational.builder.IAircraft;

class F16 implements IAircraft {

    // Intrinsic state
    private final String name = "F16";
    private final int personnel = 2;
    private final String dimensions = "15m long 3m wide";
    private final String wingspan = "33 feet";

    // Extrinsic state includes the current position and current speed
    // of the aircraft that is being passed in for computing remaining
    // time to destination
    public double getTimeToDestination(int currX, int currY, int destX, int destY, int currSpeed) {

        // algorithm to calculate the remaining time to reach
        // destination.

        return 1;
    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }

    @Override
    public float getWeight() {
        return 0;
    }
}

public class Flyweight {
    public static void main(String[] args) {
        F16 flyweightF16 = new F16();

        for (int i = 0; i < coordsF16.length; i++) {
            int currX = coordsF16[i][0];
            int currY = coordsF16[i][1];

            // We are passing in the extrinsic state to the flyweight object. Note we are storing the
            // extrinsic state of the airborne f16s in a 2-dimensional array.
            System.out.println("time to destination = " +
                                       flyweightF16.getTimeToDestination(currX, currY, 10, 10, 200));
        }
    }
}
