import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        String first = digits.substring(0,3);
        String second = digits.substring(3);
        if(Character.valueOf(first.charAt(0)) + Character.valueOf(first.charAt(1)) + Character.valueOf(first.charAt(2)) ==
                Character.valueOf(second.charAt(0)) + Character.valueOf(second.charAt(1)) + Character.valueOf(second.charAt(2)) ){
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}