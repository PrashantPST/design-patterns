package code_against_interfaces_not_implementations;

public class InterfaceBlogExample {
    public static void main(String[] args) {
        // Creating hard coded wheels
        DefaultWheels hardCodedWheels = new DefaultWheels();
        // Injecting hard coded wheels
        Car nonMantainableCar = new Car(hardCodedWheels);
        nonMantainableCar.roll();
        //Rolling

        //Using interface
        Wheels defaultWheels = new DefaultWheelsImpl();
        Wheels AwesomeWheelsImpl = new  AwesomeWheelsImpl();
        // New car with default wheels
        MaintainableCar maintainableCar = new MaintainableCar(defaultWheels);
        maintainableCar.roll();
        // Went to the dealer, and decided to change wheels
        maintainableCar.changeWheels(AwesomeWheelsImpl);

        maintainableCar.roll();
        //Car still rolling
    }
}
