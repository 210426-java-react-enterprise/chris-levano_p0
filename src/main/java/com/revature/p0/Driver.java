package com.revature.p0;

import com.revature.p0.util.AppState;

/**
 *Driving method, everything will start here.
 */
public class Driver {

    private static AppState app = new AppState();

    /**
     * Starts the app and boots to the welcome screen
     * @param args
     */
    public static void main(String[] args) {
        while (app.isAppRunning()) {
            app.getRouter().navigate("/welcome");
        }
    }

    /**
     * checks the appstate
     * @return
     */
    public static AppState app() {
        return app;
    }

}
