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

    private final ReservationRepository reservationRepository;


    public DataConfig(DisciplineRepository disciplineRepository, UserRepository userRepository, ClassroomRepository classroomRepository, ScheduleRepository scheduleRepository, FeatureRepository featureRepository, ReservationRepository reservationRepository) {
        this.disciplineRepository = disciplineRepository;
        this.userRepository = userRepository;
        this.classroomRepository = classroomRepository;
        this.scheduleRepository = scheduleRepository;
        this.featureRepository = featureRepository;
        this.reservationRepository = reservationRepository;
    }

    @Bean
    void initData() {
        User mircea = new User(
                "Mircea",
                "Miron",
                Role.admin
        );

        User john = new User(
                "John",
                "Doe",
                Role.student
        );

        User prof1 = new User(
                "Joe",
                "Dylan",
                Role.teacher
        );

        User prof2 = new User(
                "Mike",
                "Abraham",
                Role.teacher
        );

        userRepository.saveAll(List.of(mircea, john, prof1, prof2));

        Discipline programming =  new Discipline(
                "Programming",
                4L,
                "FMI",
                "IE",
                2,
                1,
                5
        );

        Discipline database =  new Discipline(
                "Database",
                3L,
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

        Schedule schedule1 = new Schedule(
                programming,
                class2,
                LocalDateTime.of(2021,10,13, 13, 0)
        );

        Schedule schedule2 = new Schedule(
                database,
                class1,
                LocalDateTime.of(2021,10,13, 14, 40)
        );

        Schedule schedule3 = new Schedule(
                programming,
                class1,
                LocalDateTime.of(2021,10,15, 13, 0)
        );

        scheduleRepository.saveAll(List.of(schedule3, schedule2, schedule1));

        Reservation reservation1 = new Reservation(
                1L,
                1L
        );

        Reservation reservation2 = new Reservation(
                1L,
                2L
        );

        Reservation reservation3 = new Reservation(
                2L,
                2L
        );

        reservationRepository.saveAll(List.of(reservation1,reservation2, reservation3));
    }
}
