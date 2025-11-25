package org.example.multithreading.synchronizedd;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

    List<String> names = new ArrayList<>();

    new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            synchronized (names) {
                names.add("Имя номер " + i);
                System.out.println("Зашел покупатель Имя номер " + i);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                return;
            }
        }
    }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (names) {
                    if (!names.isEmpty()) {
                        System.out.println("Обслужили покупателя " + names.remove(0));
                    } else {
                        System.out.println("ПУСТО");
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
        Thread.sleep(20000); // ждём 5 секунд
        System.out.println("Финальный список: " + names);
    }
}
