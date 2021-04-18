package tictactoe;

import java.util.Scanner;

public class Main {
    static String cell;
    static char[][]cells;
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter cells: ");
        cell = scan.nextLine();
        convertStringToArray();
        printArray();
        playerMove(scan);
        printArray();

    }
    public static void convertStringToArray(){
        char[][]workCells = new char[3][3];
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                workCells[i][j] = cell.charAt(count);
                count++;
            }
        }
        cells = workCells;
    }
    public static boolean assignCoordinates(int row, int column){
        try{
            if((row < 1 || row > 3) || (column < 1 || column > 3)){
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
            else if(cells[row-1][column-1] == 'X' || cells[row-1][column-1] == 'O' ){
                System.out.println("This cell is occupied! Choose another one");
                return false;
            } else {
                cells[row-1][column-1] = 'X';
                return true;
            }
        } catch(Exception e){
            System.out.println("You should enter numbers!");
        }
        return false;
    }
    public static void printArray(){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static void playerMove(Scanner scan){
        while(true){
            System.out.println("Enter the coordinates: ");
            String coordinates = scan.nextLine().trim();
            int row = Integer.parseInt(coordinates.charAt(0) + "");
            int column =Integer.parseInt(coordinates.charAt(2) + "");
            if(assignCoordinates(row,column)){
                return;
            }
        }
    }
    @Deprecated
    public static void print(){
        System.out.println("---------");
        int count = 0;
        for(int i = 0; i <9; i++){
            if(count == 0){
                System.out.print("| ");
            }
            System.out.print(cell.charAt(i) + " ");
            count++;
            if(count == 3){
                count = 0;
                System.out.print("|\n");
            }
        }
        System.out.println("---------");
    }
    public static void checkWin(){
        if(checkImpossible()){
            System.out.println("Impossible");
            return;
        }
        if(checkDraw()){
            System.out.println("Draw");
            return;
        }
        if(checkNotFinished()){
            System.out.println("Game not finished");
            return;
        }
        if(checkRows('X') || checkDiagonals('X') || checkColumn('X')){
            System.out.println("X wins");
            return;
        };
        if(checkRows('O') || checkDiagonals('O') || checkColumn('O')){
            System.out.println("O wins");
            return;
        }
    }
    public static boolean checkRows(char select){
        String baseline = select == 'X'? "XXX":"OOO";
        for(int i = 0; i < cell.length()-3; i+=3){
            if(cell.substring(i,i+3).equals(baseline)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkColumn(char select){
        for(int i = 0; i < 3; i++){
            if(cell.charAt(i) == select && cell.charAt(i+3) == select && cell.charAt(i+6) == select){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonals(char select){
        if(cell.charAt(0) == select && cell.charAt(4) == select && cell.charAt(8) == select ){
            return true;
        }
        if(cell.charAt(2) == select && cell.charAt(4) == select && cell.charAt(6) == select ){
            return true;
        }
        return false;
    }
    public static boolean checkDraw(){
        return !checkRows('x') &&
                !checkRows('O') &&
                !checkColumn('X') &&
                !checkColumn('O') &&
                !checkDiagonals('X') &&
                !checkDiagonals('O') && countTot() == 9;
    }
    public static boolean checkNotFinished(){
        return !checkRows('X') &&
                !checkRows('O') &&
                !checkColumn('X') &&
                !checkColumn('O') &&
                !checkDiagonals('X') &&
                !checkDiagonals('O') && countTot() < 9;
    }
    public static boolean checkImpossible(){
        if( (checkRows('X') || checkDiagonals('X') || checkColumn('X'))
                && (checkRows('O') || checkDiagonals('O') || checkColumn('O'))){
            return true;
        }
        if(countXnO()){
            return true;
        }
        return false;
    }
    public static int countTot(){
        int result = 0;
        for(int i = 0; i < cell.length(); i++){
            if(cell.charAt(i) == 'X' || cell.charAt(i) == 'O'){
                result++;
            }
        }
        return result;
    }
    public static boolean countXnO(){
        int nX = 0;
        int nO = 0;
        for(int i = 0; i < 9; i++){
            if(cell.charAt(i) == 'X'){
                nX++;
            }
            if(cell.charAt(i) == 'O'){
                nO++;
            }
        }
        return Math.abs(nX-nO) > 1;
    }

}
