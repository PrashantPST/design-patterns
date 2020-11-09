package behavioral.memento;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BlackBox implements Serializable {

    private long altitude;
    private double speed;
    private float engineTemperature;
    private static final long serialVersionUID = 1L;

    public BlackBox(long altitude, double speed, float engineTemperature) {
        this.altitude = altitude;
        this.speed = speed;
        this.engineTemperature = engineTemperature;
    }

    // Saving the state of the object as a byte stream
    public byte[] getState() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        byte[] memento = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.flush();
            memento = bos.toByteArray();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return memento;
    }

    // Restoring state from memento
    public BlackBox setState(byte[] memento) throws Exception {
        ByteInputStream bis = new ByteInputStream(memento, memento.length);

        ObjectInputStream objectInputStream = new ObjectInputStream(bis);
        BlackBox blackBox = (BlackBox) objectInputStream.readObject();
        objectInputStream.close();
        return blackBox;
    }
}