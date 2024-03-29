package Interfaces;
import java.awt.datatransfer.Transferable;
import java.util.Deque;

/**
 * @author SM
 * Interface for objects that have a TransportableHolder
 */
public interface ITransportableHolder<T extends ITransportable> {
    int getMaxLoad();
    void setMaxLoad(int maxLoad);

    /**
     * Stack for all loaded transports
     * @return Returns loaded transports
     */
    Deque<T> getLoadedTransport();

    /**
     * Loads given object onto the TransportableHolder
     * @param transport The object to be loaded
     * @return Returns true if load was successful
     */
    void loadTransport(T transport);

    /**
     * Drops most recently object to be loaded
     * @return Returns the object that was most recently loaded
     */
    void dropTransport();
}