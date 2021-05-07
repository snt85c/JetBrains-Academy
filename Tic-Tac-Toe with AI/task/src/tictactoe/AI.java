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
                return board;
            }
        }
    }
    public String[][] medium (String[][] board, String sign){
        while(true){
            if(oneMoveRow(board, sign, sign) || oneMoveRow(board, sign.equals("X")?"O":"X", sign )){
                break;
            } else if(oneMoveColumn(board, sign, sign) || oneMoveColumn(board,sign.equals("X")?"O":"X", sign )){
                break;
            } else if(oneMoveDiagonal(board, sign, sign) || oneMoveDiagonal(board,sign.equals("X")?"O":"X", sign )){
                break;
            } else {
                easy(board, sign);
                break;
            }
        }
        return board;
    }
    public boolean oneMoveRow(String[][] board, String sign, String assignment){
        int first = -1;
        int second = -1;
        for(int i = 0; i < 3; i++){
            int counter = 0;
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(sign)){
                    counter++;
                }
                if(board[i][j].equals(" ")){
                    first = i;
                    second = j;
                }
                if(counter == 2 && first != -1){
                    board[first][second] = assignment;
                    Main.showBoard();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean oneMoveColumn(String[][] board, String sign, String assignment)
    {
        int first = -1;
        int second = -1;
        for(int i = 0; i < 3; i++){
            int counter = 0;
            for(int j = 0; j < 3; j++){
                if(board[j][i].equals(sign)){
                    counter++;
                }
                if(board[j][i].equals(" ")){
                    first = j;
                    second = i;
                }
                if(counter == 2 && first != -1){
                    board[first][second] = assignment;
                    Main.showBoard();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean oneMoveDiagonal(String[][] board, String sign, String assignment){
        int first = -1;
        int second = -1;
        int counter = 0;
        for(int i = 0; i < 3; i++){
            if(board[i][i].equals(sign)){
                counter++;
            }
            if(board[i][i].equals(" ")){
                first = i;
                second = i;
            }
            if(counter == 2 && first != -1){
                board[first][second] = assignment;
                Main.showBoard();
                return true;
            }
        }
        first = -1;
        second = -1;
        counter = 0;
        int  d = 2;
        for(int i = 0; i < 3; i++){
            if(board[i][d].equals(sign)){
                counter++;
            }
            if(board[i][d].equals(" ")){
                first = i;
                second = d;
            }
            if(counter == 2 && first != -1){
                board[first][second] = assignment;
                Main.showBoard();
                return true;
            }
            d--;
        }
        return false;
    }
}
