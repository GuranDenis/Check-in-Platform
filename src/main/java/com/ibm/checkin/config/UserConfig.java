package com.ibm.checkin.config;

import com.ibm.checkin.entity.Role;
import com.ibm.checkin.entity.User;
import com.ibm.checkin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User mircea = new User(
                    "Mircea",
                    "Miron",
                    Role.admin
            );

            User denis = new User(
                    "Denis",
                    "Guran",
                    Role.student
            );

            repository.saveAll(List.of(mircea, denis));
        };
    }
}
