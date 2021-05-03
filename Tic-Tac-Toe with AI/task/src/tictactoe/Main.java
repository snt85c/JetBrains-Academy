package tictactoe;

import java.util.Scanner;

public class Main {
    static String cells = "";
    static String[][] board = new String[3][3];


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        userInterface(scanner);
    }

    public static void userInterface (Scanner scanner){
        System.out.println("Enter the cells: ");
        cells =scanner.nextLine();
        generateBoard();
        while(true){
            if(coordinateCheck(scanner)){
                break;
            }
        }
        checkWinCondition();
    }
    public static boolean coordinateCheck(Scanner scanner){
        while(true){
            try{
                String sign = calculateSign();
                System.out.println("Enter the coordinates: ");
                String coordinates = scanner.nextLine();
                coordinates = coordinates.trim();
                coordinates = coordinates.replace(" ", "");
                if(!isInteger(coordinates.charAt(0) + "") || !isInteger(coordinates.charAt(1)+ "")){
                    System.out.println("You should enter numbers!");
                    return false;
                }
                int[]xy = {Integer.parseInt(coordinates.charAt(0)+ "")-1,Integer.parseInt(coordinates.charAt(1)+ "")-1};
                if (xy[0] < 0 || xy[0] > 2 || xy[1] < 0 || xy[1] > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (!board[xy[0]][xy[1]].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[xy[0]][xy[1]] = sign;
                    showBoard();
                    return true;
                }
            }catch(Exception e){
                System.out.println("something went wrong");
            }
        }
    }
    public static String calculateSign(){
        int countX = countSign("X");
        int countO = countSign("O");
        if(countX == countO){
            return "X";
        }
        return "O";
    }

    public static void checkWinCondition(){
        if(checkDIAGONALS("X") || checkROWS("X") || checkCOLUMNS("X")){
            System.out.println("X wins");
            return;
        }
        if(checkDIAGONALS("O") || checkROWS("O") || checkCOLUMNS("O")){
            System.out.println("O wins");
            return;
        }
        if(gameNotFinished("X") || gameNotFinished("O")){
            System.out.println("Game not finished");
            return;
        }
        if(draw("X") || draw("O")){
            System.out.println("Draw");
        }

    }
    public static boolean draw(String sign){
        if(!checkCOLUMNS(sign) && !checkROWS(sign) && !checkDIAGONALS(sign) && emptyCells() == 0){
            return true;
        }
        return false;
    }
    public static boolean gameNotFinished(String sign){
        if(!checkCOLUMNS(sign) && !checkROWS(sign) && !checkDIAGONALS(sign) && emptyCells() > 0){
            return true;
        }
        return false;
    }
    public static int countSign(String sign){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(sign)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int emptyCells(){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(" ")){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean checkROWS(String sign){
        for(int i = 0; i < 3; i++){
            if(board[i][0].equals(sign) && board[i][1].equals(sign) && board[i][2].equals(sign)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkCOLUMNS(String sign){
        for(int i = 0; i < 3; i++){
            if(board[0][i].equals(sign) && board[1][i].equals(sign) && board[2][i].equals(sign)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDIAGONALS(String sign){
        if(board[0][0].equals(sign) && board[1][1].equals(sign) && board[2][2].equals(sign)){
            return true;
        }
        if(board[0][2].equals(sign) && board[1][1].equals(sign) && board[2][0].equals(sign)){
            return true;
        }
        return false;
    }
    public static void generateBoard(){
        int counter = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = String.valueOf(cells.charAt(counter));
                if(board[i][j].equals("_")){
                    board[i][j] = " ";
                }
                counter++;
            }
        }
        showBoard();
    }
    public static void showBoard(){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static boolean isInteger(String num){
        try{
            Integer.parseInt(num);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

