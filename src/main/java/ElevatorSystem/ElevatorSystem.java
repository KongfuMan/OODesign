package ElevatorSystem;

import ElevatorSystem.HandleRequestStrategy.HandleRequestStrategy;
import ElevatorSystem.HandleRequestStrategy.RandomHandleRequestStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private HandleRequestStrategy strategy;

    public ElevatorSystem(List<Elevator> elevators){
        this.elevators = elevators;
//        elevators.add(new Elevator(totalLevel,1));
        strategy = new RandomHandleRequestStrategy();
    }

    public void setStrategy(HandleRequestStrategy strategy){
        this.strategy = strategy;
    }


    // use case 1: Take an external request
    // assign an elevator and sent the request to the elevator
    public void handleExternalRequest(ExternalRequest request){
         Elevator elevator = strategy.handleRequest(request, elevators);
         elevator.handleExternalRequest(request);
    }
}
