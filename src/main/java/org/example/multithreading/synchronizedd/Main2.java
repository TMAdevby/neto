package org.example.multithreading.synchronizedd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> buffer = new ArrayList<>();
        final Object lock = new Object();
        AtomicBoolean produced = new AtomicBoolean(false);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (produced.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) { return; }
                    }
                    buffer.add("Имя " + i);
                    System.out.println("Добавил: Имя " + i);
                    produced.set(true);
                    lock.notify();
                }
                try { Thread.sleep(100); } catch (InterruptedException e) { return; }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (!produced.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) { return; }
                    }
                    String item = buffer.remove(0);
                    System.out.println("Обработал: " + item);
                    produced.set(false);
                    lock.notify();
                }
                try { Thread.sleep(100); } catch (InterruptedException e) { return; }
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
