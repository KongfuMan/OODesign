package TrafficLightSystem;

import TrafficLightSystem.Exceptions.EnterUnderRedLigthException;

public class RedState implements IState{
    private TrafficLightSystem system;

    public RedState(TrafficLightSystem system) {
        this.system = system;
    }

    @Override
    public void transit() {
        this.system.setGreen();
    }

    @Override
    public void vehicleEnter(Vehicle v) throws EnterUnderRedLigthException {
        throw new EnterUnderRedLigthException();
    }
}
