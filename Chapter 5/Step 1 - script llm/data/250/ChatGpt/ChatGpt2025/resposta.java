import java.util.Observable;
import java.util.Observer;

public class Variable implements Observer {
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
    public void update(Observable observable, Object arg) {
        System.out.println("Value changed to " + value);
    }

    public static void main(String[] args) {
        Variable var = new Variable(10);
        var.addObserver(var); // add itself as an observer

        var.setValue(20); // change the value, and notify observers
    }
}
