package com.example.educationsite.mappers;

import com.example.educationsite.dtos.CourseDto;
import com.example.educationsite.dtos.StudentDto;
import com.example.educationsite.entities.Courses;
import com.example.educationsite.entities.Student;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */
public interface EducationMapper {

  Courses convertToEntity(CourseDto courseDto);

  Student convertStudentDtoToEntity(StudentDto studentDto);

}
