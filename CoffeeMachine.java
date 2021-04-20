package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InternalOps Internal = new InternalOps(400, 540, 120, 550, 9);
        while(true){
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String selection = scan.nextLine();
            switch (selection) {
                case "buy":
                    buy(Internal, scan);
                    break;
                case "fill":
                    fill(Internal, scan);
                    break;
                case "take":
                    take(Internal, scan);
                    break;
                case "remaining":
                    remaining(Internal, scan);
                    break;
                case "exit":
                    return;
            }
        }
    }
    public static void buy(InternalOps Internal, Scanner scan){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                "back - to main menu");
        String selection = scan.nextLine();
        switch(selection){
            case "1":
                Internal.request(250, 0, 16, 4, "Espresso");
                break;
            case "2":
                Internal.request(350, 75, 20, 7, "Latte");
                break;
            case "3":
                Internal.request(200, 100, 12, 6, "Cappuccino");
                break;
            case "back":
                return;
        }
    }
    public static void fill(InternalOps Internal, Scanner scan){
        System.out.println("Write how many ml of water do you want to add: ");
        int water = scan.nextInt();
        Internal.setWater(water);
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scan.nextInt();
        Internal.setMilk(milk);
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int coffeeBeans = scan.nextInt();
        Internal.setCoffeeBeans(coffeeBeans);
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scan.nextInt();
        Internal.setCups(cups);
    }
    public static void take(InternalOps Internal, Scanner scan){
        Internal.takeMoney();
    }
    public static void remaining(InternalOps Internal, Scanner scan){
        Internal.statusReport();
    }
}

class InternalOps{
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public InternalOps(int water, int milk, int coffeeBeans, int coins, int cups){
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.money = coins;
        this.cups = cups;
    }

    public void setWater(int water) {
        this.water += water;
    }
    public void setMilk(int milk) {
        this.milk += milk;
    }
    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }
    public void setCups(int cups) {
        this.cups += cups;
    }
    public void setMoney(int money) {
        this.money += money;
    }
    public void takeMoney(){
        System.out.printf("I gave you $%d\n\n", this.money);
        this.money = 0;
    }
    public void statusReport(){
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money\n");
    }
    public void request(int water, int milk, int coffeeBeans, int money, String selection){
        if(this.water < water){
            System.out.println("Sorry, not enough water");
        } else if (this.coffeeBeans < coffeeBeans){
            System.out.println("Sorry, not enough coffee beans");
        } else if(this.milk < milk){
            System.out.println("Sorry, not enough milk");
        } else if(this.cups == 0){
            System.out.println("Sorry, not enough cups");
        } else {
            System.out.println("I have enough resources, making you a " + selection);
            this.water -= water;
            this.milk -= milk;
            this.coffeeBeans -= coffeeBeans;
            this.cups--;
            setMoney(money);
        }

    }
}
