package com.ibm.checkin.config;

import com.ibm.checkin.entity.Classroom;
import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.entity.Role;
import com.ibm.checkin.entity.User;
import com.ibm.checkin.repository.ClassroomRepository;
import com.ibm.checkin.repository.DisciplineRepository;
import com.ibm.checkin.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfig {

    final UserRepository userRepository;

    final DisciplineRepository disciplineRepository;

    final ClassroomRepository classroomRepository;

    public DataConfig(DisciplineRepository disciplineRepository, UserRepository userRepository, ClassroomRepository classroomRepository) {
        this.disciplineRepository = disciplineRepository;
        this.userRepository = userRepository;
        this.classroomRepository = classroomRepository;
    }

    @Bean
    void initData() {
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

        userRepository.saveAll(List.of(mircea, denis));

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

        disciplineRepository.saveAll(List.of(programming, database));

        Classroom class1 = new Classroom(
                101,
                50
        );

        Classroom class2 =  new Classroom(
                102,
                60
        );

        classroomRepository.saveAll(List.of(class1, class2));
    }
}
