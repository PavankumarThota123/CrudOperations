package com.example.demoForJpa.conntroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demoForJpa.studentDto.StudentDTO;
import com.example.demoForJpa.response.ApiResp;
import com.example.demoForJpa.service.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ApiResp getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return new ApiResp("Success", "All Student Details", students);
    }

    @GetMapping("/students/{id}")
    public ApiResp getStudentById(@PathVariable("id") long id) {
        StudentDTO studentDto = studentService.getStudentById(id);
        return new ApiResp("Success", "Student details found successfully", studentDto);
    }

    @PostMapping("/students")
    public ApiResp createStudent(@RequestBody StudentDTO studentDto) {
        StudentDTO createdStudent = studentService.createStudent(studentDto);
        return new ApiResp("Success", "Student details created", createdStudent);
    }

    @PutMapping("/students/{id}")
    public ApiResp updateStudent(@PathVariable("id") long id, @RequestBody StudentDTO studentDto) {
        StudentDTO updatedStudent = studentService.saveOrUpdate(id, studentDto);
        return new ApiResp("Success", "Student details updated successfully", updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ApiResp deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ApiResp("Success", "Successfully deleted record", null);
    }
}
