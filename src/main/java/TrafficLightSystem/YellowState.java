package TrafficLightSystem;

public class YellowState implements IState {
    private TrafficLightSystem system;

    public YellowState(TrafficLightSystem system) {
        this.system = system;
    }

    @Override
    public void transit() {
        this.system.setRed();
    }

    @Override
    public void vehicleEnter(Vehicle v){

    }
}
