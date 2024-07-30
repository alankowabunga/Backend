package com.alanproject.spring_framework_practice.spring;

import com.alanproject.spring_framework_practice.game.GameRunner;
import com.alanproject.spring_framework_practice.game.GamingConsole;
import com.alanproject.spring_framework_practice.game.games.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
減少大量程式、並讓 Spring auto-wiring 減少手動設置 Bean 等設定:
1. 將原先的 configuration class 直接合併到 app file 中
2. 讓 Spring 自動幫我們建立 PacmanGame Bean: 將 PacmanGame class 設置為 @Component
 @ComponentScan(”{package_path}”) : 使用 package path 找到 Bean 的位置
* */
@Configuration
@ComponentScan(basePackages = {"com.alanproject.spring_framework_practice.game",
        "com.alanproject.spring_framework_practice.game.games"})
public class SpringGameApp {
    //    @Bean
//    public GamingConsole pacmanGame(){
//        return new PacmanGame();
//    }
//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        return new GameRunner(game);
//    }
    public static void main(String[] args) {
        //create spring context w/ config class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringGameApp.class)) {

            /*配置中，gameRunner 方法中的參數 GamingConsole game 會由 Spring 自動注入。因為在 Spring 容器中已經有一個 GamingConsole 類型的 Bean，即 pacmanGame，所以 Spring 會將 PacmanGame 的實例注入到 gameRunner Bean 中。
             * */
            context.getBean(GameRunner.class).run();
        }
    }
}
