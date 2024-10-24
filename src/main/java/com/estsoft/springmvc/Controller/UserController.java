package com.estsoft.springmvc.Controller;

import com.estsoft.springmvc.DTO.AddUserRequest;
import com.estsoft.springmvc.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //POST /user 요청 받고 회원가입 처리
    @PostMapping("/user")
    public String save(@ModelAttribute AddUserRequest requ) {
        userService.save(requ);
        return "redirect:/login";
    }

}
