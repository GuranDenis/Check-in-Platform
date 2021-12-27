package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation getReservationById(Long id);

    List<Reservation> getReservationByStudentId(Long studentId);

    List<Reservation> getReservationByScheduleId(Long scheduleId);

    Reservation getReservationByStudentIdAndScheduleId(Long studentId, Long scheduleId);
}
