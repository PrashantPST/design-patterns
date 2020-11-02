package structural.bridge;

public abstract class AbstractCorolla {
    protected AbstractCorollaImpl corollaImpl;

    public AbstractCorolla(AbstractCorollaImpl corollaImpl) {
        this.corollaImpl = corollaImpl;
    }

    abstract void listSafetyEquipment();

    abstract boolean isCarRightHanded();

    public void setCorollaImpl(AbstractCorollaImpl abstractCorollaImpl) {
        this.corollaImpl = abstractCorollaImpl;
    }
}


abstract class AbstractCorollaImpl {

    abstract void listSafetyEquipment();

    abstract boolean isCarRightHanded();
}

class CorollaL extends AbstractCorolla {

    public CorollaL(AbstractCorollaImpl corollaImpl) {
        super(corollaImpl);
    }

    @Override
    void listSafetyEquipment() {
        corollaImpl.listSafetyEquipment();

    }

    @Override
    boolean isCarRightHanded() {
        return corollaImpl.isCarRightHanded();
    }
}

class CorollaLImplAsiaPacific extends AbstractCorollaImpl {

    @Override
    void listSafetyEquipment() {
        System.out.println("Not so safe.");
    }

    @Override
    boolean isCarRightHanded() {
        return false;
    }
}

class CorollaLImplNorthAmerica extends AbstractCorollaImpl {

    @Override
    void listSafetyEquipment() {
        System.out.println("High safety standards.");
    }

    @Override
    boolean isCarRightHanded() {
        return true;
    }
}

class Client {

    public static void main(String[] args) {

        AbstractCorolla myCorolla = new CorollaL(new CorollaLImplAsiaPacific());
        System.out.println(myCorolla.isCarRightHanded());

        myCorolla.setCorollaImpl(new CorollaLImplNorthAmerica());
        System.out.println(myCorolla.isCarRightHanded());
    }
}

/*
Note how the client can switch out the implementation class object at runtime and make the model behave for an entirely different location.
Using the bridge pattern we have avoided permanent binding of models and their intended locations of operation.
The client can continue to work with the objects of the abstraction layer without noticing any changes to implementation layer classes.
New safety rules or regulations would only affect the implementation layer classes.
 */
