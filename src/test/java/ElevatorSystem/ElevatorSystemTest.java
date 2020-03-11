package ElevatorSystem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static ElevatorSystem.Direction.UP;
import static org.junit.jupiter.api.Assertions.*;

class ElevatorSystemTest {
    private ElevatorSystem elevatorSystem;


    @BeforeAll
    public void setup(){
        // total 10 levels
        elevatorSystem = new ElevatorSystem(10);
    }

    @Test
    public void testElevatorSystemConstructor(){
        ExternalRequest req = new ExternalRequest(5, UP);
        elevatorSystem.handleExternalRequest(req);
        elevatorSystem.
    }
}