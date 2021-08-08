package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Schedule;
import com.ibm.checkin.request.ScheduleRequest;
import com.ibm.checkin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getSchedule(){
        return scheduleService.getSchedule();
    }

    @PostMapping
    public void addSchedule(@RequestBody ScheduleRequest scheduleRequest){
        scheduleService.addSchedule(scheduleRequest);
    }

    @PutMapping("/id/{schedule_id}/discipline/{discipline_id}")
    public void setDisciplineId(
            @PathVariable("schedule_id") Long schedule_id,
            @PathVariable("discipline_id") Long discipline_id){
        scheduleService.setDisciplineId(schedule_id, discipline_id);
    }
}
