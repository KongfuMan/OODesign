package ChineseChess;

import ChineseChess.Exception.GameFullException;

public class Game {
    private Player redPlayer;
    private Player blackPlayer;
    private Player currPlayer;
    private Piece[][] board;

    /**Use case1: initialize:
    *  1. Player join game
     * 2. Set up game board
    *
    * */
    public Game() {
        initializeBoard();
    }

    private void initializeBoard(){
        int n = 10;
        board = new Piece[n][n];
    }

    // throw exception if player is null
    // randomly assign this player red or black
    public void joinPlayer(Player player) throws GameFullException {
        if (redPlayer != null && blackPlayer != null){
            throw new GameFullException();
        }
    }

    /** use case 2 player make move
     *
     *
     *
     * */
    public void move(int r, int c, Piece piece){

    }

    private void switchPlayer(){
        if (currPlayer == redPlayer){
            currPlayer = blackPlayer;
            return;
        }
        currPlayer = redPlayer;
    }

    /** Use case 3: win/lose/draw
     *
     **/
    public void checkStatus(){

    }
}
