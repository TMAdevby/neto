package org.example.pattern.iterator;

public class Main {
    public static void main(String[] args) {
        Todos todos = new Todos()
                .addPrimary("Побегать")
                .addPrimary("Поработать")
                .addSecondary("Сходить в магазин")
                .addPrimary("Провести вебинар");
    }
}
