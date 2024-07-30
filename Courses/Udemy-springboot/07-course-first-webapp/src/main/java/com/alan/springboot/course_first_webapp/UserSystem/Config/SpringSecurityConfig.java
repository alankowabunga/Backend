package com.alan.springboot.course_first_webapp.UserSystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfig {

    /*
     * 1. userDetailsService
     * 2. securityFilterChain
     * */


    /*
     * 要讓 Spring 自動設置用戶，你需要將 createUser 方法返回一個 InMemoryUserDetailsManager 實例並將其標記為一個 @Bean。
     * 小心 Bean 註解的 modifier must be "public"
     * */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = createUser("alan", "123", "ADMIN");
        UserDetails user2 = createUser("tanya", "456", "USER");
        UserDetails user3 = createUser("nobody", "789", "USER,ADMIN");
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
    private UserDetails createUser(String username, String password, String role) {
        Function<String, String> encodeFunction = pwd -> passwordEncoder().encode(pwd);
        return User.builder()
                .passwordEncoder(encodeFunction)
                .username(username)
                .password(password)
                .roles(role)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.formLogin(Customizer.withDefaults());

        /*
        禁用了 CSRF 保護。這通常用於開發環境或需要特定配置的 API，但是在生產環境中通常應保持 CSRF 保護。
        * */
        http.csrf(
                csrf -> csrf.disable()
        );
        /*
        這段代碼禁用了 X-Frame-Options 標頭，允許在 iframe 中顯示頁面。這在使用 H2 控制台等場景中很常見。
        * */
        http.headers(
                header -> header
                        .frameOptions(frameoption -> frameoption.disable())
        );

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .antMatchers("/admin/**").hasRole("ADMIN")
//                                .antMatchers("/user/**").hasRole("USER")
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login")
//                                .permitAll()
//                )
//                .httpBasic();
//        return http.build();
//    }
}
