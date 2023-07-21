package com.example.exportdatatoexcel.service.impl;

import com.example.exportdatatoexcel.entity.Student;
import com.example.exportdatatoexcel.repository.StudentRepository;
import com.example.exportdatatoexcel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getTheListStudent() {
        return studentRepository.findAll();
    }
}
