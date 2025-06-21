package com.eatc.eatc.dto;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class UserDto {
    private int userId;
    private String loginId;
    private String password;
    private String name;
    private String phone;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
}
