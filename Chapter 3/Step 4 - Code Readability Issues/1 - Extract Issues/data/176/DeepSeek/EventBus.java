import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Event interface
interface Event {
    String getType();
}

// EventListener interface
interface EventListener {
    void handleEvent(Event event);
}

// EventBus - central hub for event management
public class EventBus {
    private static EventBus instance;
    private final Map<String, List<EventListener>> listeners = new HashMap<>();

    // Private constructor for singleton
    private EventBus() {}

    // Get singleton instance
    public static synchronized EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    // Subscribe a listener to an event type
    public void subscribe(String eventType, EventListener listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    // Unsubscribe a listener from an event type
    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> eventListeners = listeners.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    // Publish an event to all subscribed listeners
    public void publish(Event event) {
        String eventType = event.getType();
        List<EventListener> eventListeners = listeners.get(eventType);
        if (eventListeners != null) {
            for (EventListener listener : new ArrayList<>(eventListeners)) {
                listener.handleEvent(event);
            }
        }
    }
}