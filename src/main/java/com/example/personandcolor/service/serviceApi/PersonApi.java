package com.example.personandcolor.service.serviceApi;

import com.example.personandcolor.domain.Person;

import java.util.Collection;

public interface PersonApi {

    Collection<Person> getAllPersons();
    Person getPerson(int id);
    boolean addNewPerson(Person person);

}
