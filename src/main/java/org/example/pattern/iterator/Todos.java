package org.example.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class Todos {

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
}
