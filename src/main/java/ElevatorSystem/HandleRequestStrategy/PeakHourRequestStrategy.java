package ElevatorSystem.HandleRequestStrategy;

import ElevatorSystem.Elevator;
import ElevatorSystem.ExternalRequest;

import java.util.List;

public class PeakHourRequestStrategy implements HandleRequestStrategy {
    @Override
    public Elevator handleRequest(ExternalRequest req, List<Elevator> elevators) {
        return elevators.get(0);
    }
}
