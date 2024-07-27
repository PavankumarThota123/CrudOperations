package com.example.demoForJpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoForJpa.entity.Student;
import com.example.demoForJpa.exception.StudentNotFoundException;
import com.example.demoForJpa.repo.StudentRepo;
import com.example.demoForJpa.studentDto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentServices {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        Student createdStudent = studentRepo.save(student);
        StudentDTO responseDTO = new StudentDTO();
        BeanUtils.copyProperties(createdStudent, responseDTO);
        return responseDTO;
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        StudentDTO studentDto = new StudentDTO();
        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }

    @Override
    public StudentDTO saveOrUpdate(Long id, StudentDTO studentDto) {
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        BeanUtils.copyProperties(studentDto, student);
        student.setId(id);
        Student updatedStudent = studentRepo.save(student);
        StudentDTO responseDTO = new StudentDTO();
        BeanUtils.copyProperties(updatedStudent, responseDTO);
        return responseDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(student -> {
            StudentDTO studentDto = new StudentDTO();
            BeanUtils.copyProperties(student, studentDto);
            return studentDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepo.existsById(id)) {
            throw new StudentNotFoundException("Student Not Found");
        }
        studentRepo.deleteById(id);
    }
}
