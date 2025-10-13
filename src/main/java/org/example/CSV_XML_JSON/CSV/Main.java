package org.example.CSV_XML_JSON.CSV;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Запись
        String[] employee = "1,David,Miller,Australia,30".split(",");
        String[] employee2 = "2,Chris,Brown,New Zealand,42".split(",");
        List<String[]>employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);

        try(CSVWriter writer = new CSVWriter(new FileWriter("staff.csv"))){
//            for (String[] emp : employees) {
//                writer.writeNext(emp);
//            }
//            employees.forEach(emp -> writer.writeNext(emp));
            employees.forEach(writer::writeNext);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
