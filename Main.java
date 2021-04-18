package tictactoe;

import java.util.Scanner;

public class Main {
    static String cell;
    static char[][]cells;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // write your code here
        /*System.out.print("Enter cells: ");
        cell = scan.nextLine();
        convertStringToArray();*/
        populate();
        gameStages(scan);

    }
    public static void populate(){
        char[][] workCells = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                workCells[i][j] = ' ';
            }
        }
        cells = workCells;
        printArray();
    }
    public static void gameStages(Scanner scan){
        int count = 1;
        while(true){
            char selection = count % 2 == 0? 'O' : 'X';
            playerMove(scan, selection);
            count++;
            printArray();
            if(checkWin()){
                return;
            }
        }
    }
    public static boolean assignCoordinates(int row, int column, char selection){
        try{
            if((row < 1 || row > 3) || (column < 1 || column > 3)){
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
            else if(cells[row-1][column-1] == 'X' || cells[row-1][column-1] == 'O' ){
                System.out.println("This cell is occupied! Choose another one");
                return false;
            } else {
                cells[row-1][column-1] = selection; //should allow selection
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
    public static void playerMove(Scanner scan, char selection){
        while(true){
            System.out.println("Enter the coordinates: ");
            String coordinates = scan.nextLine().trim();
            int row = Integer.parseInt(coordinates.charAt(0) + "");
            int column =Integer.parseInt(coordinates.charAt(2) + "");
            if(assignCoordinates(row,column,selection)){
                return;
            }
        }
    }
    public static boolean checkWin(){
        if(checkRows('X') || checkDiagonals('X') || checkColumn('X')){
            System.out.println("X wins");
            return true;
        };
        if(checkRows('O') || checkDiagonals('O') || checkColumn('O')){
            System.out.println("O wins");
            return true;
        }
        if(checkDraw()){
            System.out.println("Draw");
            return true;
        }/*
        if(checkNotFinished()){
            System.out.println("Game not finished");
            return true;
        }
        if(checkImpossible()){
            System.out.println("Impossible");
            return true;
        }*/
        return false;
    }
    public static boolean checkRows(char select){
        for(int i = 0; i < 3; i+=3){
            if(cells[0][i] == select && cells[1][i] == select && cells[2][i] == select ){
                return true;
            }
        }
        return false;
    }
    public static boolean checkColumn(char select){
        for(int i = 0; i < 3; i++){
            if(cells[i][0] == select && cells[i][1] == select && cells[i][2] == select){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonals(char select){
        if(cells[0][0] == select && cells[1][1] == select && cells[2][2] == select ){
            return true;
        }
        if(cells[0][2] == select && cells[1][1] == select && cells[2][0] == select ){
            return true;
        }
        return false;
    }
    public static boolean checkDraw(){
        return !checkRows('X') &&
                !checkRows('O') &&
                !checkColumn('X') &&
                !checkColumn('O') &&
                !checkDiagonals('X') &&
                !checkDiagonals('O') && countTot() == 9;
    }
    public static int countTot(){
        int result = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++ ){
                if(cells[i][j] == 'X' || cells[i][j] == 'O'){
                    result++;
                }
            }
        }
        return result;
    }
    public static boolean countXnO(){
        int nX = 0;
        int nO = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(cells[i][j] == 'X'){
                    nX++;
                }
                if(cells[i][j] == 'O'){
                    nO++;
                }
            }
        }
        return Math.abs(nX-nO) > 1;
    }


    @Deprecated
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
    @Deprecated
    public static boolean checkNotFinished(){
        return !checkRows('X') &&
                !checkRows('O') &&
                !checkColumn('X') &&
                !checkColumn('O') &&
                !checkDiagonals('X') &&
                !checkDiagonals('O') && countTot() < 9;
    }
    @Deprecated
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
}
