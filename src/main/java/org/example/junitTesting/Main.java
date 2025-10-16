package org.example.junitTesting;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int x = calculator.subtract(11,1);
        System.out.println(x);
    }
}
