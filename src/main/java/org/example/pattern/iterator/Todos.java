package org.example.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Todos implements Iterable<String> {

    private List<String> primary = new ArrayList<>();
    private List<String> secondary = new ArrayList<>();

    public Todos addPrimary(String task){
        primary.add(task);
        return this;
    }

    public Todos addSecondary(String task){
        secondary.add(task);
        return this;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            boolean isPrimary = true;
            int next = 0;

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return "";
            }
        }
    }
}
