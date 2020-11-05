package behavioral.chain_of_responsibility;

/*
The requester has no knowledge of the object that will eventually handle its request nor does it have a reference to the handling object. Similarly,
the object eventually handling the request isn't aware of the requester.

Usually the pattern is applied when the request can be handled by multiple objects and it is not known in advance which object will end up handling
the request.

Say, if an engine failure happens, there might be a series of corrective actions that can try to fix the problem successively.

 */

public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Setup the chain like so:
        // FireHandler --> LowFuelHandler --> null
        // The chain has just two handlers with the firstHandler
        // at the head of the chain.
        AbstractHandler lowFuelHandler = new LowFuelHandler(null);
        FireHandler fireHandler = new FireHandler(lowFuelHandler);

        // Create a emergency request that the airplane is running low
        // on fuel.
        LowFuelRequest lowFuelRequest = new LowFuelRequest();

        // Let the chain handle the request
        fireHandler.handleRequest(lowFuelRequest);
    }
}

abstract class AbstractRequest {

    // Each request is identified by a an integer
    // FireRequest: 1
    // LowFuelRequest: 2
    private int requestCode;

    public AbstractRequest(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getRequestCode() {
        return requestCode;
    }
}

abstract class AbstractHandler {

    private AbstractHandler next;

    public AbstractHandler(AbstractHandler next) {
        this.next = next;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public void handleRequest(AbstractRequest request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }
}

class FireDetectedRequest extends AbstractRequest {

    // Fire request is assigned code of 1
    public FireDetectedRequest() {
        super(1);
    }
}

class LowFuelRequest extends AbstractRequest {

    // Low on fuel request is assigned code of 2
    public LowFuelRequest() {
        super(2);
    }
}

class FireHandler extends AbstractHandler {

    // Only interested in handling requests with code 1
    private static int code = 1;

    public FireHandler(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if (code == request.getRequestCode()) {
            // Handle the request here.
        } else {
            // If the handler, doesn't handle these type of
            // requests, it can just call the super class's
            // forward request method.
            super.handleRequest(request);
        }
    }
}
