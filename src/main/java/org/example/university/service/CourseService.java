package org.example.university.service;

import lombok.AllArgsConstructor;
import org.example.university.entity.Course;
import org.example.university.entity.Professor;
import org.example.university.entity.Student;
import org.example.university.exception.ConflictException;
import org.example.university.exception.NotFoundException;
import org.example.university.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final ProfessorService professorService;

    public Course save(Course course) {
        Optional<Course> course1=courseRepository.findByCode(course.getCode());
        if(course1.isPresent())
            throw new ConflictException("the course with the desired code is available in the system ");
        return courseRepository.save(course);
    }

    public Course findById(Long id) {
        Optional<Course> optional=courseRepository.findById(id);
        if(optional.isEmpty())
            throw new NotFoundException("درس پیدا نشد !! صحیح وارد کنید ");
        return optional.get();
    }

    public Course update(Course course) {
    findById(course.getId());
    return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        findById(id);
        courseRepository.deleteById(id);
    }
    public List<Course> findAll(){
        return courseRepository.findAll();
    }


    public void addStudent(long courseId, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findById(courseId);

        course.getStudents().add(student);
        student.getCourses().add(course);

        studentService.update(student);
        update(course);
    }

    public void removeStudent(long CourseId, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findById(CourseId);

        if (!course.getStudents().contains(student))
            throw new NotFoundException("The student does not have this course.");
        course.getStudents().remove(student);
        student.getCourses().remove(course);

        studentService.update(student);
        update(course);
    }



}
