package TrafficLightSystem;

import TrafficLightSystem.Exceptions.EnterUnderRedLigthException;

public interface IState {
    void transit();

    void vehicleEnter(Vehicle v) throws EnterUnderRedLigthException;
}
