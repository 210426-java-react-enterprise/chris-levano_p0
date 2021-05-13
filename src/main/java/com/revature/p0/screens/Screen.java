package com.revature.p0.screens;

/**
 * Super class extended by all of the screens, gives them names to be called by as well as giving them the
 * ability to call other screens and garuntees they will have render()
 */
public abstract class Screen {

    protected String name;
    protected String route;

    public Screen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();

}
