import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// 1. The data class (the "bean")
class MyDataModel {
    private String name;
    private int age;

    // PropertyChangeSupport instance
    private PropertyChangeSupport support;

    public MyDataModel() {
        this.support = new PropertyChangeSupport(this);
    }

    // Methods to add/remove listeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    // Getter for 'name' property
    public String getName() {
        return name;
    }

    // Setter for 'name' property - fires a PropertyChangeEvent
    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        // Notify listeners if the name actually changed
        support.firePropertyChange("name", oldName, newName);
    }

    // Getter for 'age' property
    public int getAge() {
        return age;
    }

    // Setter for 'age' property - fires a PropertyChangeEvent
    public void setAge(int newAge) {
        int oldAge = this.age;
        this.age = newAge;
        // Notify listeners if the age actually changed
        support.firePropertyChange("age", oldAge, newAge);
    }
}

// 2. The listener class
class MyDataChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed:");
        System.out.println("  Property Name: " + evt.getPropertyName());
        System.out.println("  Old Value: " + evt.getOldValue());
        System.out.println("  New Value: " + evt.getNewValue());
        System.out.println("  Source: " + evt.getSource().getClass().getSimpleName());
    }
}

public class VariableListenerDemo {
    public static void main(String[] args) {
        MyDataModel model = new MyDataModel();
        MyDataChangeListener listener = new MyDataChangeListener();

        // 3. Register the listener
        model.addPropertyChangeListener(listener);

        System.out.println("Setting name to Alice...");
        model.setName("Alice"); // This will trigger the listener

        System.out.println("\nSetting age to 30...");
        model.setAge(30); // This will trigger the listener

        System.out.println("\nSetting name to Bob...");
        model.setName("Bob"); // This will trigger the listener

        System.out.println("\nSetting age to 30 again (no change, no event fired by default)...");
        model.setAge(30); // No change, so no event will be fired by the default firePropertyChange behavior

        // You can also add specific listeners for specific properties
        model.addPropertyChangeListener("name", evt -> 
            System.out.println("\n(Specific listener) Name property changed from " + evt.getOldValue() + " to " + evt.getNewValue())
        );

        System.out.println("\nSetting name to Charlie (will trigger both listeners)...");
        model.setName("Charlie");
    }
}