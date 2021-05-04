package com.revature.quizzard.screens;

import java.io.BufferedReader;

public class WelcomeScreen extends Screen{
    public WelcomeScreen(BufferedReader consoleReader){
        super("WelcomeScreen", "/welcome");
        this.consoleReader = consoleReader;
    }

    @Override
    public void render(){

    }
}
