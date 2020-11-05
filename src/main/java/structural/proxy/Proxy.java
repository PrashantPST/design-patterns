package structural.proxy;


import java.util.Scanner;

/*

Virtual Proxy
Think of instagram running on a very weak internet connection on a mobile phone. The pictures aren't loaded quickly enough but to ensure a pleasant
user experience, a loading widget can appear on the mobile screen while the image gets downloaded in the background.
The loading widget would act as a proxy for the picture and might have related information about the picture such as the dimensions of the picture,
which it can provide to the display frame before the picture download is complete.

 */
public class Proxy {
    public static void main(DroneProxy droneProxy) {
        // perpetual loop that received pilot actions
        while (true) {

            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();

            switch (action) {
                case "left": {
                    droneProxy.turnLeft();
                    break;
                }

                case "right": {
                    droneProxy.turnRight();
                    break;
                }

                case "fire": {
                    droneProxy.fireMissile();
                    break;
                }

                default:
                    System.out.println("Invalid Action");
            }
        }
    }
}

interface IDrone {

    void turnLeft();

    void turnRight();

    void fireMissile();
}

class DroneProxy implements IDrone {

    @Override
    public void turnLeft() {
        // forward request to the real drone to
        // turn left over the internet
    }

    @Override
    public void turnRight() {
        // forward request to the real drone to
        // turn right over the internet
    }

    @Override
    public void fireMissile() {
        // forward request to the real drone to
        // fire missile
    }
}


class Drone implements IDrone {

    @Override
    public void turnLeft() {
        // receives the request and any method parameters
        // over the internet to turn the drone to its left.
    }

    @Override
    public void turnRight() {
        // receives the request and any method parameters
        // over the internet to turn the drone to its right.
    }

    @Override
    public void fireMissile() {
        // receives the request and any method parameters
        // over the internet to fire a missile
    }
}