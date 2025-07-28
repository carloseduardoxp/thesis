import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataStore {
    Map<ID, DataObject> objMap; // ...
    ReadWriteLock objMapLock = new ReentrantReadWriteLock();
    // other indices and stuff...
    public void addDataObject(DataObject obj) {
        objMapLock.writeLock().lock();
        try {
            // do what u need, u may synchronize on obj too, depends on situation
            objMap.put(obj.getId(), obj);
        } finally {
            objMapLock.writeLock().unlock();
        }
    }

    public final void doSomethingToObject(ID id) { 
        objMapLock.readLock().lock();
        try {
            DataObject dataObj = this.objMap.get(id);
        } finally {
            objMapLock.readLock().unlock();
        }

    }
}
