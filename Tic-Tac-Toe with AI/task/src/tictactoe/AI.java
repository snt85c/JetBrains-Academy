package tictactoe;

import java.util.Random;

public class AI {
    Random rand = new Random();

    public String[][] easy(String[][] board, String sign){
        while(true){
            int first = rand.nextInt(3);
            int second = rand.nextInt(3);
            if(board[first][second].equals(" ")){
                board[first][second] = sign;
                Main.showBoard();
                Main.checkWinCondition();
                return board;
            }
        }
    }
    public String[][] medium (String[][] board, String sign){
        while(true){
            if(oneMoveRow(board, sign)){
                break;
            } else if(oneMoveColumn(board, sign)){
                break;
            } else {
                easy(board, sign);
                break;
            }
        }
        return board;
    }
    public boolean oneMoveRow(String[][] board, String sign){
        int first = -1;
        int second = -1;
        for(int i = 0; i < 3; i++){
            int counter = 0;
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(sign)){
                    counter++;
                }
                else if(board[i][j].equals(" ")){
                    first = i;
                    second = j;
                }
                if(counter == 2){
                    board[first][second] = sign;
                    Main.showBoard();
                    Main.checkWinCondition();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean oneMoveColumn(String[][] board, String sign)
    {
        int first = -1;
        int second = -1;
        for(int i = 0; i < 3; i++){
            int counter = 0;
            for(int j = 0; j < 3; j++){
                if(board[j][i].equals(sign)){
                    counter++;
                }
                else if(board[j][i].equals(" ")){
                    first = j;
                    second = i;
                }
                if(counter == 2){
                    board[first][second] = sign;
                    Main.showBoard();
                    Main.checkWinCondition();
                    return true;
                }
            }
        }
        return false;
    }

    public void oneMoveDiagonal(String[][] board, String sign){

    }
}
