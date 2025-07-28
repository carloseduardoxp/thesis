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
    private static final String STATE_CHANGED_TO_RUNNING = "State changed to RUNNING";
    private static final String STATE_CHANGED_TO_PAUSED = "State changed to PAUSED";
    private static final String STATE_CHANGED_TO_STOPPED = "State changed to STOPPED";
    
    private State currentState;

    public StateMachine() {
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
                    System.out.println(STATE_CHANGED_TO_RUNNING);
                }
                break;
            case RUNNING:
                if (event == Event.PAUSE) {
                    currentState = State.PAUSED;
                    System.out.println(STATE_CHANGED_TO_PAUSED);
                } else if (event == Event.STOP) {
                    currentState = State.STOPPED;
                    System.out.println(STATE_CHANGED_TO_STOPPED);
                }
                break;
            case PAUSED:
                if (event == Event.RESUME) {
                    currentState = State.RUNNING;
                    System.out.println(STATE_CHANGED_TO_RUNNING);
                } else if (event == Event.STOP) {
                    currentState = State.STOPPED;
                    System.out.println(STATE_CHANGED_TO_STOPPED);
                }
                break;
            case STOPPED:
                if (event == Event.START) {
                    currentState = State.RUNNING;
                    System.out.println(STATE_CHANGED_TO_RUNNING);
                }
                break;
        }
    }
}

public class Main {
    private static final String CURRENT_STATE_PREFIX = "Current state: ";

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();

        System.out.println(CURRENT_STATE_PREFIX + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.START);
        System.out.println(CURRENT_STATE_PREFIX + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.PAUSE);
        System.out.println(CURRENT_STATE_PREFIX + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.RESUME);
        System.out.println(CURRENT_STATE_PREFIX + stateMachine.getCurrentState());

        stateMachine.handleEvent(Event.STOP);
        System.out.println(CURRENT_STATE_PREFIX + stateMachine.getCurrentState());
    }
}
