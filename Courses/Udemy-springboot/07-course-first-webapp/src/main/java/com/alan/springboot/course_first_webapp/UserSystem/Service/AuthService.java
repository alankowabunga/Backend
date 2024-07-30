package com.alan.springboot.course_first_webapp.UserSystem.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean check(String account, String password) {
        boolean valid = true;

        if (!"alan".equalsIgnoreCase(account) || !"123".equalsIgnoreCase(password)) {
            valid = false;
        }

        return valid;
    }

    public String getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return username;
    }
}
