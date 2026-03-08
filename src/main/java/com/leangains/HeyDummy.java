package com.leangains;

/** Utility class that prints a single greeting message 'Hey Dummy' */
public final class HeyDummy {

    private HeyDummy() {}

    public static void main(String[] args) {
        printMessage();
    }

    public static String getMessage() {
        return "Hey Dummy";
    }

    public static void printMessage() {
        System.out.println(getMessage());
    }
}