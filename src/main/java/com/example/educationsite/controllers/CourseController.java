package com.example.educationsite.controllers;

import static org.springframework.http.ResponseEntity.ok;
import com.example.educationsite.dtos.CourseDto;
import com.example.educationsite.entities.Courses;
import com.example.educationsite.services.CourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

  private final CourseService courseService;

  @PostMapping("/course")
  public ResponseEntity<Courses> addCourse(
      @RequestBody final CourseDto requestDto) {
    log.info("To create a new course using Course Controller");
    Courses result = courseService.createNewCourse(requestDto);

    return ok().body(result);
  }

  @GetMapping("/")
  public ResponseEntity<List<Courses>> findAllCourses() {
    log.info("To get all the coursers in Courses Controller");
    final List<Courses> courseResponse = courseService.getAllCourses();

    return ok().body(courseResponse);
  }

  @DeleteMapping("/course/{id}")
  public ResponseEntity<?> deleteCourse(@PathVariable("id") long courseId) {
    log.info("To delete the specific course using in Course Controller");
    courseService.deleteCourse(courseId);

    return ok().build();
  }

  @PutMapping("/course/{id}")
  public ResponseEntity<?> updateRequestParameter(
      @PathVariable("id") Long courseId,
      @RequestBody CourseDto courseDto) {
    log.info("To update the course details using courseID in Course Controller class");
    courseService.updateEducationCourse(courseId, courseDto);

    return ok().build();
  }

}
