package com.example;

public class ProductCalculator {

    public static int calculateProduct(int num1, int num2, int num3, int num4) {
        return num1 * num2 * num3 * num4;
    }

    public static void main(String[] args) {
        int result = calculateProduct(2, 3, 4, 5);
        System.out.println("The product of 2, 3, 4, and 5 is: " + result);
    }
}