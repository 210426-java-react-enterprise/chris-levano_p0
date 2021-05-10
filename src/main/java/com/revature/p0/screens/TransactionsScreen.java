package com.revature.p0.screens;


import com.revature.p0.util.ScreenRouter;
import java.io.BufferedReader;

import static com.revature.p0.Driver.app;

public class TransactionsScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public TransactionsScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("TransactionsScreen", "/transactions");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    @Override
    public void render() {

        System.out.println("Transactions in the past 90 days: ");

        try {
            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to dashboard");
                    router.navigate("/dashboard");
                    break;
                case "2":
                    System.out.println("Exiting application!");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid selection!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



