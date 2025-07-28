import java.util.*;

enum StateType {
    WAKE_UP, GET_DRESSED, GET_CAR_KEYS, GET_IN_CAR, DRIVE_TO_WORK, WORK
}

interface State {
    StateType next(StateMachine sm);
}

class GetInCarState implements State {
    @Override
    public StateType next(StateMachine sm) {
        if (sm.hasKeys()) {
            return StateType.DRIVE_TO_WORK;
        }
        return StateType.GET_CAR_KEYS;
    }
}

class StateMachine {
    private Map<StateType, State> states;
    private StateType currentState = StateType.WAKE_UP;
    private boolean hasCarKeys;

    public StateMachine() {
        states = new HashMap<>();
        states.put(StateType.WAKE_UP, new WakeUpState());
        states.put(StateType.GET_DRESSED, new GetDressedState());
        states.put(StateType.GET_CAR_KEYS, new GetCarKeysState());
        states.put(StateType.GET_IN_CAR, new GetInCarState());
        states.put(StateType.DRIVE_TO_WORK, new DriveToWorkState());
        states.put(StateType.WORK, new WorkState());
    }

    public boolean hasKeys() {
        return hasCarKeys;
    }

    public void setHasKeys(boolean hasKeys) {
        hasCarKeys = hasKeys;
    }

    public void update() {
        currentState = states.get(currentState).next(this);
    }
}