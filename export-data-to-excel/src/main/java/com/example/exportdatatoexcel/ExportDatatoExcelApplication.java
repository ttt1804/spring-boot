package com.example.exportdatatoexcel;

import com.example.exportdatatoexcel.entity.Student;
import com.example.exportdatatoexcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExportDatatoExcelApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {

        SpringApplication.run(ExportDatatoExcelApplication.class, args);
    }
    @Override
    public void run(String...a) {
        for (int i = 0; i <= 10; i++) {
            Student student = new Student();
            student.setStudentName("Student " + i);
            student.setEmail("student"+i+"@mail.com");
            student.setMobileNo("XXXXXXXXXX");
            studentService.addStudent(student);
        }
    }
}