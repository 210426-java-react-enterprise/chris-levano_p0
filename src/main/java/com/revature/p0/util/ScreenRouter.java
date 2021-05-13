package com.revature.p0.util;

import com.revature.p0.screens.Screen;

/**
 * Creates and and switches between screens
 */
public class ScreenRouter {

    private LinkedList<Screen> screens = new LinkedList<>();

    /**
     * adds the requested screen to the stack and returns it
     * @param screen
     * @return
     */
    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    /**
     * Uses the declared routes to access the requested screen
     * @param route
     */
    public void navigate(String route) {
        for (int i = 0; i < screens.size(); i++) {
            Screen screen = screens.get(i);
            if (screen.getRoute().equals(route)) {
                screen.render();
            }
        }
    }

}
