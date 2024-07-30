package com.alanproject.spring_framework_practice.game.games;

import com.alanproject.spring_framework_practice.game.GamingConsole;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {
    public void up(){
        System.out.println(" @ mario up ");
    }

    public void down(){
        System.out.println(" @ mario down ");
    }
}
