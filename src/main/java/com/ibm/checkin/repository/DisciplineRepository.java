package com.ibm.checkin.repository;

import com.ibm.checkin.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findDisciplineById(Long id);
    List<Discipline> getDisciplinesByName(String name);

    @Query("SELECT new com.ibm.checkin.dto.DisciplineDTO(S.id, S.discipline.id, S.classroom.id, S.startTime," +
            "D.name ,CL.location, U.firstName, U.lastName, CL.capacity, COUNT(R.studentId))" +
            "FROM schedule as S INNER JOIN classrooms as CL ON CL.id = S.classroom.id " +
            "INNER JOIN disciplines as D ON D.id = S.discipline.id " +
            "INNER JOIN users U ON D.teacherId = U.id " +
            "LEFT JOIN reservations R ON S.id = R.scheduleId GROUP BY S.startTime")
    List<DisciplineDTO> getDisciplinesDTO();

    @Query("SELECT new com.ibm.checkin.dto.DisciplineDTO(S.id, S.discipline.id, S.classroom.id, S.startTime," +
            "D.name ,CL.location, U.firstName, U.lastName, CL.capacity, COUNT(R.studentId))" +
            "FROM schedule as S INNER JOIN classrooms as CL ON CL.id = S.classroom.id " +
            "INNER JOIN disciplines as D ON D.id = S.discipline.id " +
            "INNER JOIN users U ON D.teacherId = U.id " +
            "LEFT JOIN reservations R ON S.id = R.scheduleId " +
            "WHERE S.startDay = :day GROUP BY S.startTime")
    List<DisciplineDTO> getDisciplinesDTOByDay(@Param("day") String day);

    interface DisciplineDTO {
        Long getScheduleId();
        Long getDisciplineId();
        Long getClassroomId();
        LocalDateTime getStartTime();
        String getDisciplineName();
        String getClassroomLocation();
        String getTeacherFirstName();
        String getTeacherLastName();
        int getCapacity();
        int getEnrolledStudentsNumber();
    }
}
