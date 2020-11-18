package com.netcracker;

import com.netcracker.repository.Csv;
import com.netcracker.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception{
        String csvFile = "src\\main\\resources\\contracts.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[]c = line.split(cvsSplitBy);
                System.out.println("др клиента[birthday = " + c[4]+ " , пол = " + c[5]+ " , паспорт =" + c[6]+ "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Repository repo=new Repository();
        Repository rep= Csv.readAllDataFromCSV(csvFile,repo);
        System.out.println(" Имя клиента третьего в списке контракта:\n"+rep.getArray()[2].getClient());

    }}
