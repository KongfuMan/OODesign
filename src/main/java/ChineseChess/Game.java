package ChineseChess;

import ChineseChess.Exception.GameFullException;
import ChineseChess.Exception.InvalidMoveException;

import java.util.Random;

public class Game {
    private Player redPlayer;
    private Player blackPlayer;
    private Player currPlayer;
    private Piece[][] board;
    private int steps;

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
        currPlayer = redPlayer;
        steps = 0;
    }

    // throw exception if player is null
    // randomly assign this player red or black
    public void joinPlayer(Player player) throws GameFullException {
        if (player == null){
            throw new NullPointerException();
        }
        if (redPlayer == null){
            redPlayer = player;
        }else if (blackPlayer == null){
            blackPlayer = player;
        }else{
            throw new GameFullException();
        }
    }

    /** use case 2 player make move
     *
     *
     * */
    public void move(int r, int c, Piece piece) throws InvalidMoveException {
        if (validateMove(r,c,piece)){
            throw new InvalidMoveException();
        }

        // make move if valid


        increaseStep();


        // check status

    }

    private void increaseStep(){
        steps++;
    }

    private void switchPlayer(){
        if (currPlayer == redPlayer){
            currPlayer = blackPlayer;
            return;
        }
        currPlayer = redPlayer;
    }

    private boolean validateMove(int r, int c, Piece piece){

        return  true;
    }

    /** Use case 3: win/lose/draw
     *
     **/
    public void checkStatus(){

    }
}
