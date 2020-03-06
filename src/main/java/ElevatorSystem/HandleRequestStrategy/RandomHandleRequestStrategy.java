package ElevatorSystem.HandleRequestStrategy;

import ElevatorSystem.Elevator;
import ElevatorSystem.ExternalRequest;

import java.util.List;

public class RandomHandleRequestStrategy implements HandleRequestStrategy {
    @Override
    public void handleRequest(ExternalRequest req, List<Elevator> elevators) {

        // select an elevator
        Elevator elevator = elevators.get(0);

        elevator.handleExternalRequest(req);
    }
}
