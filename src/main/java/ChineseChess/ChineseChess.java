package ChineseChess;

import ChineseChess.Exception.GameFullException;

import java.util.ArrayList;
import java.util.List;

public class ChineseChess {
    List<Game> games;

    private static ChineseChess instance;

    public static synchronized ChineseChess getInstance(){
        if (instance == null){
            instance = new ChineseChess();
        }
        return instance;
    }

    public ChineseChess(){
        games = new ArrayList<>();
    }

    /**
     * initialize the game for two player
     *
     *
     * */
    public void initialize(){
        Game game = new Game();
    }

    public void joinPlayer(Player player, Game game) throws GameFullException {
        game.joinPlayer(player);
    }
}
