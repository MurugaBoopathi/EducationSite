package com.example.educationsite.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {

  private long courseId;
  private String courseCode;
  private String courseName;
  private String description;
}
