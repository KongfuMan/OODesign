package TicTacToe;

import TicTacToe.Exceptions.DrawGameException;
import TicTacToe.Exceptions.OutOfBoundException;
import TicTacToe.Exceptions.PlayerWinException;
import TicTacToe.Exceptions.GridOccupiedException;

public class TicTacToe {
    private Board board;
    private char currPlayer;


    public TicTacToe(){
        board = new Board(3);
        currPlayer ='X';
    }

    public void makeMove(int r, int c) throws PlayerWinException,
            GridOccupiedException, DrawGameException, OutOfBoundException {
        board.makeMove(r,c,currPlayer);
        switchPlayer();
    }

    public void switchPlayer(){
        currPlayer = currPlayer == 'X' ? 'O' : 'X';
    }
}
