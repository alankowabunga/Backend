package com.alanproject.spring_framework_practice.game.games;

import com.alanproject.spring_framework_practice.game.GamingConsole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperQualifier")
public class SuperContraGame implements GamingConsole {

    public void up(){
        System.out.println(" @ contra up ");
    }

    public void down(){
        System.out.println(" @ contra down ");
    }
}
