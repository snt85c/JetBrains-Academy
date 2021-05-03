package tictactoe;

import java.util.Random;

public class AI {
    Random rand = new Random();

    public String[][] moveEasy(String[][] board, String sign){
        System.out.println("Making move level \"easy\"");
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
}
