package ElevatorSystem;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorSystemTest {
    private ElevatorSystem elevatorSystem;


    @BeforeAll
    public void setup(){
        // total 10 levels
        elevatorSystem = new ElevatorSystem(10);
    }
}