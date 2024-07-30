package com.alan.springboot.course_first_webapp.UserSystem.Controller;

import com.alan.springboot.course_first_webapp.UserSystem.Service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Authenticator;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String goToWelcomePage(ModelMap modelMap){
        String username = new AuthService().getLoggedUser();
        modelMap.put("username",username);
        return "WelcomePage";
    }

    /*
    TODO:透過 Authentication 取得 security context 中的 user
    * */

}
