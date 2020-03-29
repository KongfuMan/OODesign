package TrafficLightSystem;

public class GreenState implements IState {
    private TrafficLightSystem system;

    public GreenState(TrafficLightSystem system) {
        this.system = system;
    }

    @Override
    public void transit() {
        this.system.setYellow();
    }

    @Override
    public void vehicleEnter(Vehicle v) {

    }
}
