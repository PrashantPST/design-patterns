package behavioral.iterator;

import java.util.List;

import creational.builder.IAircraft;

public class JetsIterator implements Iterator {
    public JetsIterator(List<IAircraft> jets) {}

    @Override
    public IAircraft next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
