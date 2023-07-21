package com.example.uploadimportexcelfile.repository;

import com.example.uploadimportexcelfile.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
}
