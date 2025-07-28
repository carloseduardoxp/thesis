import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Event.java
class Event {
    private String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Event [name=" + name + "]";
    }
}

// CustomEvent.java
class CustomEvent extends Event {
    private String message;

    public CustomEvent(String name, String message) {
        super(name);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CustomEvent [name=" + getName() + ", message=" + message + "]";
    }
}

// EventListener.java
interface EventListener {
    void onEvent(Event event);
}

// ConcreteListener.java
class ConcreteListener implements EventListener {
    private String listenerName;

    public ConcreteListener(String listenerName) {
        this.listenerName = listenerName;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println(listenerName + " received event: " + event.getName());
        if (event instanceof CustomEvent) {
            CustomEvent customEvent = (CustomEvent) event;
            System.out.println("  Custom message: " + customEvent.getMessage());
        }
    }
}

// EventManager.java
class EventManager {
    private Map<String, List<EventListener>> listeners;

    public EventManager() {
        this.listeners = new HashMap<>();
    }

    public void registerListener(String eventName, EventListener listener) {
        listeners.computeIfAbsent(eventName, k -> new ArrayList<>()).add(listener);
        System.out.println("Registered listener " + listener.getClass().getSimpleName() +
                         " for event: " + eventName);
    }

    public void unregisterListener(String eventName, EventListener listener) {
        List<EventListener> eventListeners = listeners.get(eventName);
        if (eventListeners != null) {
            eventListeners.remove(listener);
            System.out.println("Unregistered listener " + listener.getClass().getSimpleName() +
                             " from event: " + eventName);
            if (eventListeners.isEmpty()) {
                listeners.remove(eventName);
            }
        }
    }

    public void fireEvent(Event event) {
        System.out.println("\nFiring event: " + event.getName());
        List<EventListener> eventListeners = listeners.get(event.getName());
        if (eventListeners != null && !eventListeners.isEmpty()) {
            for (EventListener listener : new ArrayList<>(eventListeners)) {
                listener.onEvent(event);
            }
        } else {
            System.out.println("No listeners registered for event: " + event.getName());
        }
    }
}

// Main.java
public class Main {
    private static final String USER_LOGGED_IN = "UserLoggedIn";
    private static final String CUSTOM_ACTION = "CustomAction";

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        ConcreteListener listener1 = new ConcreteListener("Listener A");
        ConcreteListener listener2 = new ConcreteListener("Listener B");
        ConcreteListener listener3 = new ConcreteListener("Listener C");

        eventManager.registerListener(USER_LOGGED_IN, listener1);
        eventManager.registerListener(USER_LOGGED_IN, listener2);
        eventManager.registerListener("ProductPurchased", listener2);
        eventManager.registerListener("OrderProcessed", listener3);
        eventManager.registerListener(CUSTOM_ACTION, listener1);
        eventManager.registerListener(CUSTOM_ACTION, listener3);

        eventManager.fireEvent(new Event(USER_LOGGED_IN));
        eventManager.fireEvent(new Event("ProductViewed"));
        eventManager.fireEvent(new CustomEvent(CUSTOM_ACTION, "User performed a special action!"));
        eventManager.fireEvent(new Event("ProductPurchased"));

        eventManager.unregisterListener(USER_LOGGED_IN, listener1);

        eventManager.fireEvent(new Event(USER_LOGGED_IN));
        eventManager.fireEvent(new CustomEvent(CUSTOM_ACTION, "Another custom action occurred!"));
    }
}