package ElevatorSystem;

public class ExternalRequest {
    private Direction dir;
    private int currLevel;

    public ExternalRequest(int currLevel, Direction dir){
        this.dir = dir;
        this.currLevel = currLevel;
    }

    public Direction getDir() {
        return dir;
    }

    public int getCurrenLevel() {
        return currLevel;
    }
}
