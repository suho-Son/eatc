package com.eatc.eatc.mapper;

import com.eatc.eatc.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user_table")
    List<UserDto> findAllUsers();

    @Select("SELECT * FROM user_table WHERE login_id = #{loginId} AND password = #{password}")
    UserDto findByLogin(@Param("loginId") String loginId, @Param("password") String password);

    @Select("SELECT * FROM user_table WHERE user_id = #{id}")
    UserDto findById(@Param("id") int id);

    @Update("UPDATE user_table SET login_id = #{loginId}, password = #{password}, name = #{name}, phone = #{phone}, email = #{email}, updated_at = CURRENT_TIMESTAMP, status = #{status} WHERE user_id = #{userId}")
    int updateUser(UserDto userDto);
}
