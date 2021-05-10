package com.revature.p0;

import com.revature.p0.util.AppState;

public class Driver {

    private static AppState app = new AppState();

    public static void main(String[] args) {
        while (app.isAppRunning()) {
            app.getRouter().navigate("/welcome");
        }
    }

    public static AppState app() {
        return app;
    }

}
