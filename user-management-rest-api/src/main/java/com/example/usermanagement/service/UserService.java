package com.example.usermanagement.service;

import com.example.usermanagement.model.dto.UserDto;
import com.example.usermanagement.model.request.CreateUserRequest;
import com.example.usermanagement.model.request.UpdateUserRequest;

import java.util.List;

public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public UserDto createUser(CreateUserRequest req);

    public UserDto updateUser(UpdateUserRequest req, int id);

    public void deleteUser(int id);
}