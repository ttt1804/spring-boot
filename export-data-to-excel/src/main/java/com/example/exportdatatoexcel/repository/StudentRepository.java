package com.example.exportdatatoexcel.repository;

import com.example.exportdatatoexcel.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
