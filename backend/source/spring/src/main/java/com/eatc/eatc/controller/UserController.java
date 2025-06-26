package com.eatc.eatc.controller;

import com.eatc.eatc.dto.UserDto;
// import com.eatc.eatc.dto.LoginRequest;
import com.eatc.eatc.service.UserService;
import org.springframework.beans.factory.annotation.Value;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
public class UserController {

    private final UserService userService;
    @Value("${app.paths.users}")
    private String usersPath;
    @Value("${app.paths.user-edit}")
    private String userEditPath;
    @Value("${app.paths.user-update}")
    private String userUpdatePath;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 홈 페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // REST API 엔드포인트는 주석 처리
    /*
    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
        UserDto user = userService.login(request.getLoginId(), request.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    */

    // 사용자 목록 페이지 출력
    @GetMapping("${app.paths.users}")
    public String users(Model model) {
        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("userEditPath", userEditPath);
        return "users";
    }

    // 사용자 수정 페이지
    @GetMapping("${app.paths.user-edit}")
    public String editUserForm(@PathVariable("id") int id, Model model) {
        UserDto user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("userUpdatePath", userUpdatePath);
        return "user_edit";
    }

    // 사용자 정보 수정
    @PutMapping("${app.paths.user-update}")
    public String updateUser(@PathVariable("id") int id, UserDto userDto) {
        userDto.setUserId(id);
        userService.updateUser(userDto);
        return "redirect:" + usersPath;
    }
}
