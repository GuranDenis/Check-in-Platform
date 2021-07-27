package com.ibm.checkin.config;

import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.repository.DisciplineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DisciplineConfig {

    @Bean
    CommandLineRunner commandLineRunner(DisciplineRepository repository){
        return args -> {
            Discipline programming =  new Discipline(
                    "programming",
                    "FMI",
                    "IE",
                    2,
                    1,
                    5
            );

            Discipline database =  new Discipline(
                    "database",
                    "FMI",
                    "IE",
                    2,
                    1,
                    4
            );

            repository.saveAll(List.of(programming, database));
        };
    }
}
