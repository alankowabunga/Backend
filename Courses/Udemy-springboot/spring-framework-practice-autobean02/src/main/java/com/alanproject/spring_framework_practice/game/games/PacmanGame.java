package com.alanproject.spring_framework_practice.game.games;

import com.alanproject.spring_framework_practice.game.GamingConsole;
import org.springframework.stereotype.Component;

/*@Component:
用於將 Java 類標註為 Spring 容器管理的 Bean。這使得 Spring 容器可以自動檢測這些類並將它們注入到需要它們的其他 Bean 中。
Spring 還提供了其他專門的註解，如 @Service、@Repository 和 @Controller，它們都是 @Component 的特殊化版本，針對具體場景進行了命名。
* */
@Component
public class PacmanGame implements GamingConsole {

    public void up(){
        System.out.println(" # pacman up ");
    }

    public void down(){
        System.out.println(" # pacman down");
    }
}
