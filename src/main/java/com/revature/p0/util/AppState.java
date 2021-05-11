package com.revature.p0.util;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private BufferedReader consoleReader;
    private ScreenRouter router;
    private boolean appRunning;

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


        System.out.println("Application initialized!");
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public boolean isAppRunning() {
        return appRunning;
    }

    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

}
