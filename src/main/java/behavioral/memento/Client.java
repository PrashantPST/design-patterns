package behavioral.memento;

public class Client {

    public void main(BlackBox blackBox) throws Exception{

        // Save the state of the memento as a byte stream.
        byte[] memento = blackBox.getState();

        // Do some work.

        // Now restore the blackbox to the previous state
        blackBox = blackBox.setState(memento);

    }

}
