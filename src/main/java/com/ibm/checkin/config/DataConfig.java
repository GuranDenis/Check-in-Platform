package com.ibm.checkin.config;

import com.ibm.checkin.entity.*;
import com.ibm.checkin.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataConfig {

    final UserRepository userRepository;

    final DisciplineRepository disciplineRepository;

    final ClassroomRepository classroomRepository;

    final ScheduleRepository scheduleRepository;

    final AllocationRepository allocationRepository;

    public DataConfig(DisciplineRepository disciplineRepository, UserRepository userRepository, ClassroomRepository classroomRepository, ScheduleRepository scheduleRepository, AllocationRepository allocationRepository) {
        this.disciplineRepository = disciplineRepository;
        this.userRepository = userRepository;
        this.classroomRepository = classroomRepository;
        this.scheduleRepository = scheduleRepository;
        this.allocationRepository = allocationRepository;
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

        Schedule schedule = new Schedule(
                LocalDateTime.of(2021,10,13, 12, 0),
                database
        );

        scheduleRepository.save(schedule);

        Classroom class1 = new Classroom(
                101,
                50
        );

        Classroom class2 =  new Classroom(
                102,
                60
        );

        classroomRepository.saveAll(List.of(class1, class2));

        Allocation allocation1 = new Allocation(
                class1.getId(),
                database.getId()
        );

        allocationRepository.save(allocation1);

    }
}
