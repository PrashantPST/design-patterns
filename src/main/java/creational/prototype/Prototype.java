package creational.prototype;
/*
This lesson discusses how new objects can be created from existing objects using the prototype pattern.
Prototype pattern involves creating new objects by copying existing objects.

The motivations for prototype objects are as follows:
Sometimes creating new objects is more expensive than copying existing objects.

Let's take an example to better understand the prototype pattern. We'll take up our aircraft example. We created a class to represent the F-16.
However, we also know that F-16 has a handful of variants.
We can subclass the F16 class to represent each one of the variants but then we'll end up with several subclasses in our system. Furthermore,
let's assume that the F16 variants only differ by their engine types. Then one possibility could be, we retain only a single F16 class to represent
all the versions of the aircraft but we add a setter for the engine. That way, we can create a single F16 object as a prototype, clone it for the various
versions and compose the cloned jet objects with the right engine type to represent the corresponding variant of the aircraft.
 */

/*
Shallow vs Deep Copy
The prototype pattern requires that the prototype class or interface implements the clone() method.
Cloning can be either shallow or deep. Say our F-16 class has a member object of type F16Engine. In a shallow copy,
the cloned object would point to the same F16Engine object as the prototype.
The engine object would end up getting shared between the two. However, in a deep copy,
the cloned object would get a copy of its own engine object as well as any of the nested objects within it.
There will be no sharing of any fields, nested or otherwise between the prototype and the clone.
 */

/*
In Java the root Object class exposes a clone method. The class implements the interface java.lang.Cloneable.
 */

public class Prototype {
}
