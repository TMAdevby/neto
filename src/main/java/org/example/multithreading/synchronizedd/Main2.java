package org.example.multithreading.synchronizedd;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> buffer = new ArrayList<>();
        final Object lock = new Object();
        boolean produced = false; // флаг: готов ли элемент

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (produced) {
                        try {
                            lock.wait(); // ждём, пока потребитель не заберёт
                        } catch (InterruptedException e) { return; }
                    }
                    buffer.add("Имя " + i);
                    System.out.println("Добавил: Имя " + i);
                    produced = true;
                    lock.notify(); // будим потребителя
                }
                try { Thread.sleep(100); } catch (InterruptedException e) { return; }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while (!produced) {
                        try {
                            lock.wait(); // ждём, пока не появится элемент
                        } catch (InterruptedException e) { return; }
                    }
                    String item = buffer.remove(0);
                    System.out.println("Обработал: " + item);
                    produced = false;
                    lock.notify(); // будим производителя
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
