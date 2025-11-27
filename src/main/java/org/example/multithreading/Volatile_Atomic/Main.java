package org.example.multithreading.Volatile_Atomic;

public class Main {

    public static volatile long myVar1 = 0;
    public static volatile long myVar2 = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            myVar2 = -100;
            myVar1 = 1;
        }).start();

        new Thread(() -> {
            while (myVar1 != 1){}
            System.out.println(myVar2);
        }).start();

    }



}
