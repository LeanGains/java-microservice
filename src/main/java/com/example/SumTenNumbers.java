ackage com.example;

import java.util.Scanner;

public class SumTenNumbers {
    public static void main(String[] args) {
        double sum = 0;
        if (args.length == 10) {
            try {
                for (int i = 0; i < 10; i++) {
                    sum += Double.parseDouble(args[i]);
                }
                System.out.println("Sum: " + sum);
                return;
            } catch (NumberFormatException e) {
                System.err.println("One of the command-line arguments is not a valid number.");
                System.exit(1);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 10 numbers (press Enter after each):");
        int count = 0;
        while (count < 10) {
            System.out.print("Number " + (count + 1) + ": ");
            if (!scanner.hasNext()) {
                System.err.println("No more input. Exiting.");
                System.exit(1);
            }
            String token = scanner.next();
            try {
                double v = Double.parseDouble(token);
                sum += v;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
        System.out.println("Sum: " + sum);
        scanner.close();
    }
}