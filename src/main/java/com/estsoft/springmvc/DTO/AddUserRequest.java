package com.estsoft.springmvc.DTO;

import lombok.Getter;
import lombok.Setter;

//회원가입시 입력받는 정보.
@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
}