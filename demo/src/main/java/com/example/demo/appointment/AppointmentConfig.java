package com.example.demo.appointment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AppointmentConfig {
    @Bean
    //Vazw karfwta kapoia appointments sth vash
    CommandLineRunner commandLineRunner(AppointmentRepository repository) {
        return args -> {
            Appointment ap1 = new Appointment(
              "Giannis",
                    "giannis@uniwa.gr",
                    LocalDate.of(2023, Month.FEBRUARY, 24)
            );

            Appointment ap2 = new Appointment(
                    "Xrhstos",
                    "xrhstos@uniwa.gr",
                    LocalDate.of(2023, Month.FEBRUARY, 25)
            );

            repository.saveAll(
                    List.of(ap1, ap2)
            );
        };
    }

}
