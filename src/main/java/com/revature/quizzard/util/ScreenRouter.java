package com.revature.quizzard.util;

import com.revature.quizzard.screens.Screen;

public class ScreenRouter {
    private LinkedList<Screen> screens = new LinkedList<>();

    //sudoe implimentatin of the builder pattern
    public ScreenRouter addScreen(Screen screen){
        //navigating individual screens
        screens.add(screen);
        return this;
    }

    public void nagivate(String route){

        for (int i = 0; i < screens.size(); i++) {
            Screen screen = screens.get(i)
            if(screen.getRoute().equals((route))){
                screen.render();
            }
        }
    }
}
