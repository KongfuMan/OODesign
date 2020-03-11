package ElevatorSystem;

public class ExternalRequest extends Request {
    private Direction dir;

    public ExternalRequest(int level, Direction dir){
        super(level);
        this.dir = dir;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
