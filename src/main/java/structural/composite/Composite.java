package structural.composite;

import java.util.ArrayList;
import java.util.Iterator;

import creational.builder.IAircraft;

/*
Each aircraft requires some number of pilots to operate and maybe peripheral staff for maintenance.
The classes would implement the functionality to return the number of personnel required for the aircraft to operate.
The Airforce class should return the total number of personnel required to operate all the aircraft composed of the airforce.
 */
interface IAlliancePart {

    // Any implementing class should return the
    // the number of personnel or staff required
    // to operate the aircraft or the air force
    int getPersonnel();
}



public class Composite {
    public static void main(String[] args) {
        Airforce NatoAllaiance = new Airforce();

        F16 frenchF16 = new F16();
        C130Hercules germanCargo = new C130Hercules();

        NatoAllaiance.add(frenchF16);
        NatoAllaiance.add(germanCargo);

        System.out.println(NatoAllaiance.getPersonnel());
    }
}

class Airforce implements IAlliancePart {

    ArrayList<IAlliancePart> planes = new ArrayList<>();

    public void add(IAlliancePart alliancePart) {
        planes.add(alliancePart);
    }

    @Override
    public int getPersonnel() {

        // We iterator over the entire air force which can
        // contain leaf nodes (planes) or other composites
        // (air forces). This iteration is an example of an
        // internal iterator.
        Iterator<IAlliancePart> itr = planes.iterator();
        int staff = 0;

        while (itr.hasNext()) {
            staff += itr.next().getPersonnel();
        }

        return staff;
    }
}

class F16 implements IAircraft, IAlliancePart {

    @Override
    public int getPersonnel() {
        // We need 2 pilots for F-16
        return 2;
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

class C130Hercules implements IAircraft, IAlliancePart {

    @Override
    public int getPersonnel() {
        // This cargo plane, needs 5 people
        return 5;
    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }

    @Override
    public float getWeight() {
        return baseWeight;
    }
}