package com.ibm.checkin.config;

import com.ibm.checkin.entity.*;
import com.ibm.checkin.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataConfig {

    private final UserRepository userRepository;

    private final DisciplineRepository disciplineRepository;

    private final ClassroomRepository classroomRepository;

    private final ScheduleRepository scheduleRepository;

    private final FeatureRepository featureRepository;


    public DataConfig(DisciplineRepository disciplineRepository, UserRepository userRepository, ClassroomRepository classroomRepository, ScheduleRepository scheduleRepository, FeatureRepository featureRepository) {
        this.disciplineRepository = disciplineRepository;
        this.userRepository = userRepository;
        this.classroomRepository = classroomRepository;
        this.scheduleRepository = scheduleRepository;
        this.featureRepository = featureRepository;
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

        System.out.println(programming.getTimetable());

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

        Feature videoProjector = new Feature(
                class1,
                "video projector"
        );

        featureRepository.save(videoProjector);

        Schedule schedule = new Schedule(
                programming,
                class1,
                LocalDateTime.of(2021,10,13, 12, 0),
                LocalDateTime.of(2021,10,13, 13, 30)
        );

        scheduleRepository.save(schedule);

    }
}
