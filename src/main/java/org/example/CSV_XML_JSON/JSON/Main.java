package org.example.CSV_XML_JSON.JSON;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //json simple read
//        JSONParser parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("data.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//            System.out.println(jsonObject);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

        // json simple sub object  доступ к полю объекта
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("data.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String lastName = (String) jsonObject.get("lastName");
            System.out.println(lastName);

            JSONObject address = (JSONObject) jsonObject.get("address");
            String city = (String) address.get("city");
            System.out.println(city);

            JSONArray phoneNumbers = (JSONArray) jsonObject.get("phoneNumbers");
            for(Object number : phoneNumbers){
                System.out.println(number);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
