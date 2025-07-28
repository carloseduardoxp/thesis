import java.util.ArrayList;
import java.util.List;

// Event.java
class Event {
    private String message;
    
    public Event(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

// EventListener.java
interface EventListener {
    void onEvent(Event event);
}


// EventSource.java
class EventSource {
    private List<EventListener> listeners = new ArrayList<>();

    // Register a listener
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    // Unregister a listener
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    // Fire an event and notify all listeners
    public void fireEvent(String message) {
        Event event = new Event(message);
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

// ConsoleLoggerListener.java
class ConsoleLoggerListener implements EventListener {
    @Override
    public void onEvent(Event event) {
        System.out.println("ConsoleLogger: " + event.getMessage());
    }
}

// FileLoggerListener.java
class FileLoggerListener implements EventListener {
    @Override
    public void onEvent(Event event) {
        System.out.println("FileLogger: Writing to file: " + event.getMessage());
        // Here you can write to a file, for example
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        // Create listeners
        ConsoleLoggerListener consoleListener = new ConsoleLoggerListener();
        FileLoggerListener fileListener = new FileLoggerListener();

        // Register listeners with the event source
        eventSource.addListener(consoleListener);
        eventSource.addListener(fileListener);

        // Fire an event
        eventSource.fireEvent("This is a test event!");

        // Unregister the console listener and fire another event
        eventSource.removeListener(consoleListener);
        eventSource.fireEvent("This is another test event!");
    }
}
