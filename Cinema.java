package cinema;
import java.util.Scanner;

public class Cinema {

    public static String [][] cinema;

    public static int tickets = 0;
    public static int currentIncome = 0;

    public static void main(String[] args) {
        // Write your code here
        menu();
    }
    public static int totalIncome(int rows, int seats){
        int totalIncome = 0;
        if(seats * rows <= 60 ){
            totalIncome = (seats * rows) * 10;
        } else {
            for(int i = 0; i < rows; i ++){
                for(int ii = 0; ii < seats; ii++){
                    if(i < rows / 2){
                        totalIncome += 10;
                    } else{
                        totalIncome += 8;
                    }
                }
            }
        }
        return totalIncome;
    }
    public static int pricing(String[][] cinema, int seats, int rows, int selectionR){

        if((rows * seats) <= 60 || selectionR-1 < (rows/2)){
            return 10;
        }
        return 8;
    }
    static String[][] populate(int rows, int seatsByRow){
        String[][] cinema = new String[rows][seatsByRow];
        for(int i = 0; i < rows; i++){
            for(int ii = 0; ii < seatsByRow; ii++){
                cinema[i][ii] = "S";
            }
        }
        return cinema;
    }
    public static void printCinema(String[][] cinema, int seats, int rows){
        System.out.println("Cinema:");
        System.out.print(" ");
        for(int i = 0; i <= seats; i++){
            if(i > 0) System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++){
            System.out.print((i+1) + " ");
            for (int j = 0; j < seats; j++){
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public static void selectAndPricing(String[][] cinema, int seats, int rows){
        Scanner scan = new Scanner(System.in);
        int selectionR;
        int selectionS;
        while(true) {
            System.out.println("\nEnter a row number: ");
            selectionR = scan.nextInt();
            System.out.println("Enter a seat number in that row: ");
            selectionS = scan.nextInt();
            if(selectionR < 0 || selectionR > rows || selectionS < 0 || selectionS > seats){
                System.out.println("Wrong input!");
            }
            else if (cinema[selectionR-1][selectionS-1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                cinema[selectionR-1][selectionS-1] = "B";
                tickets++;
                currentIncome += pricing(cinema, seats,rows, selectionR);
                System.out.println("Ticket price: $" + pricing(cinema, seats,rows, selectionR));
                printCinema(cinema, seats, rows);
                Cinema.cinema = cinema;
                break;
            }
        }
    }
    static void statistics(int seats, int rows){
        System.out.printf("\nNumber of purchased tickets: %d\n", tickets);
        double percent = ((double)(tickets * 100) / (double)(rows * seats));
        if(tickets == 0){
            System.out.println("Percentage: 0.00%\n");
        } else {
            System.out.printf("Percentage: %.2f%%\n", percent);
        }
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n\n", totalIncome(rows,seats));
    }
    public static void menu (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scan.nextInt();
        cinema = populate(rows, seats);
        while (true){
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n");
            int selection = scan.nextInt();
            switch (selection){
                case 1:
                    printCinema(cinema, seats, rows);
                    break;
                case 2:
                    selectAndPricing(cinema, seats,rows);
                    break;
                case 3:
                    statistics(seats, rows);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}