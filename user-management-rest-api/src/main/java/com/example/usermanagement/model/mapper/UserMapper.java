package com.example.usermanagement.model.mapper;


import com.example.usermanagement.entity.User;
import com.example.usermanagement.model.dto.UserDto;
import com.example.usermanagement.model.request.CreateUserRequest;
import com.example.usermanagement.model.request.UpdateUserRequest;
import org.mindrot.jbcrypt.BCrypt;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        userDto.setAvatar(user.getAvatar());
        userDto.setEmail(user.getEmail());
        userDto.setBirthday(user.getBirthday());

        return userDto;
    }

    public static User toUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        String hash = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);
        user.setRole("USER");

        return user;
    }

    public static User toUser(UpdateUserRequest request, int id) {
        User user = new User();
        user.setId(id);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setAvatar(request.getAvatar());
        String hash = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);

        return user;
    }
}