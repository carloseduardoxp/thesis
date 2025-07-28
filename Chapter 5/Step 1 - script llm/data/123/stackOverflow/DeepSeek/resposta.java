import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {        
        List<MyObject> myNewCopiedList = new ArrayList<>();
        for (MyObject myo : oldList){
            myNewCopiedList.add(new MyObject(myo)); // if there is a copy constructor
            myNewCopiedList.add(myo.clone()); // if there is clone method
        }
    }
}