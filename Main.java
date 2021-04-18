package tictactoe;

import java.util.Scanner;

public class Main {
    static String cells;
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter cells: ");
        cells = scan.nextLine();
        print();
        checkWin();

    }
    public static void print(){
        System.out.println("---------");
        int count = 0;
        for(int i = 0; i <9; i++){
            if(count == 0){
                System.out.print("| ");
            }
            System.out.print(cells.charAt(i) + " ");
            count++;
            if(count == 3){
                count = 0;
                System.out.print("|\n");
            }
        }
        System.out.println("---------");
    }
    static boolean rows(char select){
        String baseline = select == 'X'? "XXX":"OOO";
        for(int i =0; i < cells.length()-3; i+=3){
            if(cells.substring(i,i+3).equals(baseline)){
                return true;
            }
        }
        return false;
    }
    public static boolean column(char select){
        for(int i = 0; i < 3; i++){
            if(cells.charAt(i) == select && cells.charAt(i+3) == select && cells.charAt(i+6) == select){
                return true;
            }
        }
        return false;
    }
    public static boolean diagonals(char select){
        if(cells.charAt(0) == select && cells.charAt(4) == select &&cells.charAt(8) == select ){
            return true;
        }
        if(cells.charAt(2) == select && cells.charAt(4) == select &&cells.charAt(6) == select ){
            return true;
        }
        return false;
    }
    public static boolean draw(){
        return !rows('x') &&
                !rows('O') &&
                !column('X') &&
                !column('O') &&
                !diagonals('X') &&
                !diagonals('O') && countTot() == 9;
    }
    public static boolean notFinished(){
        return !rows('X') &&
                !rows('O') &&
                !column('X') &&
                !column('O') &&
                !diagonals('X') &&
                !diagonals('O') && countTot() < 9;
    }
    public static int countTot(){
        int result = 0;
        for(int i = 0; i < cells.length(); i++){
            if(cells.charAt(i) == 'X' || cells.charAt(i) == 'O'){
                result++;
            }
        }
        return result;
    }
    public static boolean countXnO(){
        int nX = 0;
        int nO = 0;
        for(int i = 0; i < 9; i++){
            if(cells.charAt(i) == 'X'){
                nX++;
            }
            if(cells.charAt(i) == 'O'){
                nO++;
            }
        }
        return Math.abs(nX-nO) > 1;
    }
    public static boolean impossible(){
        if( (rows('X') || diagonals('X') || column('X'))
                && (rows('O') || diagonals('O') || column('O'))){
            return true;
        }
        if(countXnO()){
            return true;
        }
        return false;
    }

    public static void checkWin(){
        if(impossible()){
            System.out.println("Impossible");
            return;
        }
        if(draw()){
            System.out.println("Draw");
            return;
        }
        if(notFinished()){
            System.out.println("Game not finished");
            return;
        }
        if(rows('X') || diagonals('X') || column('X')){
            System.out.println("X wins");
            return;
        };
        if(rows('O') || diagonals('O') || column('O')){
            System.out.println("O wins");
            return;
        }
    }
}
