package org.example.university.service;

import lombok.AllArgsConstructor;
import org.example.university.dto.course.ViewCourseDTO;
import org.example.university.entity.Course;
import org.example.university.entity.Professor;
import org.example.university.exception.ConflictException;
import org.example.university.exception.NotFoundException;
import org.example.university.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {


    private final ProfessorRepository professorRepository;



    public Professor save(Professor professor) {
        Optional<Professor> optional;

        //it checks if this NationalCode already exist or not
        optional=professorRepository.findById(professor.getNationalCod());
        if(optional.isPresent())
            throw new ConflictException("The professor with the National Code is available in the system");

        optional=professorRepository.findByUserName(professor.getUserName());
        if(optional.isPresent())
            throw new ConflictException("The professor with the UserName is available in the system");


        optional=professorRepository.findByCode(professor.getCode());
        if(optional.isPresent())
            throw new ConflictException("The professor with the code is available in the system");

        return professorRepository.save(professor);
    }



    public Professor update(Professor professor) {
        findById(professor.getId());
        return professorRepository.save(professor);
    }

    public void deleteById(Long id) {
        findById(id);
        professorRepository.deleteById(id);
    }

    public Professor findById(Long id) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Professor not found");
        return optional.get();
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findByCode(int code) {
        Optional<Professor> optional = professorRepository.findByCode(code);
        if (optional.isEmpty())
            throw new NotFoundException("Professor Not found.");
        return optional.get();
    }

    public List<Course> listCoursesProfessor(int code) {
        Professor professor = findByCode(code);
        return professor.getCourses().stream().toList();
    }





}
