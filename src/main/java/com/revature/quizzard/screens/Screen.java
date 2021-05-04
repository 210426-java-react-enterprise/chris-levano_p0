package com.revature.quizzard.screens;

//Abstract because we don't want to ever make just a screen
public abstract class Screen {
    //fields are not implicitly public static or final in class


    //not implicitly public or abstract
    //then it doesn't need to have a body

    //the do have a constructor because of call to the super()
    //  (super or parent class constructor)

    public abstract void render();

}
