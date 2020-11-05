package behavioral.iterator;

/*
ArrayList<String> companiesIWantToInterviewFor = new ArrayList<>();
        companiesIWantToInterviewFor.add("SnapChat");
        companiesIWantToInterviewFor.add("Twitter");
        companiesIWantToInterviewFor.add("Tesla");

        Iterator<String> it = companiesIWantToInterviewFor.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
 */

/*
An iterator is formally defined as a pattern that allows traversing the elements of an aggregate or a collection sequentially without exposing the
underlying implementation.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import creational.builder.Boeing747;
import creational.builder.F16;
import creational.builder.IAircraft;

public interface Iterator {

    IAircraft next();

    boolean hasNext();
}

class AirForce {

    List<IAircraft> jets  = new ArrayList<>();
    IAircraft[]           helis = new IAircraft[1];
    LinkedList<Boeing747> cargo = new LinkedList<>();

    public List<IAircraft> getJets() {
        return jets;
    }

    public IAircraft[] getHelis() {
        return helis;
    }

    public LinkedList<Boeing747> getCargo() {
        return cargo;
    }

    public AirForce() {
        jets.add(new F16());
        helis[0] = new CobraGunship();
        cargo.add(new Boeing747());
    }

    // This method returns a concrete iterator that
    // traverses over the entire airforce planes.
    public Iterator createIterator() {
        return new AirForceIterator(this);

    }

    // This method returns a different concrete iterator
    // that traverses over only the jets in the airforce.
    public Iterator createJetsIterator() {
        return new JetsIterator(jets);
    }
}

class AirForceIterator implements Iterator {

    List<IAircraft> jets;
    IAircraft[] helis;
    LinkedList<Boeing747> cargo;
    int jetsPosition = 0;
    int helisPosition = 0;
    int cargoPosition = 0;

    /**
     * The iterator is composed with the object it'll be iterating over
     */
    public AirForceIterator(AirForce airForce) {
        jets = airForce.getJets();
        helis = airForce.getHelis();
        cargo = airForce.getCargo();

    }

    @Override
    /**
     * We provide our own custom logic of returning aircraft in a
     * sequence. Note we are returning IAircraft interface object which
     * every plane in our airforce implements. We also design the function
     * to throw a runtime exception if next is invoked when no more elements
     * are left to iterate over
     */
    public IAircraft next() {

        // return helis first
        if (helisPosition < helis.length) {
            return helis[helisPosition++];
        }

        // return jets second
        if (jetsPosition < jets.size()) {
            return jets.get(jetsPosition++);
        }

        // return cargos last
        if (cargoPosition < cargo.size()) {
            return cargo.get(cargoPosition++);
        }

        throw new RuntimeException("No more elements");

    }

    @Override
    public boolean hasNext() {

        return helis.length > helisPosition ||
                jets.size() > jetsPosition ||
                cargo.size() > cargoPosition;
    }
}

class Main {
    public static void main(String[] args) {
        AirForce airForce = new AirForce();

        Iterator jets = airForce.createJetsIterator();

        while (jets.hasNext()) {
            jets.next();
        }

        Iterator allPlanes = airForce.createIterator();

        while (allPlanes.hasNext()) {
            allPlanes.next();
        }
    }
}
