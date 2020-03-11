package ElevatorSystem;

public class InternalRequest {
    private int destination;
    public InternalRequest(int destination){
        this.destination = destination;
    }

    public int getDestinationLevel() {
        return destination;
    }
}
