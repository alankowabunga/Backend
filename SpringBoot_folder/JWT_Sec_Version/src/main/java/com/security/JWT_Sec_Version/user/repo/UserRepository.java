package com.security.JWT_Sec_Version.user.repo;

import com.security.JWT_Sec_Version.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
