package com.example.personandcolor.web_api;

import com.example.personandcolor.domain.Person;
import com.example.personandcolor.service.serviceApi.PersonApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonApi personsService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Collection<Person>> getPersons(){
        return new ResponseEntity<>(personsService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Person> getPersonWithId(@PathVariable("id") int id){
        return new ResponseEntity<>(personsService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping(value = "/color/{color}")
    public Collection<Person> getPersonWithColorName(@PathVariable("color") String color){
        Collection<Person> allPersons = personsService.getAllPersons();
        Collection<Person> personsWithSameColorId = new ArrayList<>();
        for (Person p : allPersons){
            if (p.getColor().equals(color)){
                personsWithSameColorId.add(p);
            }
        }

        return personsWithSameColorId;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewPerson(@RequestBody Person person){
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
