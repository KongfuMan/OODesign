package ElevatorSystem;

public abstract class Request {
    protected int level;

    public Request(int level){
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
