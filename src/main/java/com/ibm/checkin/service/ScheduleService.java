package com.ibm.checkin.service;

import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.entity.Schedule;
import com.ibm.checkin.repository.DisciplineRepository;
import com.ibm.checkin.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, DisciplineRepository disciplineRepository) {
        this.scheduleRepository = scheduleRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Schedule> getSchedule(){
        return scheduleRepository.findAll();
    }

    public void addSchedule(Schedule schedule, Long discipline_id) {
        if (!disciplineRepository.existsById(discipline_id))
            throw new IllegalStateException("Discipline with id " + discipline_id + " doesn't exist");
        Discipline discipline = disciplineRepository.getById(discipline_id);
        schedule.setDiscipline(discipline);
        scheduleRepository.save(schedule);
    }

    public void setDisciplineId(Long schedule_id, Long discipline_id) {
        if (!scheduleRepository.existsById(schedule_id))
            throw new IllegalStateException("Schedule with id " + schedule_id + " doesn't exist");
        if (!disciplineRepository.existsById(discipline_id))
            throw new IllegalStateException("Discipline with id " + discipline_id + " doesn't exist");
        Schedule schedule = scheduleRepository.getById(schedule_id);
        Discipline discipline = disciplineRepository.getById(discipline_id);
        schedule.setDiscipline(discipline);
        scheduleRepository.save(schedule);
    }
}
