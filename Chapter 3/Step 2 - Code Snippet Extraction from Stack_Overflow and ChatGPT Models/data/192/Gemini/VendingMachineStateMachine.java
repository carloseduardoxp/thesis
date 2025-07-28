import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

// Enum to represent the different states of our machine
enum VendingMachineState {
    IDLE,
    HAS_COIN,
    DISPENSING,
    OUT_OF_STOCK
}

// Enum to represent the events that can trigger state transitions
enum VendingMachineEvent {
    INSERT_COIN,
    SELECT_PRODUCT,
    DISPENSE_COMPLETE,
    PRODUCT_UNAVAILABLE
}

// Represents a transition from one state to another based on an event
class StateTransition {
    public final VendingMachineState fromState;
    public final VendingMachineEvent event;
    public final VendingMachineState toState;
    public final Consumer<String> action; // Optional action to perform during transition

    public StateTransition(VendingMachineState fromState, VendingMachineEvent event, VendingMachineState toState) {
        this(fromState, event, toState, null); // No action by default
    }

    public StateTransition(VendingMachineState fromState, VendingMachineEvent event, VendingMachineState toState, Consumer<String> action) {
        this.fromState = fromState;
        this.event = event;
        this.toState = toState;
        this.action = action;
    }
}

// The core State Machine class
public class VendingMachineStateMachine {
    private VendingMachineState currentState;
    // A map to define all possible transitions: (fromState, event) -> toState
    private Map<VendingMachineState, Map<VendingMachineEvent, StateTransition>> transitions;

    public VendingMachineStateMachine() {
        this.currentState = VendingMachineState.IDLE;
        this.transitions = new HashMap<>();
        initializeTransitions();
    }

    // Get the current state of the machine
    public VendingMachineState getCurrentState() {
        return currentState;
    }

    // Initialize all possible state transitions
    private void initializeTransitions() {
        // IDLE state transitions
        addTransition(new StateTransition(
            VendingMachineState.IDLE,
            VendingMachineEvent.INSERT_COIN,
            VendingMachineState.HAS_COIN,
            msg -> System.out.println("Coin inserted. Machine now has coin.")
        ));

        // HAS_COIN state transitions
        addTransition(new StateTransition(
            VendingMachineState.HAS_COIN,
            VendingMachineEvent.SELECT_PRODUCT,
            VendingMachineState.DISPENSING,
            msg -> System.out.println("Product selected. Dispensing...")
        ));
        addTransition(new StateTransition(
            VendingMachineState.HAS_COIN,
            VendingMachineEvent.PRODUCT_UNAVAILABLE,
            VendingMachineState.IDLE, // Return to IDLE if product is unavailable
            msg -> System.out.println("Product unavailable. Returning to IDLE.")
        ));

        // DISPENSING state transitions
        addTransition(new StateTransition(
            VendingMachineState.DISPENSING,
            VendingMachineEvent.DISPENSE_COMPLETE,
            VendingMachineState.IDLE,
            msg -> System.out.println("Dispensing complete. Returning to IDLE.")
        ));

        // OUT_OF_STOCK state (no transitions out of this state in this simple example,
        // but you could add a 'RESTOCK' event if needed)
    }

    // Helper method to add a transition to the map
    private void addTransition(StateTransition transition) {
        transitions
            .computeIfAbsent(transition.fromState, k -> new HashMap<>())
            .put(transition.event, transition);
    }

    // Method to process an event and potentially change the state
    public void processEvent(VendingMachineEvent event) {
        // Get the transitions available from the current state
        Map<VendingMachineEvent, StateTransition> currentTransitions = transitions.get(currentState);

        if (currentTransitions != null) {
            // Find the specific transition for the given event
            StateTransition transition = currentTransitions.get(event);

            if (transition != null) {
                // Perform the action associated with the transition (if any)
                if (transition.action != null) {
                    transition.action.accept("Transitioning from " + currentState + " to " + transition.toState);
                }
                // Update the current state
                this.currentState = transition.toState;
                System.out.println("State changed to: " + currentState);
            } else {
                System.out.println("No valid transition from " + currentState + " for event " + event);
            }
        } else {
            System.out.println("No transitions defined for current state: " + currentState);
        }
    }

    public static void main(String[] args) {
        VendingMachineStateMachine vm = new VendingMachineStateMachine();

        System.out.println("Initial State: " + vm.getCurrentState());

        // Simulate user interactions
        vm.processEvent(VendingMachineEvent.INSERT_COIN);
        vm.processEvent(VendingMachineEvent.SELECT_PRODUCT);
        vm.processEvent(VendingMachineEvent.DISPENSE_COMPLETE);

        System.out.println("\n--- Simulating another scenario ---");
        vm.processEvent(VendingMachineEvent.INSERT_COIN);
        vm.processEvent(VendingMachineEvent.PRODUCT_UNAVAILABLE); // Product is out of stock

        System.out.println("\n--- Trying invalid events ---");
        vm.processEvent(VendingMachineEvent.SELECT_PRODUCT); // Invalid in IDLE state
    }
}
