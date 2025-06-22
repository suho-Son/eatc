package com.eatc.eatc.mapper;

import com.eatc.eatc.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user_table")
    List<UserDto> findAllUsers();

    @Select("SELECT * FROM user_table WHERE login_id = #{loginId} AND password = #{password}")
    UserDto findByLogin(@Param("loginId") String loginId, @Param("password") String password);
}
