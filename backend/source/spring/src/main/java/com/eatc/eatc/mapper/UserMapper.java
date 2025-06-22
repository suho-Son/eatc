package com.eatc.eatc.mapper;

import com.eatc.eatc.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user_table")
    List<UserDto> findAllUsers();
}
