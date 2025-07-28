
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class ObservableValue {

    private int value;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        int oldValue = this.value;
        this.value = newValue;
        pcs.firePropertyChange("value", oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}

public class DeepSeek {

    public static void main(String[] args) {
// Usage:
        ObservableValue observable = new ObservableValue();
        observable.addPropertyChangeListener(evt -> {
            System.out.println("Value changed from " + evt.getOldValue() + " to " + evt.getNewValue());
        });
        observable.setValue(10);

    }
}
