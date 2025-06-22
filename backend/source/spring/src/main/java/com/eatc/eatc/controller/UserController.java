package com.eatc.eatc.controller;

//import com.eatc.dto.UserDto;
//import com.eatc.mapper.UserMapper;
import com.eatc.eatc.dto.UserDto;
import com.eatc.eatc.mapper.UserMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userMapper.findAllUsers();
    }
}
