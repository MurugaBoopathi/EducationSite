package com.example.educationsite.services;

import com.example.educationsite.dtos.CourseDto;
import com.example.educationsite.entities.Courses;
import com.example.educationsite.mappers.EducationMapper;
import com.example.educationsite.repositories.CoursesRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CourseService {

  private final CoursesRepository coursesRepository;
  private final EducationMapper educationMapper;

  public Courses createNewCourse(CourseDto requestDto) {
    Courses course = educationMapper.convertToEntity(requestDto);
    return coursesRepository.save(course);
  }

  public List<Courses> getAllCourses() {
    log.info("Inside getAllCourses of Course Service");
    return coursesRepository.findAll();
  }

  public void deleteCourse(Long courseId) {
    if (coursesRepository.existsById(courseId)) {
      coursesRepository.deleteById(courseId);
      log.info("Education Course deleted. Course id: {}", courseId);
    } else {
      log.info("Education Course not found. Course id: {}", courseId);
    }
  }

  public void updateEducationCourse(Long courseId, CourseDto courseDto) {
    courseDto.setCourseId(courseId);
    Courses course = educationMapper.convertToEntity(courseDto);
    coursesRepository.save(course);
  }

}
