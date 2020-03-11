package ElevatorSystem.HandleRequestStrategy;

import ElevatorSystem.Elevator;
import ElevatorSystem.ExternalRequest;

import java.util.List;
import java.util.Random;

public class RandomHandleRequestStrategy implements HandleRequestStrategy {
    @Override
    public Elevator handleRequest(ExternalRequest req, List<Elevator> elevators) {
        // randomly select an elevator
        Random rand = new Random();
        int idx = rand.nextInt(elevators.size());
        return elevators.get(idx);
    }
}
