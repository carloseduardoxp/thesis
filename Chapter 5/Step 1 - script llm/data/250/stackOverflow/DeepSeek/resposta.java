import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyClass {
    private final List<PropertyChangeListener> listeners = new ArrayList<>();
    private boolean b1;
    private boolean b2;

    public MyClass() {
        // Empty constructor intentionally left blank
    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        boolean oldValue = this.b1;
        this.b1 = b1;
        firePropertyChange("b1", oldValue, b1);
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        boolean oldValue = this.b2;
        this.b2 = b2;
        firePropertyChange("b2", oldValue, b2);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    private void firePropertyChange(String property, Object oldValue, Object newValue) {
        for (PropertyChangeListener l : listeners) {
            l.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    /**
     * Main method for tests.
     * @param args
     */
    public static void main(String[] args) {
        MyClass m = new MyClass();

        m.addPropertyChangeListener(e -> {
            String changedProperty = e.getPropertyName();
            System.out.println("Changed property: " + changedProperty);
            System.out.println("New value: " + e.getNewValue());
            System.out.println("Old value: " + e.getOldValue());
            System.out.println();
        });

        m.setB1(true);
        m.setB2(false);
    }
}
