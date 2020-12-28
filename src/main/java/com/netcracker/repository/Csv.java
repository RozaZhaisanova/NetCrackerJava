package com.netcracker.repository;

import com.netcracker.contract.Contract;
import com.netcracker.contract.Internet;
import com.netcracker.contract.Mobile;
import com.netcracker.contract.Television;
import com.netcracker.di.AutoInjectable;
import com.netcracker.enums.ChannelPackage;
import com.netcracker.enums.Gender;
import com.netcracker.person.Person;
import com.netcracker.validators.ContractValidator;
import com.netcracker.validators.PersonValidator;
import com.netcracker.validators.Validator;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.netcracker.validators.Status.ERROR;

/**
 * Класс добавляющий в репозиторий контракты из файла csv
 */
public class Csv {
    @AutoInjectable(clazz = Validator.class)
    private static List<Validator> validators;
    private static boolean isValidate(Contract contract){
        boolean result = true;
        for(Validator validator : validators){
            Validator res = validator.validate(contract);
            if(res.getStatus() == ERROR){
                result = false;
            }
        }
        return result;
    }
    /**
     * Возвращает репозиторий с добавленными контрактами
     *  @param path путь файла
     *  @param rep  репозиторий, куда добавим контракты
     * @return репозиторий
     */
    @SuppressWarnings("deprecation")
    public static Repository readAllDataFromCSV(String path,Repository rep)
    {
        try
        {
            ArrayList<Person> persons=new  ArrayList<Person>();
            FileReader filereader = new FileReader(path);
            CSVReader reader = new CSVReader(filereader, ';');
            ContractValidator contractValidator = new ContractValidator();
            PersonValidator personValidator = new PersonValidator();

            try {
                List<String[]> allData = reader.readAll();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
                for(int i=1;i<allData.size();i++) {
                    String[] passport = allData.get(i)[6].split(" ");
                    Person newPerson = null;
                    for (Person person : persons) {
                        if (person.getPassportNumber() == (Integer.parseInt(passport[1])) &&
                                person.getPassportSeries() == passport[0]) {
                            newPerson = person;
                            break;
                        }
                    }
                    if (newPerson == null) {
                        newPerson = new Person(allData.get(i)[3], LocalDate.parse(allData.get(i)[4], dtf), Gender.StringToGender(allData.get(i)[5]), passport[0], Integer.parseInt(passport[1]));
                        persons.add(newPerson);
                    }

                    LocalDate beg = LocalDate.parse(allData.get(i)[1], dtf);
                    LocalDate end = LocalDate.parse(allData.get(i)[2], dtf);

                    switch (allData.get(i)[7].toLowerCase()) {
                        case "internet":
                            Contract newContract = new Internet(
                                    Integer.parseInt(allData.get(i)[0]), beg, end,
                                    newPerson, Integer.parseInt(allData.get(i)[8]));
                            if(isValidate(newContract)) {
                                rep.add(newContract);
                            }
                            break;
                        case "mobile":
                            String[] mob = allData.get(i)[8].split(",");
                            Contract newContract2 = new Contract();
                             newContract2 = new Mobile(
                                    Integer.parseInt(allData.get(i)[0]), beg, end,
                                    newPerson, Integer.parseInt(mob[0]), Integer.parseInt(mob[1]), Integer.parseInt(mob[2]));
                            if(isValidate(newContract2)) {
                                rep.add(newContract2);
                            }
                            break;
                        case "television":
                            ChannelPackage cp;
                            switch (allData.get(i)[8].toLowerCase()) {
                                case "standard":
                                    cp = ChannelPackage.STANDARD;
                                    break;
                                case "sport":
                                    cp = ChannelPackage.SPORT;
                                    break;
                                case "family":
                                    cp = ChannelPackage.FAMILY;
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + allData.get(i)[8].toLowerCase());
                            }

                            Contract newContract3 = new Television(
                                    Integer.parseInt(allData.get(i)[0]), beg, end,
                                    newPerson, cp);
                            if(isValidate(newContract3)) {
                                rep.add(newContract3);
                            }
                    }


                }
            }

            catch (Exception e) {

                e.printStackTrace();
                e.getClass();
            }
            finally
            {
                reader.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rep;
    }
}
