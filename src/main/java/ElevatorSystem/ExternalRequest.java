package ElevatorSystem;

public class ExternalRequest extends Request {
    private Direction dir;

    public ExternalRequest(int level){
        this.level = level;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
