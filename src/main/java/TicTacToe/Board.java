package TicTacToe;

import TicTacToe.Exceptions.DrawGameException;
import TicTacToe.Exceptions.OutOfBoundException;
import TicTacToe.Exceptions.PlayerWinException;
import TicTacToe.Exceptions.GridOccupiedException;

public class Board {
    private char[][] board;

    public Board(int n){
        if (n < 3){
            throw new IllegalArgumentException();
        }
        resetBoard();
    }

    private void resetBoard(){
        int n = board.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = '-';
            }
        }
    }

    public void makeMove(int r, int c, char player) throws OutOfBoundException,
            GridOccupiedException, PlayerWinException, DrawGameException{
        if (r < 0 || r >= board.length ||  c < 0 || c >= board.length){
            throw new OutOfBoundException();
        }
        if (board[r][c] != '-'){
            throw new GridOccupiedException();
        }
        board[r][c] = player;
        if (checkWin(r,c,player)){
            throw new PlayerWinException();
        }
        if (checkFull()){
            throw new DrawGameException();
        }
    }

    // 1275. Find Winner on a Tic Tac Toe Game
    private boolean checkWin(int r, int c, char player){
        int n = board.length;
        boolean win = true;
        for (int i = 0; i < n; i++){
            if (board[r][i] != player){
                win = false;
            }
        }
        if (win){
            return true;
        }
        for (int i = 0; i < n; i++){
            if (board[i][c] != player){
                win = false;
            }
        }
        if (win){
            return true;
        }
        if (r == c){
            for (int i = 0; i < n; i++){
                if (board[i][i] != player){
                    win = false;
                }
            }
        }
        if (win){
            return true;
        }
        if (r + c == n - 1){
            for (int i = 0; i < n; i++){
                if (board[i][n-i-1] != player){
                    win = false;
                }
            }
        }
        return win;
    }

    private boolean checkFull(){
        int n = board.length;
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == '-'){
                    return false;
                }
            }
        }
        return true;
    }
}
