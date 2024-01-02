package com.example.educationsite.controllers;

import static org.springframework.http.ResponseEntity.ok;
import com.example.educationsite.dtos.StudentDto;
import com.example.educationsite.entities.Student;
import com.example.educationsite.services.StudentService;
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
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;

  @PostMapping("/")
  public ResponseEntity<Student> registerStudent(
      @RequestBody final StudentDto requestDto) {
    log.info("To create or register the student using Student Controller class");
    Student result = studentService.createNewStudent(requestDto);

    return ok().body(result);
  }

  @GetMapping("/")
  public ResponseEntity<List<Student>> findAllStudent() {
    log.info("To retrieve all the students in Student Controller");
    final List<Student> studentResponse = studentService.getAllStudentList();

    return ok().body(studentResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteStudent(@PathVariable("id") long studentId) {
    log.info("To delete the specific student record using studentID in student controller class");
    studentService.deleteStudent(studentId);

    return ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateStudentRecord(
      @PathVariable("id") Long studentId,
      @RequestBody StudentDto studentDto) {
    log.info("To update the courses for particular student using studentId in Student Controller");
    studentService.updateStudentRecord(studentId, studentDto);

    return ok().build();
  }

}
