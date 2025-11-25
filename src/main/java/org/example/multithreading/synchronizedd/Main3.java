package org.example.multithreading.synchronizedd;

import java.util.List;

public class Main3 {

    public static void main(String[] args) {

    }

    public static int sumSize(List<String>list1, List<String> list2){
        synchronized (list1){
            synchronized (list2){
                return list1.size() + list2.size();
            }
        }
    }
}
