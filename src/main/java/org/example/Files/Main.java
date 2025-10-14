package org.example.Files;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("dir1/dir2/dir3", "Hello2.txt");
//        file.getParentFile().mkdirs();  //создать папки без файла
//
//        try {
//            boolean created = file.createNewFile();
//            if (created) {
//                System.out.println("Файл создан: " + file.getAbsolutePath());
//            } else {
//                System.out.println("Файл уже существует.");
//            }
//        } catch (IOException e) {
//            System.err.println("Ошибка при создании файла: " + e.getMessage());
//        }

        //посмотреть что в папке
        File file2 = new File("dir1");
        for (File f : file2.listFiles()) {
            if (f.isFile()) {
                System.out.println("File: " + f.getName());
            } else {
                System.out.println("Directory: " + f.getName());
            }
        }
    }
}
