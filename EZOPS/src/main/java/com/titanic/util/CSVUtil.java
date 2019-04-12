package com.titanic.util;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.titanic.entity.Passenger;


import java.io.*;
import java.util.List;
import java.util.*;


public class CSVUtil {

    public static List<Passenger> readCsv(String filename) {
        List<Passenger> list = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withIgnoreQuotations(true).build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filename)).withSkipLines(1).withCSVParser(parser).build())
        {
            String[] rowData = null;
            while ((rowData = reader.readNext()) != null) {
                Passenger ObjP = new Passenger(Integer.parseInt(rowData[0]), Integer.parseInt(rowData[1]), rowData[2], rowData[3], rowData[4], rowData[5].equals("") ?  0 : Float.parseFloat(rowData[5]),
                        Integer.parseInt(rowData[6]), Integer.parseInt(rowData[7]), rowData[8],rowData[9].equals("") ? 0:  Float.parseFloat(rowData[9]), rowData[10], rowData[11].charAt(0));
                list.add(ObjP);
                System.out.println(rowData[0]);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}


