package TicTacToe;

import TicTacToe.Exceptions.DrawGameException;
import TicTacToe.Exceptions.OutOfBoundException;
import TicTacToe.Exceptions.PlayerWinException;
import TicTacToe.Exceptions.GridOccupiedException;

public class Board {
    private char[][] mat;

    public Board(int n){
        if (n < 3){
            throw new IllegalArgumentException();
        }
        resetBoard();
    }

    public void makeMove(int r, int c, char player) throws OutOfBoundException,
            GridOccupiedException, PlayerWinException, DrawGameException{
        if (r < 0 || r >= mat.length ||  c < 0 || c >= mat.length){
            throw new OutOfBoundException();
        }
        if (mat[r][c] != '-'){
            throw new GridOccupiedException();
        }
        mat[r][c] = player;
        if (checkWin(r,c,player)){
            throw new PlayerWinException();
        }
        if (checkFull()){
            throw new DrawGameException();
        }
    }

    // 1275. Find Winner on a Tic Tac Toe Game
    private boolean checkWin(int r, int c, char player){
        int n = mat.length;
        boolean win = true;
        for (int i = 0; i < n; i++){
            if (mat[r][i] != player){
                win = false;
            }
        }
        if (win){
            return true;
        }
        for (int i = 0; i < n; i++){
            if (mat[i][c] != player){
                win = false;
            }
        }
        if (win){
            return true;
        }
        if (r == c){
            for (int i = 0; i < n; i++){
                if (mat[i][i] != player){
                    win = false;
                }
            }
        }
        if (win){
            return true;
        }
        if (r + c == n - 1){
            for (int i = 0; i < n; i++){
                if (mat[i][n-i-1] != player){
                    win = false;
                }
            }
        }
        return win;
    }

    private boolean checkFull(){
        int n = mat.length;
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (mat[r][c] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard(){
        int n = mat.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = '-';
            }
        }
    }
}
