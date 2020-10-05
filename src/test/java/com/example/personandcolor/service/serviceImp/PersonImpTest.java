package com.example.personandcolor.service.serviceImp;

import com.example.personandcolor.domain.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


class PersonImpTest {

    static PersonImp personImp;

    @BeforeAll
    static void init(){
        personImp = new PersonImp();
    }

    @Test
    void getAllPersonsTest() {
        Collection<Person> persons = personImp.getAllPersons();
        assertNotEquals(persons.size(), 0, "No Data was returned");
    }

    @Test
    void getPersonTest() {
        // Johnson, Johnny, 88888 made up, 3
        Person testPerson = new Person("Johnny", "Johnson", "88888", "made up", "violett");
        Person person = personImp.getPerson(3);
        assertEquals(testPerson, person, "Wrong Information was delivered");

    }

    @Test
    void addNewPersonTest() {
    }
}