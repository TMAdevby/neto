package org.example.multithreading;

public class Main {
    public static void main(String[] args) {
        Runnable logic = () -> {
            while (true) {
                System.out.println("Hello from thread");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };

        Thread thread = new Thread(logic);
        thread.start();

        while (true){
            System.out.println("Hello from main");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
