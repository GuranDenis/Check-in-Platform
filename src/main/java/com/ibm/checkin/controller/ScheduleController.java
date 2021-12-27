package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Schedule;
import com.ibm.checkin.request.ScheduleRequest;
import com.ibm.checkin.request.ScheduleRequestUpdate;
import com.ibm.checkin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/all")
    public List<Schedule> getSchedule(){
        return scheduleService.getSchedule();
    }

    @GetMapping("/discipline/{discipline_id}")
    public List<Schedule> getScheduleByDisciplineId(@PathVariable("discipline_id") Long disciplineId){
        return scheduleService.getScheduleByDisciplineId(disciplineId);
    }

    @PostMapping
    public void addSchedule(@RequestBody ScheduleRequest scheduleRequest){
        scheduleService.addSchedule(scheduleRequest);
    }

    @PutMapping("/id/{schedule_id}/discipline/{discipline_id}")
    public void setDisciplineId(
            @PathVariable("schedule_id") Long scheduleId,
            @PathVariable("discipline_id") Long disciplineId){
        scheduleService.setDisciplineId(scheduleId, disciplineId);
    }

    @PutMapping
    public void updateSchedule(@RequestBody ScheduleRequestUpdate scheduleRequestUpdate){
        scheduleService.updateSchedule(scheduleRequestUpdate);
    }

    @DeleteMapping("/id/{id}")
    public void deleteSchedule(@PathVariable("id") Long id){
        scheduleService.deleteSchedule(id);
    }
}
