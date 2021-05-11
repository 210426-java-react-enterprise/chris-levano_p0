package com.revature.p0.screens;

import com.revature.p0.models.AppUser;
import com.revature.p0.util.ScreenRouter;
import com.revature.p0.daos.AccountsDAO;
import java.io.BufferedReader;

import static com.revature.p0.Driver.app;

public class BalanceScreen extends Screen {
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public BalanceScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("BalanceScreen", "/balance");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    @Override
    public void render() {
        System.out.println("Your balance is: ");
        System.out.println("$" + AccountsDAO.fetchBalance(AppUser.getId()));
        System.out.println("1) Back to dashboard?");
        System.out.println("2) Exit application");

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


