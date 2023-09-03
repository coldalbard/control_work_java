package view;

import model.Toy;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class View {
    private static final Scanner sc = new Scanner(System.in);

    public static int mainPage() {
        System.out.println();
        System.out.println("1. Drawing of a toy");
        System.out.println("2. Show my toys");
        System.out.println("3. Add a toy");
        System.out.println("4. Change the weight of the toy");
        System.out.println("5. Exit");
        System.out.printf("Select an action: ");
        return sc.nextInt();
    }

    public static void Drawing() {
        System.out.println("The drawing has been launched");
        try {
            System.out.println("Loading...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Loading...");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            ;
        }
    }

    public static void showToys() {
        System.out.println("Your toys:\n");
    }

    public static Toy addToy() {
        System.out.printf("Enter the toy id: ");
        int id = sc.nextInt();
        System.out.printf("Enter the name of the toy: ");
        String name = sc.next();
        System.out.printf("Enter the number of toys: ");
        int numbersToys = sc.nextInt();
        System.out.printf("Enter the weight of the toy:");
        double weight = sc.nextDouble();
        return new Toy(id, name, numbersToys, weight);
    }

    public static Number[] weightChange() {
        Number[] idAndWeight = new Number[2];
        System.out.printf("Enter the toy id: ");
        int id = sc.nextInt();
        System.out.printf("Enter a new weight: ");
        double weight = sc.nextDouble();
        idAndWeight[0] = id;
        idAndWeight[1] = weight;
        return idAndWeight;
    }
}
