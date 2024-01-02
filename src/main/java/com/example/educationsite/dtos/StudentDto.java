package com.example.educationsite.dtos;

import com.example.educationsite.entities.Courses;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MPI2COB
 * @Date 1/2/2024
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {

  private long studentId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  private String address;
  private List<Courses> courses;
}
