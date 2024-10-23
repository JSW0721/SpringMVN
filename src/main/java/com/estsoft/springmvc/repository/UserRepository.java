package com.estsoft.springmvc.repository;

import com.estsoft.springmvc.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    //id값이 아닌 email 값으로 인증 정보 가져와야 함으로 관련 로직 처리
    //필요 쿼리 : select * from users where email = ${email};
    Optional<Users> findByEmail(String email);
}
