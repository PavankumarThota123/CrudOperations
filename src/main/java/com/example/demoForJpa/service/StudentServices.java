package com.example.demoForJpa.service;

import java.util.List;

import com.example.demoForJpa.studentDto.StudentDTO;

public interface StudentServices {

    StudentDTO createStudent(StudentDTO studentDto);

    StudentDTO getStudentById(Long id);

    StudentDTO saveOrUpdate(Long id, StudentDTO studentDto);

    List<StudentDTO> getAllStudents();

    void deleteStudent(Long id);
}
