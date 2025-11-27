package org.example.multithreading.Volatile_Atomic;

public class Main {

    public static long myVar = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            myVar = 10;
        }).start();

        new Thread(() -> {
            myVar = 10_000_000_000L;
        }).start();
    }



}
