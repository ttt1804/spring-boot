package com.example.uploadimportexcelfile.service;


import com.example.uploadimportexcelfile.helper.ExcelHelper;
import com.example.uploadimportexcelfile.model.Tutorial;
import com.example.uploadimportexcelfile.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelService {

    private final TutorialRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }
}