enum State {
    IDLE,
    RUNNING,
    PAUSED,
    STOPPED
}

enum Event {
    START,
    PAUSE,
    RESUME,
    STOP
}

class StateMachine {
    private State currentState;

    public StateMachine() {
        // Initialize the state machine to a default state
        this.currentState = State.IDLE;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void handleEvent(Event event) {
        switch (currentState) {
            case IDLE:
                if (event == Event.START) {
                    currentState = State.RUNNING;
                    System.out.println("State changed to RUNNING");
                }
                break;
            case RUNNING:
                if (event == Event.PAUSE) {
                    currentState = State.PAUSED;
                    System.out.println("State changed to PAUSED");
                } else if (event == Event.STOP) {
                    currentState = State.STOPPED;
                    System.out.println("State changed to STOPPED");
                }
                break;
            case PAUSED:
                if (event == Event.RESUME) {
                    currentState = State.RUNNING;
                    System.out.println("State changed to RUNNING");
                } else if (event == Event.STOP) {
                    currentState = State.STOPPED;
                    System.out.println("State changed to STOPPED");
                }
                break;
            case STOPPED:
                if (event == Event.START) {
                    currentState = State.RUNNING;
                    System.out.println("State changed to RUNNING");
                }
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();

        System.out.println("Current state: " + stateMachine.getCurrentState());

        // Handle events
        stateMachine.handleEvent(Event.START);
        System.out.println("Current state: " + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.PAUSE);
        System.out.println("Current state: " + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.RESUME);
        System.out.println("Current state: " + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.STOP);
        System.out.println("Current state: " + stateMachine.getCurrentState());
    }
}
