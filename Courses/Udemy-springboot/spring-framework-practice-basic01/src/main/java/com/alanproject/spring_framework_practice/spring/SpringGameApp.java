package com.alanproject.spring_framework_practice.spring;

import com.alanproject.spring_framework_practice.game.GameRunner;
import com.alanproject.spring_framework_practice.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringGameApp {
    public static void main(String[] args){

        //create spring context w/ config class
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfig.class)){

//            context.getBean(GamingConsole.class).up(); test

            /*配置中，gameRunner 方法中的參數 GamingConsole game 會由 Spring 自動注入。因為在 Spring 容器中已經有一個 GamingConsole 類型的 Bean，即 pacmanGame，所以 Spring 會將 PacmanGame 的實例注入到 gameRunner Bean 中。
            * */
            context.getBean(GameRunner.class).run();
        }
    }
}
