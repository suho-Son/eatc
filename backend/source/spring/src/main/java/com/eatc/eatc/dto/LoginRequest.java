package com.eatc.eatc.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String password;
}
