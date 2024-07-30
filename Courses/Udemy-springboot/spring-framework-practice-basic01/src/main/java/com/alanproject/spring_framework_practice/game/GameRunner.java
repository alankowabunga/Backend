package com.alanproject.spring_framework_practice.game;

public class GameRunner {
    GamingConsole game;

    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        System.out.println("@ Running game:"+game);
        game.up();
        game.down();
    }
}
