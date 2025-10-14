package org.example.CSV_XML_JSON.CSV;

import com.opencsv.*;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
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
        //чтение
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
//        CSVParser parser = new CSVParserBuilder()
//                .withSeparator('|')
//                .build();
//
//        try(CSVReader reader = new CSVReaderBuilder(new FileReader("staff_with_custom_separator.csv"))
//                .withCSVParser(parser)
//                .build()){
//            String[] nextLine;
//            while((nextLine = reader.readNext()) != null){
//                System.out.println(Arrays.toString(nextLine));
//            }
//        } catch (CsvValidationException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //parsing/deserialization  превращает запись в объект
//        try(CSVReader csvReader = new CSVReader(new FileReader("staff.csv"))) {
//            ColumnPositionMappingStrategy<Employee>strategy =
//                   new ColumnPositionMappingStrategy<>();
//            strategy.setType(Employee.class);
//            strategy.setColumnMapping("id","firstName","lastName","country","age");
//            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
//                    .withMappingStrategy(strategy)
//                    .build();
//            List<Employee> staff = csv.parse();
//            staff.forEach(System.out::println);
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee(1, "Nikita", "Shumskii", "Russia", 40));
        staff.add(new Employee(2, "Pavel", "Shramko", "Russia", 30));
        ColumnPositionMappingStrategy<Employee> strategy =
                new ColumnPositionMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping("id", "firstName", "country", "age");
        try (Writer writer = new FileWriter("staff_2.csv")) {
            StatefulBeanToCsv<Employee> sbc =
                    new StatefulBeanToCsvBuilder<Employee>(writer)
                            .withMappingStrategy(strategy)
                            .build();
            sbc.write(staff);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }

    }
}
