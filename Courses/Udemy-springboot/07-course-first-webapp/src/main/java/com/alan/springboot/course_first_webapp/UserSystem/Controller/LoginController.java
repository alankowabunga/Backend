package com.alan.springboot.course_first_webapp.UserSystem.Controller;

import com.alan.springboot.course_first_webapp.UserSystem.Service.AuthService;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/*
=> obsolete
* 已改用 spring security 預設的登入畫面
* */
@Controller
//@RequestMapping("course")
@SessionAttributes("username")
// 因為在 loginpage 將 username 儲存在 session，welcomepage 也可以使用。
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private AuthService authService = new AuthService();

    @GetMapping("loginPage")
    public String LoginPage(@RequestParam("user") String username, ModelMap modelMap){
        if(StringUtils.isNotBlank(username)){
            modelMap.put("username",username);
            logger.info("@ info: User is {}",username);
        }
        return "LoginPage";
    }

    @PostMapping("loginPage")
    public String WelcomePage(@RequestParam("account") String account,@RequestParam("password") String password,ModelMap modelMap){

        boolean valid = authService.check(account,password);

        if(!valid){
            modelMap.put("errorMessage","Invalid Credential. Please try again.");
            return "LoginPage";
        }
        return "WelcomePage";
    }

}
