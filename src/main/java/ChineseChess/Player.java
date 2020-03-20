package ChineseChess;

public class Player {
    private Color color;
    private int points;

    public Player(int points) {
        this.points = points;
    }

    public void updatePoints(int diff) {
        points += diff;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color  getColor(){
        return color;
    }
}
