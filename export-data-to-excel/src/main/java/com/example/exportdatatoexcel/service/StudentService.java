package com.example.exportdatatoexcel.service;

import com.example.exportdatatoexcel.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getTheListStudent();
}
