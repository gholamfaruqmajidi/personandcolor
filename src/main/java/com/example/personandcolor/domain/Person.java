package com.example.personandcolor.domain;

import com.example.personandcolor.utils.AddressUtils;
import com.example.personandcolor.utils.ColorUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    //Müller, Hans, 67742 Lauterecken, 1

    @Id @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String zipcode;
    private String city;
    private String color;


    public Person(){}

    public Person(String firstName, String lastName, String zipcode, String city, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.city = city;
        this.color = color;
    }

    public Person(int id, String firstName, String lastName, String zipcode, String city, String color) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.city = city;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Person recordToPerson(int id, String record){
        // record = Müller, Hans, 67742 Lauterecken, 1
        String[] values = record.split(",");
        return new Person(id , values[0], values[1].trim(), AddressUtils.getZipcode(values[2].trim()),
                AddressUtils.getCity(values[2].trim()) , ColorUtils.getColor(Integer.parseInt(values[3].trim())));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){

        if (obj == this){
            return true;
        }

        if (!(obj instanceof Person)){
            return false;
        }

        Person person = (Person) obj;

        return (this.firstName.equals(person.getFirstName())
                && this.lastName.equals(person.getLastName())
                && this.zipcode.equals(person.getZipcode())
                && this.city.equals(person.getCity())
                && this.color.equals(person.getColor()));
    }

}
