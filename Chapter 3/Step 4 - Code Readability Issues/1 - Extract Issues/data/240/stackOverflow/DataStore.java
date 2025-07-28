import java.util.*;

public class DataStore {
    Map<ID, DataObject> objMap; // ...
    ReadWritLock objMapLock = new ReentrantReadWriteLock();
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
            synchronized(dataObj) {
                // do what u need
            }
        } finally {
            objMapLock.readLock().unlock();
        }

    }
}