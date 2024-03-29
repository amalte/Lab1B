import Interfaces.IRamp;
import Interfaces.ITransportable;
import Interfaces.ITransportableHolder;

import java.awt.*;
import java.util.Deque;

/**
 * @author SM
 * Subclass of Truck. Represents a truck of model VolvoFH16 that has a ramp and can hold Transportables (implements IRamp and ITransportableHolder)
 */
public class VolvoFH16 extends Truck implements ITransportableHolder<Car> {

    /**
     * This truck has a ramp and can hold Transportables (implements Interfaces.IRamp and ITransportableHolder)
     */
    private Ramp ramp;
    private TransportableHolder transportableHolder;

    /**
     * Constructor for VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "VolvoFH16", 2.5, 3, 9);
        transportableHolder = new TransportableHolder<Car>(5, 2, 1.8, 5, 3, getX(), getY());
        ramp = new Ramp();
    }

    public void openRamp() {
        if(!isMoving()) {
            ramp.openRamp();
        }
    }

    public void closeRamp() {
        ramp.closeRamp();
    }

    public boolean isRampOpen() {
        return ramp.isRampOpen();
    }

    public void setRampOpen(boolean open) {
        ramp.setRampOpen(open);
    }

    @Override
    public void loadTransport(Car t) {
        if(!isMoving() && isRampOpen() && transportableHolder.isTransportLoadable(t)) {
            transportableHolder.loadTransport(t);
        }
    }

    @Override
    public void dropTransport() {
        if(!isMoving() && isRampOpen()) {
            transportableHolder.dropTransport();
        }
    }

    @Override
    public int getMaxLoad() {
        return transportableHolder.getMaxLoad();
    }

    @Override
    public void setMaxLoad(int maxLoad) {
        transportableHolder.setMaxLoad(maxLoad);
    }

    @Override
    public Deque<Car> getLoadedTransport() {
        return transportableHolder.getLoadedTransport();
    }

    @Override
    public void move() {
        super.move();
        transportableHolder.updatePosition(getX(), getY());
    }

    @Override
    public void gas(double amount) {
        if(!isRampOpen()) {
            super.gas(amount);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(!isRampOpen()) {
            super.setCurrentSpeed(speed);
        }
    }
}
