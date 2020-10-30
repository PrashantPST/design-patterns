package code_against_interfaces_not_implementations;

public class Car {
    // This are the default wheels
    private DefaultWheels carWheel;

    Car(DefaultWheels wheels){
        carWheel = wheels;
    }

    void roll(){
        carWheel.roll();
    }

    // at this point, your car is hard coded to use just the default wheels.
    // putting other wheels on it will not work (obviously).
}
