ackage com.example;

import java.util.Scanner;

public class AddFiveNumbers {

    public static int addFiveNumbers(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    public static int addTenNumbers(int a1, int a2, int a3, int a4, int a5,
                                    int a6, int a7, int a8, int a9, int a10) {
        return a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10;
    }

    public static int addTenNumbers(int[] nums) {
        if (nums == null || nums.length != 10) {
            throw new IllegalArgumentException("Exactly 10 numbers are required.");
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 integers to sum:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println("Sum of 5 numbers: " + addFiveNumbers(a, b, c, d, e));

        System.out.println("Enter 10 integers to sum:");
        int[] ten = new int[10];
        for (int i = 0; i < 10; i++) {
            ten[i] = scanner.nextInt();
        }
        System.out.println("Sum of 10 numbers: " + addTenNumbers(ten));

        scanner.close();
    }
}