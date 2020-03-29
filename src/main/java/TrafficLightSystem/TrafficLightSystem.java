package TrafficLightSystem;

import TrafficLightSystem.Exceptions.EnterUnderRedLigthException;

public class TrafficLightSystem {
    private IState currState;
    private IState green;
    private IState red;
    private IState yellow;

    public TrafficLightSystem() {
        green = new GreenState(this);
        red = new RedState(this);
        yellow = new YellowState(this);
    }

    public void setGreen(){
        currState = green;
    }

    public void setRed(){
        currState = red;
    }

    public void setYellow(){
        currState = yellow;
    }

    public void vehicleEnter(Vehicle v) throws EnterUnderRedLigthException {
        this.currState.vehicleEnter(v);
    }
}
