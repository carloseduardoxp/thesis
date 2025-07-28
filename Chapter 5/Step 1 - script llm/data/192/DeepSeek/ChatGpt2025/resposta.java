enum State {
    IDLE {
        @Override
        public State nextState(Event event) {
            return event == Event.START ? RUNNING : IDLE;
        }
    },
    RUNNING {
        @Override
        public State nextState(Event event) {
            if (event == Event.STOP) return IDLE;
            if (event == Event.PAUSE) return PAUSED;
            return RUNNING;
        }
    },
    PAUSED {
        @Override
        public State nextState(Event event) {
            if (event == Event.RESUME) {
                return RUNNING;
            } else if (event == Event.STOP) {
                return IDLE;
            } else {
                return PAUSED;
            }
        }
    };

    public abstract State nextState(Event event);
}

enum Event {
    START, STOP, PAUSE, RESUME
}

public class StateMachine {
    private State currentState = State.IDLE;

    public void processEvent(Event event) {
        currentState = currentState.nextState(event);
        System.out.println("Event: " + event + ", New State: " + currentState);
    }
}
