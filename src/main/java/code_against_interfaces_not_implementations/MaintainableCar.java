package code_against_interfaces_not_implementations;

public class MaintainableCar {
    Wheels wheels;

    MaintainableCar(){}

    MaintainableCar(Wheels wheels){
        this.wheels = wheels;
    }

    void roll(){
        wheels.roll();
    }

    void changeWheels(Wheels newWheels){
        this.wheels = newWheels;
    }
}
