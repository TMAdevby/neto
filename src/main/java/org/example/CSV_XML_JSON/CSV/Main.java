package org.example.CSV_XML_JSON.CSV;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Запись
//        String[] employee = "1,David,Miller,Australia,30".split(",");
//        String[] employee2 = "2,Chris,Brown,New Zealand,42".split(",");
//        List<String[]>employees = new ArrayList<>();
//        employees.add(employee);
//        employees.add(employee2);
//
//        try(CSVWriter writer = new CSVWriter(new FileWriter("staff.csv"))){
////            for (String[] emp : employees) {
////                writer.writeNext(emp);
////            }
////            employees.forEach(emp -> writer.writeNext(emp));
//            employees.forEach(writer::writeNext);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try(CSVReader reader = new CSVReader(new FileReader("staff.csv"))){
//            String[] nextLine;
//            while((nextLine = reader.readNext()) != null){
//                System.out.println(Arrays.toString(nextLine));
//            }
//        } catch (CsvValidationException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        //читает файлы с сеператором '|'
        CSVParser parser = new CSVParserBuilder()
                .withSeparator('|')
                .build();

        try(CSVReader reader = new CSVReaderBuilder(new FileReader("staff_with_custom_separator.csv"))
                .withCSVParser(parser)
                .build()){
            String[] nextLine;
            while((nextLine = reader.readNext()) != null){
                System.out.println(Arrays.toString(nextLine));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
