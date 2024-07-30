package com.alanproject.spring_framework_practice.game;

import com.alanproject.spring_framework_practice.game.games.PacmanGame;

public class AppGameBasic {
    public static void main(String[] args){

//        GameRunner 類的構造函數接受一個 GamingConsole 類型的參數，並將其賦值給 game 屬性。這意味著任何實現了 GamingConsole 介面的類都可以作為參數傳遞給 GameRunner 的構造函數。
//        MarioGame marioGame = new MarioGame();
//        SuperContraGame superGame = new SuperContraGame();
        PacmanGame pacmanGame = new PacmanGame(); // 1. Object creation
        GameRunner gameRunner = new GameRunner(pacmanGame);
        /* 2. Object is a dependency of GameRunner
        * */
        gameRunner.run();
    }
}
