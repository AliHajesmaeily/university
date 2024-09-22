package org.example.university.service;


import lombok.AllArgsConstructor;
import org.example.university.entity.Course;
import org.example.university.entity.Professor;
import org.example.university.entity.Student;
import org.example.university.exception.ConflictException;
import org.example.university.exception.NotFoundException;
import org.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        Optional<Student> optional;

        //it checks if this NationalCode already exist or not
        optional = studentRepository.findById(student.getNationalCod());
        if(optional.isPresent())
            throw new ConflictException("The student with the National Code is available in the system");


        optional=studentRepository.findByUserName(student.getUserName());
        if(optional.isPresent())
            throw new ConflictException("The student with the UserName is available in the system");



        optional=studentRepository.stdNumber(student.getStdNumber());
        if(optional.isPresent())
            throw new ConflictException("The student with the code is available in the system");

        return studentRepository.save(student);
    }



    public Student update(Student student) {
        studentRepository.findById(student.getId());
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.findById(id);
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Student not found");
        return optional.get();
    }

    public Student findByStdNumber(Long  stdNumber) {
        Optional<Student> optional =studentRepository.stdNumber(stdNumber);
        if (optional.isEmpty())
            throw new NotFoundException("Student not found");
        return optional.get();
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Course> listCoursesStudent(long stdNumber) {
        Student student = findByStdNumber(stdNumber);
        return student.getCourses().stream().toList();
    }

}
