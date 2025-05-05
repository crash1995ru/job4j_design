package ru.job4j.calculator;

public class Calculator {
    public static void plus(double first, double second) {
        System.out.println((int) (first + second));
    }

    public static void minus(double first, double second) {
        System.out.println((int) (first - second));
    }

    public static void main(String[] args) {
       plus(1, 2);
       plus(10, 11);
       minus(7, 3);
       minus(2, 6);
    }
}
