package org.example.multithreading.synchCollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) {
        BlockingQueue<Object> names = new ArrayBlockingQueue<>(5);

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try{
                    names.put("Имя " + i);
                    System.out.println("ДОБАВИЛИ " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    System.out.println("ВЗЯЛИ " + names.take());
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

    }
}
