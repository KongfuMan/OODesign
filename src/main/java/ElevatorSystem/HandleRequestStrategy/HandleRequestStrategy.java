package ElevatorSystem.HandleRequestStrategy;

import ElevatorSystem.Elevator;
import ElevatorSystem.ExternalRequest;

import java.util.List;

public interface HandleRequestStrategy {
    Elevator handleRequest(ExternalRequest req, List<Elevator> elevators);
}
