package ElevatorSystem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ElevatorSystem.Direction.UP;

class ElevatorSystemTest {
    private static ElevatorSystem elevatorSystem;
    private static List<Elevator> elevators;


    @BeforeAll
    public static void setup() {
        // total 10 levels
        elevators = new ArrayList<>();
        elevators.add(new Elevator(10, 1));
        elevatorSystem = new ElevatorSystem(elevators);
    }

    @Test
    public void testElevatorSystemConstructor() {
        ExternalRequest req = new ExternalRequest(5, UP);
        elevatorSystem.handleExternalRequest(req);
    }
}