package com.example;

public class ProductCalculator {

    public double calculateProduct(double num1, double num2, double num3, double num4) {
        return num1 * num2 * num3 * num4;
    }

    public static void main(String[] args) {
        ProductCalculator calculator = new ProductCalculator();
        double result = calculator.calculateProduct(2.0, 3.0, 4.0, 5.0);
        System.out.println("The product is: " + result); // Expected output: 120.0
    }
}