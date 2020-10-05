package com.example.personandcolor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PersonAndColorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonAndColorApplication.class, args);
    }

}
