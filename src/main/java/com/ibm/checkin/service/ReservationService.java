package com.ibm.checkin.service;

import com.ibm.checkin.entity.Reservation;
import com.ibm.checkin.entity.Role;
import com.ibm.checkin.repository.ReservationRepository;
import com.ibm.checkin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(Reservation reservation) {

        Long studentId = reservation.getStudentId();
        if (!userRepository.existsById(studentId))
            throw new IllegalStateException("Student with id " + studentId + " doesn't exist");

        if (userRepository.existsById(studentId) && !userRepository.getById(studentId).getRole().equals(Role.student))
            throw new IllegalStateException("You are not a student");

        for (Reservation reservationObject: reservationRepository.getReservationByStudentId(reservation.getStudentId())
             ) {
            if(reservationObject.getScheduleId().equals(reservation.getScheduleId()))
                throw new IllegalStateException("Reservation already created with id " + reservationObject.getId());
        }
        reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.getReservationById(id);
    }

    public Reservation getReservationByStudentIdAndScheduleId(Long studentId, Long scheduleId){
        return reservationRepository.getReservationByStudentIdAndScheduleId(studentId, scheduleId);
    }

    public List<Reservation> getReservationByStudentId(Long studentId) {
        return reservationRepository.getReservationByStudentId(studentId);
    }

    public List<Reservation> getReservationByScheduleId(Long scheduleId) {
        return reservationRepository.getReservationByScheduleId(scheduleId);
    }

    public void deleteReservationById(Long id) {
        if(!reservationRepository.existsById(id))
            throw new IllegalStateException("Reservation with id " + id + " doesn't exist");
        reservationRepository.deleteById(id);
    }

    public void deleteReservation(Long studentId, Long scheduleId) {
        deleteReservationById(getReservationByStudentIdAndScheduleId(studentId, scheduleId).getId());
    }
}
