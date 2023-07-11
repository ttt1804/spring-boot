package com.example.uploadanddisplayimages.respository;

import com.example.uploadanddisplayimages.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
