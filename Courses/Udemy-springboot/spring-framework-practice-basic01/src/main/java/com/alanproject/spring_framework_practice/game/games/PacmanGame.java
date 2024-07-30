package com.alanproject.spring_framework_practice.game.games;

import com.alanproject.spring_framework_practice.game.GamingConsole;

public class PacmanGame implements GamingConsole {

    public void up(){
        System.out.println(" # pacman up ");
    }

    public void down(){
        System.out.println(" # pacman down");
    }
}
