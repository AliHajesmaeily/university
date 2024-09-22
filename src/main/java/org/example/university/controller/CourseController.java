package org.example.university.controller;

import lombok.AllArgsConstructor;
import org.example.university.dto.course.AddCourseDTO;
import org.example.university.dto.course.UpdateCourseDTO;
import org.example.university.dto.course.ViewCourseDTO;
import org.example.university.entity.Course;
import org.example.university.mapper.CourseMapper;
import org.example.university.mapper.ProfessorMapper;
import org.example.university.mapper.StudentMapper;
import org.example.university.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/v1/")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final ProfessorMapper professorMapper;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewCourseDTO save(@RequestBody AddCourseDTO addCourseDTO) {
        Course course = courseService.save(courseMapper.toEntity(addCourseDTO));
        return courseMapper.toViewDto(course);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewCourseDTO update(@RequestBody UpdateCourseDTO updateCourseDTO) {
        Course course = courseService.update(courseMapper.toEntity(updateCourseDTO));
        return courseMapper.toViewDto(course);
    }




    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewCourseDTO findById(@PathVariable Long id) {
        return courseMapper.toViewDto(courseService.findById(id));
    }

    @GetMapping("/list")
    public List<ViewCourseDTO> findAll() {
        return courseMapper.toListViewDTO(courseService.findAll());
    }




}
