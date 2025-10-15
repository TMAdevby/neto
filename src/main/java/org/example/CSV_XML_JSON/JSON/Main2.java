package org.example.CSV_XML_JSON.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;

public class Main2 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Матроскин";
        cat.age = 5;
        cat.color = Color.blue.getRGB();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();   //форматирует
        Gson gson = builder.create();
        System.out.println(gson.toJson(cat));
    }
}
