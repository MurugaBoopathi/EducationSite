package com.example.educationsite.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */

@Data
@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_id")
  private long studentId;
  private String firstName;
  private String lastName;

  @Column(unique = true)
  private String email;

  private String password;
  private String phone;
  private String address;

  @OneToMany(mappedBy = "msgHeaderEntity")
  private List<Courses> courses;

}
