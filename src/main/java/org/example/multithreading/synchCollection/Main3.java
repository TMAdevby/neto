package org.example.multithreading.synchCollection;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main3 {
    public static void main(String[] args) {
        Set<String> set = ConcurrentHashMap.newKeySet();
        set.add("Hello");
        set.add("World");
        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("Petya"));
    }
}
