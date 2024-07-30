package com.alanproject.spring_framework_practice.game.games;

import com.alanproject.spring_framework_practice.game.GamingConsole;

public class SuperContraGame implements GamingConsole {

    public void up(){
        System.out.println(" @ contra up ");
    }

    public void down(){
        System.out.println(" @ contra down ");
    }
}
