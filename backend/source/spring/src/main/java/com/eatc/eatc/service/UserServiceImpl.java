package com.eatc.eatc.service;

import com.eatc.eatc.dto.UserDto;
import com.eatc.eatc.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public UserDto login(String loginId, String password) {
        return userMapper.findByLogin(loginId, password);
    }
}
