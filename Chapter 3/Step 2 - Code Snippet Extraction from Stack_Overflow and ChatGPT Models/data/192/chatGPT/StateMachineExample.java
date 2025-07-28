
public class StateMachineExample {

    public static void main(String[] args) {
        // Create a new state machine
        StateMachine stateMachine = new StateMachine();

        // Trigger some events on the state machine
        stateMachine.triggerEvent(Event.A);
        stateMachine.triggerEvent(Event.B);
        stateMachine.triggerEvent(Event.C);
    }
}

// Define the possible states of the state machine
enum State {
    STATE_A,
    STATE_B,
    STATE_C
}

// Define the possible events that can trigger a state transition
enum Event {
    A,
    B,
    C
}

// Define the state machine class
class StateMachine {

    private State currentState;

    public StateMachine() {
        // Initialize the state machine with an initial state
        this.currentState = State.STATE_A;
    }

    public void triggerEvent(Event event) {
        // Handle the event based on the current state
        switch (this.currentState) {
            case STATE_A:
                if (event == Event.A) {
                    System.out.println("State A: Event A handled.");
                    this.currentState = State.STATE_B;
                } else {
                    System.out.println("State A: Unknown event.");
                }
                break;
            case STATE_B:
                if (event == Event.B) {
                    System.out.println("State B: Event B handled.");
                    this.currentState = State.STATE_C;
                } else {
                    System.out.println("State B: Unknown event.");
                }
                break;
            case STATE_C:
                if (event == Event.C) {
                    System.out.println("State C: Event C handled.");
                    this.currentState = State.STATE_A;
                } else {
                    System.out.println("State C: Unknown event.");
                }
                break;
        }
    }
}
