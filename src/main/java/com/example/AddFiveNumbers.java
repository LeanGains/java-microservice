ackage com.example;

import java.util.Scanner;

public class AddFiveNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        System.out.println("Enter 5 numbers (one per line):");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Number " + i + ": ");
            while (!sc.hasNextDouble()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            sum += sc.nextDouble();
        }
        System.out.println("Sum of 5 numbers = " + sum);
        sc.close();
    }
}