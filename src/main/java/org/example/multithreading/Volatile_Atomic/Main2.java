package org.example.multithreading.Volatile_Atomic;

public class Main2 {
    public static int counter = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            counter++;
        }).start();

        new Thread(() -> {
            counter++;
        }).start();

        System.out.println(counter);
    }
}
