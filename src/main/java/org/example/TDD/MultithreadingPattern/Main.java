package org.example.TDD.MultithreadingPattern;

public class Main {
    public static void main(String[] args) {
        Log log = new Log();
        log.log("INFO", "Hello");
        log.log("ERROR", "Произошла ошибка");
        log.log("INFO", "Bye");
    }
}
