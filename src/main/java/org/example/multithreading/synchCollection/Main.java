package org.example.multithreading.synchCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        List<Integer> list2 = Collections.synchronizedList(list);

        new Thread(() -> {
            list2.add(1);
        }).start();

        new Thread(() -> {
            list2.add(2);
        }).start();
    }
}
