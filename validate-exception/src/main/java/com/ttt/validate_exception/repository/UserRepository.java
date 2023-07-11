package com.ttt.validate_exception.repository;

import com.ttt.validate_exception.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(int id);
}
