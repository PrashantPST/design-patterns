public class AirforceOne {

    // The sole instance of the class
    private static AirforceOne onlyInstance;

    // Make the constructor private so its only accessible to
    // members of the class.
    private AirforceOne() {
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }

    // Create a static method for object creation
    public static AirforceOne getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            onlyInstance = new AirforceOne();
        }

        return onlyInstance;
    }
}

public class Client {

    public void main() {
        AirforceOne airforceOne = AirforceOne.getInstance();
        airforceOne.fly();
    }
}

/*
Multithreading and Singleton

The above code will work hunky dory as long as the application is single threaded. As soon as multiple threads start using the class,
there's a potential that multiple objects get created. Here's one example scenario:

Thread A calls the method getInstance and finds the onlyInstance to be null but before it can actually new-up the instance it gets context switched out.
Now thread B comes along and calls the getInstance method and goes on to new-up the instance and returns the AirforceOne object.
When thread A is scheduled again, is when the mischief begins.
The thread was already past the if null condition check and will proceed to new-up another object of AirforceOne and assign it to onlyInstance.
Now there are two different AirforceOne objects out in the wild, one with thread A and one with thread B.
 */

/*
There are two trivial ways to fix this race condition.

One is to add synchronized to the getInstance() method.
synchronized public static AirforceOne getInstance()
The other is to undertake static initialization of the instance, which is guaranteed to be thread-safe.
    // The sole instance of the class
    private static AirforceOne onlyInstance = new AirforceOne();
The problem with the above approaches is that synchronization is expensive
 */