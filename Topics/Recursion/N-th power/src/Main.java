import java.util.Scanner;

public class Main {

    public static double pow(double a, long n) {
        // write your code here
        if (n == 0){
            return 1;
        }
        return n % 2 == 0? pow(Math.pow(a, 2), n / 2) : a * pow(a, n - 1);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = Double.parseDouble(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(a, n));
    }
}