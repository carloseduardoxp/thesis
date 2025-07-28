import java.util.Observable;
import java.util.Observer;

public class Variable extends Observable implements Observer {
    private int value;

    public Variable(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
        setChanged();
        notifyObservers();
    }

    public int getValue() {
        return value;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Value changed to " + value);
    }

    public static void main(String[] args) {
        Variable myVariable = new Variable(10);
        myVariable.addObserver(myVariable); // add itself as an observer

        myVariable.setValue(20); // change the value, and notify observers
    }
}
