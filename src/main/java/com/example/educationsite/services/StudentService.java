package com.example.educationsite.services;

import com.example.educationsite.dtos.StudentDto;
import com.example.educationsite.entities.Student;
import com.example.educationsite.mappers.EducationMapper;
import com.example.educationsite.repositories.StudentRepository;
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
public class StudentService {

  private final StudentRepository studentRepository;
  private final EducationMapper educationMapper;

  public Student createNewStudent(StudentDto requestDto) {
    Student student = educationMapper.convertStudentDtoToEntity(requestDto);
    return studentRepository.save(student);
  }

  public List<Student> getAllStudentList() {
    log.info("Inside findAllStudent of Student Service");
    return studentRepository.findAll();
  }

  public void deleteStudent(Long studentId) {
    if (studentRepository.existsById(studentId)) {
      studentRepository.deleteById(studentId);
      log.info("Student Record deleted. Student id: {}", studentId);
    } else {
      log.info("Student Record not found. Student id: {}", studentId);
    }
  }

  public void updateStudentRecord(Long studentId, StudentDto studentDto) {
    studentDto.setStudentId(studentId);
    Student student = educationMapper.convertStudentDtoToEntity(studentDto);
    studentRepository.save(student);
  }
}
