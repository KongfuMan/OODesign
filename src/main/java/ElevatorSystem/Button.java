package ElevatorSystem;

public class Button {
    private int level;
    private Elevator elevator;

    public Button(int level, Elevator elevator) {
        this.level = level;
        this.elevator = elevator;
    }

    public void pressButton(){
        InternalRequest req = new InternalRequest(level);
        elevator.handleInternalRequest(req);
    }
}
