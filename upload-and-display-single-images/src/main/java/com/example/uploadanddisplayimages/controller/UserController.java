package com.example.uploadanddisplayimages.controller;

import com.example.uploadanddisplayimages.entity.User;
import com.example.uploadanddisplayimages.respository.UserRepository;
import com.example.uploadanddisplayimages.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("users")
    public String getAllUsers(Model model) {
        List<User> users = repo.findAll();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/upload")
    public String Upload(){
        return "upload";
    }

    @PostMapping("/users/save")
    public RedirectView saveUser(User user,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        user.setPhotos(fileName);

        User savedUser = repo.save(user);

        String uploadDir = "user-photos/" + savedUser.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/users", true);
    }
}