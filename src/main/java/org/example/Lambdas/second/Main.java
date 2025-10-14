package org.example.Lambdas.second;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Мадрид", "Париж", "Москва", "Токио");
        /*Collections.sort(cities, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });*/

        Collections.sort(cities, (a, b) -> a.compareTo(b));

        System.out.println(cities);
    }
}
