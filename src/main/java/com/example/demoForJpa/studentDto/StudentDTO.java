package com.example.demoForJpa.studentDto;

public class StudentDTO {

    private Long id;
    private String studentName;
    private String emailId;
    private String address;

    public StudentDTO() {}

    public StudentDTO(Long id, String studentName, String emailId, String address) {
        this.id = id;
        this.studentName = studentName;
        this.emailId = emailId;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
