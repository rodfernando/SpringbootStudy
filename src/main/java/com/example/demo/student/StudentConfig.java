package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student mariam = new Student( //Seleciona os dados -> ctrl + alt + v
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student alex = new Student( //Seleciona os dados -> ctrl + alt + v
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, MARCH, 3)
            );

            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }

}
