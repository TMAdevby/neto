package org.example.TDD.MultithreadingPattern;

import java.time.LocalDateTime;

public class Log {

    public void log(String level, String msg){
        System.out.println("[" + level + "]" +
                LocalDateTime.now() + " === " + msg);
    }

}
