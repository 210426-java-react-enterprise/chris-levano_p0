package com.revature.p0.util;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Instantiates all the necessary screens as well as the BufferedReader, and router. Also has a bool 'AppRunning' that
 * when set to false will end the program
 */
public class AppState {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean appRunning;

    /**
     * Initializes router, all screens and the routes to reach them
     */
    public AppState() {
        System.out.println("Initializing application...");

        appRunning = true;
        consoleReader = new BufferedReader(new InputStreamReader(System.in));

        final UserDAO userDao = new UserDAO();

        router = new ScreenRouter();
        router.addScreen(new WelcomeScreen(consoleReader, router))
                 .addScreen(new LoginScreen(consoleReader, router))
                 .addScreen(new RegisterScreen(consoleReader))
                 .addScreen(new DashboardScreen(consoleReader, router))
                 .addScreen(new BalanceScreen(consoleReader, router))
                 .addScreen(new DepositScreen(consoleReader, router))
                 .addScreen(new WithdrawalScreen(consoleReader, router))
                 .addScreen(new TransactionsScreen(consoleReader, router));


        System.out.println("Starting up...");
    }

    /**
     * @return returns the present router
     */
    public ScreenRouter getRouter() {
        return router;
    }

    /**
     * @return appRunning
     */
    public boolean isAppRunning() {
        return appRunning;
    }

    /**
     * When false is fed in the program will terminate
     * @param appRunning
     */
    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

}
