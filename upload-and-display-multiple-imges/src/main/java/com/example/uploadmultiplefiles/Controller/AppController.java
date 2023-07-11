package com.example.uploadmultiplefiles.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.example.uploadmultiplefiles.Repository.CandidateRepository;
import com.example.uploadmultiplefiles.entity.Candidate;
import com.example.uploadmultiplefiles.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AppController {

    @Autowired
    private CandidateRepository candidateRepo;

    @GetMapping("candidates")
    public String getAllCandidates(Model model) {
        List<Candidate> candidates = candidateRepo.findAll();
        model.addAttribute("candidates", candidates);
        return "list";
    }

    @GetMapping("/upload")
    public String Upload(Model model){
        Candidate candidate = new Candidate();
        model.addAttribute("candicate", candidate);
        return "upload2";
    }

    @PostMapping("/upload_multiple")
    public String handleFormSubmit(Candidate candidate,
                                   @RequestParam("profilePictureFile") MultipartFile multipartFile1,
                                   @RequestParam("photoIdFile") MultipartFile multipartFile2,
                                   @RequestParam("documentFile") MultipartFile multipartFile3) throws IOException {

        String profilePictureFileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile1.getOriginalFilename()));
        String photoIdFileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile2.getOriginalFilename()));
        String documentFileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile3.getOriginalFilename()));

        candidate.setProfilePicture(profilePictureFileName);
        candidate.setPhotoId(photoIdFileName);
        candidate.setDocument(documentFileName);

        Candidate savedCandidate = candidateRepo.save(candidate);
        String uploadDir = "candidates/" + savedCandidate.getId();

        FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1);
        FileUploadUtil.saveFile(uploadDir, photoIdFileName, multipartFile2);
        FileUploadUtil.saveFile(uploadDir, documentFileName, multipartFile3);

        return "redirect:/candidates";
    }

    @PostMapping("/upload_multiple_2")
    public String handleFormSubmit(Candidate candidate, @RequestParam("files") MultipartFile[] multipartFiles) throws IOException {
        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            if (candidate.getProfilePicture() == null) {
                candidate.setProfilePicture(fileName);
                Candidate savedCandidate = candidateRepo.save(candidate);
                String uploadDir = "candidates/" + savedCandidate.getId();
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
                continue;
            }
            if (candidate.getPhotoId() == null) {
                candidate.setPhotoId(fileName);
                Candidate savedCandidate = candidateRepo.save(candidate);
                String uploadDir = "candidates/" + savedCandidate.getId();
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
                continue;
            }
            if (candidate.getDocument() == null) {
                candidate.setDocument(fileName);
                Candidate savedCandidate = candidateRepo.save(candidate);
                String uploadDir = "candidates/" + savedCandidate.getId();
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            }
        }

        return "redirect:/candidates";
    }



}