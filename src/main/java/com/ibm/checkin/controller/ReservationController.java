package com.ibm.checkin.controller;

import com.ibm.checkin.entity.Reservation;
import com.ibm.checkin.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }

    @GetMapping("/student/{student_id}")
    public List<Reservation> getReservationsByStudentId(@PathVariable("student_id") Long studentId){
        return reservationService.getReservationByStudentId(studentId);
    }

    @GetMapping("/schedule/{schedule_id")
    public List<Reservation> getReservationsByScheduleId(@PathVariable("schedule_id") Long scheduleId){
        return reservationService.getReservationByScheduleId(scheduleId);
    }

    @GetMapping("/id/{id}")
    public Reservation getReservationById(@PathVariable("id") Long id){
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable("id") Long id){
        reservationService.deleteReservationById(id);
    }

}
