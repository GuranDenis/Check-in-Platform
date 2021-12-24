package com.ibm.checkin.service;

import com.ibm.checkin.dto.DisciplineInfo;
import com.ibm.checkin.entity.Discipline;
import com.ibm.checkin.entity.Role;
import com.ibm.checkin.repository.DisciplineRepository;
import com.ibm.checkin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    private final UserRepository userRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository, UserRepository userRepository) {
        this.disciplineRepository = disciplineRepository;
        this.userRepository = userRepository;
    }

    public List<Discipline> getDisciplines(){
        return disciplineRepository.findAll();
    }

    public Discipline findByID(Long id) {
        if(!disciplineRepository.existsById(id))
            throw new IllegalStateException("Discipline with id " + id + " doesn't exist");
        return disciplineRepository.findDisciplineById(id);
    }

    public void addDiscipline(Discipline discipline) {
        for (Discipline disciplineObject: disciplineRepository.getDisciplinesByName(discipline.getName()))
            if(disciplineObject.getFaculty().equals(discipline.getFaculty()) &&
                    disciplineObject.getSection().equals(discipline.getSection()) &&
                        disciplineObject.getSemester() == discipline.getSemester() &&
                            disciplineObject.getYear() == discipline.getYear())
                throw new IllegalStateException("Discipline " + discipline.getName() + " already created with id "+ disciplineObject.getId());
        disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(Long id) {
        if(!disciplineRepository.existsById(id))
            throw new IllegalStateException("Discipline with id " + id + " doesn't exist");
        disciplineRepository.deleteById(id);
    }

    public void setTeacherId(Long discipline_id, Long teacher_id) {
        if(!disciplineRepository.existsById(discipline_id))
            throw new IllegalStateException("Discipline with id " + discipline_id + " doesn't exist");
        if(!userRepository.existsById(teacher_id))
            throw new IllegalStateException("User with id " + teacher_id + " doesn't exist");
        if(!userRepository.getById(teacher_id).getRole().equals(Role.teacher))
            throw new IllegalStateException("User with id " + teacher_id + " is not a teacher");

        Discipline discipline = disciplineRepository.getById(discipline_id);
        discipline.setTeacherId(teacher_id);
        disciplineRepository.save(discipline);
    }

    public List<DisciplineRepository.DisciplineDTO> getDisciplinesDTO() {
        return disciplineRepository.getDisciplinesDTO();
    }

    public List<DisciplineRepository.DisciplineDTO> getDisciplinesDTOByDay(String day) {
        return disciplineRepository.getDisciplinesDTOByDay(day);
    }

    public List<DisciplineInfo> getDisciplineInfo() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        List<DisciplineInfo> names = new ArrayList<>();
        for(Discipline discipline : disciplines)
            names.add(new DisciplineInfo(discipline.getId(), discipline.getName()));
        return names;
    }
}
