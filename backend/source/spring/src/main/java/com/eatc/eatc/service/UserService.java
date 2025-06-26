package com.eatc.eatc.service;

import com.eatc.eatc.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto login(String loginId, String password);

    UserDto getUserById(int userId);

    void updateUser(UserDto userDto);
}
