package com.estsoft.springmvc.Service;

import com.estsoft.springmvc.DTO.AddUserRequest;
import com.estsoft.springmvc.repository.UserRepository;
import com.estsoft.springmvc.user.domain.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //실질적인 회원가입 처리
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Users save(AddUserRequest dto){
        String password = dto.getPassword();
        String email = dto.getEmail();
        String encodedPassword = encoder.encode(password);

        Users users = new Users(email, encodedPassword);
        return repository.save(users);
    }
}
