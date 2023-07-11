package com.ttt.validate_exception.service;

import com.ttt.validate_exception.dto.UserRequest;
import com.ttt.validate_exception.entity.User;
import com.ttt.validate_exception.exception.UserNotFoundException;
import com.ttt.validate_exception.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findUserByUserId(id);
        if(user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not find with id: " + id);
        }
    }

}
