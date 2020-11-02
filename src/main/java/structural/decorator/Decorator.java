package structural.decorator;

import creational.builder.Boeing747;
import creational.builder.IAircraft;

/*

What is it ?
A decoration is added to something to make it more attractive, in the same spirit, the decorator pattern adds new functionality to objects without
modifying their defining classes.
The decorator pattern can be thought of as a wrapper or more formally a way to enhance or extend the behavior of an object dynamically.
The pattern provides an alternative to subclassing when new functionality is desired.

 */
public class Decorator {
    public static void main(String[] args) {
        IAircraft simpleBoeing = new Boeing747();
        IAircraft luxuriousBoeing = new LuxuryFittings(simpleBoeing);
        IAircraft bulletProofBoeing = new BulletProof(luxuriousBoeing);
        float netWeight = bulletProofBoeing.getWeight();
        System.out.println("Final weight of the plane: " + netWeight);
    }
}

abstract class BoeingDecorator implements IAircraft {


}

class LuxuryFittings extends BoeingDecorator {

    IAircraft boeing;

    public LuxuryFittings(IAircraft boeing) {
        this.boeing = boeing;
    }

    @Override
    public void fly() {
        boeing.fly();
    }

    @Override
    public void land() {
        boeing.land();
    }

    @Override
    public float getWeight() {
        return (30.5f + boeing.getWeight());
    }
}

class BulletProof extends BoeingDecorator {

    IAircraft boeing;

    public BulletProof(IAircraft boeing) {
        this.boeing = boeing;
    }

    @Override
    public void fly() {
        boeing.fly();
    }

    @Override
    public void land() {
        boeing.land();
    }

    @Override
    public float getWeight() {
        return 50f + boeing.getWeight();
    }
}

/*

Other Examples
A prominent example of this pattern is the java.io package, which includes several decorators. Look at the snippet below:

    public void main() {
        // FileInputStream is responsible for reading the file
        FileInputStream fileInputStream = new FileInputStream("myFile.txt");
        // BufferedInputStream extends FilterInputStream and not FileInputStream, it is
        // a decorator which enhances the functionality of the original object by wrapping over it.
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // The read operation becomes buffered now
        bufferedInputStream.read();
    }
The FileInputStream is the object actually responsible for reading the text file. If we wanted to introduce buffered read functionality,
one way of doing it would be to subclass FileInputStream and add the new functionality. The other is to use the decorator pattern which is how it
is implemented in the Java framework. The BufferedInputStream wraps the FileInputStream to provide buffering capabilities.

 */
