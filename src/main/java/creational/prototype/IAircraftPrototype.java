package creational.prototype;

import creational.factory.F16Engine;

public interface IAircraftPrototype {
    void fly();

    IAircraftPrototype clone();

    void setEngine(F16Engine f16Engine);
}
