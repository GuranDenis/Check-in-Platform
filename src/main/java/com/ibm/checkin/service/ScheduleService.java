package com.ibm.checkin.service;

import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.entity.Schedule;
import com.ibm.checkin.repository.ClassroomRepository;
import com.ibm.checkin.repository.DisciplineRepository;
import com.ibm.checkin.repository.ScheduleRepository;
import com.ibm.checkin.request.ScheduleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final DisciplineRepository disciplineRepository;
    private final ClassroomRepository classroomRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, DisciplineRepository disciplineRepository, ClassroomRepository classroomRepository) {
        this.scheduleRepository = scheduleRepository;
        this.disciplineRepository = disciplineRepository;
        this.classroomRepository = classroomRepository;
    }

    public List<Schedule> getSchedule(){
        return scheduleRepository.findAll();
    }

    public void addSchedule(ScheduleRequest scheduleRequest) {
        Long disciplineId = scheduleRequest.getDisciplineId();
        Long classroomId = scheduleRequest.getClassroomId();
        LocalDate day = scheduleRequest.getDay();
        LocalTime time = scheduleRequest.getTime();
        LocalDateTime startTime = LocalDateTime.of(day.getYear(),day.getMonth(),day.getDayOfMonth(),time.getHour(),time.getMinute());
        if (!disciplineRepository.existsById(disciplineId))
            throw new IllegalStateException("Discipline with id " + disciplineId + " doesn't exist");
        if (!disciplineRepository.existsById(classroomId))
            throw new IllegalStateException("Classroom with id " + classroomId + " doesn't exist");
        List<Schedule> schedules = getSchedule();
        for(Schedule schedule : schedules)
            if(schedule.getDiscipline().getId().equals(disciplineId) &&
                schedule.getClassroom().getId().equals(classroomId) &&
                schedule.getStartTime().getDayOfWeek().equals(startTime.getDayOfWeek()) &&
                schedule.getStartTime().getHour() == startTime.getHour() &&
                schedule.getStartTime().getMinute() == startTime.getMinute())
                throw new IllegalStateException("Schedule already created");

        Schedule schedule = new Schedule(
                disciplineRepository.getById(disciplineId),
                classroomRepository.getById(classroomId),
                startTime
        );
        scheduleRepository.save(schedule);
    }

    public void setDisciplineId(Long scheduleId, Long disciplineId) {
        if (!scheduleRepository.existsById(scheduleId))
            throw new IllegalStateException("Schedule with id " + scheduleId + " doesn't exist");
        if (!disciplineRepository.existsById(disciplineId))
            throw new IllegalStateException("Discipline with id " + disciplineId + " doesn't exist");
        Schedule schedule = scheduleRepository.getById(scheduleId);
        Discipline discipline = disciplineRepository.getById(disciplineId);
        schedule.setDiscipline(discipline);
        scheduleRepository.save(schedule);
    }

    public List<Schedule> getScheduleByDisciplineId(Long disciplineId) {
        if (!disciplineRepository.existsById(disciplineId))
            throw new IllegalStateException("Discipline with id " + disciplineId + " doesn't exist");
        return scheduleRepository.getScheduleByDisciplineId(disciplineId);

    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
