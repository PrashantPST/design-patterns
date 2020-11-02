package structural.adapter;

/*
When two heads of states who don't speak a common language meet, usually a language interpreter sits between the two and translates the conversation,
thus enabling communication. The Adapter pattern is similar in that it sits between two incompatible classes that otherwise
can't work with each other and lets them work together. Another example to consider is when one buys electronics from USA and tries
to use them in India. The two countries have different power voltages being distributed to consumers and using an electronic appliance
from one country in another requires a physical adapter which steps up or down the voltage appropriately. The concept of the software
adapter pattern is similar.

Formally, the adapter pattern is defined as allowing incompatible classes to work together by converting the interface of one class into
another expected by the clients
 */

import creational.builder.IAircraft;

class HotAirBalloon {

    String gasUsed = "Helium";

    void fly(String gasUsed) {
        // Take-off sequence based on the kind of fuel
        // Followed by more code.
    }

    // Function returns the gas used by the balloon for flight
    String inflateWithGas() {
        return gasUsed;
    }
}

public class Adapter implements IAircraft {

    HotAirBalloon hotAirBalloon;

    public Adapter(HotAirBalloon hotAirBalloon) {
        this.hotAirBalloon = hotAirBalloon;
    }

    @Override
    public void fly() {
        String fuelUsed = hotAirBalloon.inflateWithGas();
        hotAirBalloon.fly(fuelUsed);
    }

    @Override
    public void land() {

    }

    @Override
    public float getWeight() {
        return 0;
    }
}
