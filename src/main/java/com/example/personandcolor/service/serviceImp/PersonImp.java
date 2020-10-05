package com.example.personandcolor.service.serviceImp;

import com.example.personandcolor.domain.Person;
import com.example.personandcolor.service.serviceApi.PersonApi;
import com.example.personandcolor.utils.AddressUtils;
import com.example.personandcolor.utils.ColorUtils;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

@Repository
public class PersonImp implements PersonApi {

    private final String path = "C:/Users/ghola/Desktop/testProjects/personandcolor/src/main/resources/sample-input.csv";


    @Override
    public Collection<Person> getAllPersons(){

        String record;
        int lineNumber = 1;
        Collection<Person> allPersons = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((record = br.readLine()) != null){
                String[] values = record.split(",");
                allPersons.add(new Person(lineNumber , values[1].trim(), values[0].trim(), AddressUtils.getZipcode(values[2].trim()),
                        AddressUtils.getCity(values[2].trim()) , ColorUtils.getColor(Integer.parseInt(values[3].trim()))));
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allPersons;
    }

    @Override
    public Person getPerson(int id){
        Person person = new Person();
        //Person person = new Person(11111, "Mustermann", "Müller", "55555", "MusterCity", "unbekannte Farbe");
        String record = "Müller, Mustermann, 55555 MusterStadt, 10";
        try {
            Stream<String> all_lines = Files.lines(Paths.get(path));
            record = all_lines.skip(id-1).findFirst().orElse(record);
            String[] values = record.split(",");

            person.setId(id);
            person.setFirstName(values[1].trim());
            person.setLastName(values[0].trim());
            person.setZipcode(AddressUtils.getZipcode(values[2].trim()));
            person.setCity( AddressUtils.getCity(values[2].trim()));
            person.setColor(ColorUtils.getColor(Integer.parseInt(values[3].trim())));


        }catch (IOException e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean addNewPerson(Person person){
        return true;
    }

}
