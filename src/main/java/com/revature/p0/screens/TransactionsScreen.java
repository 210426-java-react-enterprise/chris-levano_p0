package com.revature.p0.screens;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.models.AppUser;
import com.revature.p0.util.ScreenRouter;
import java.io.BufferedReader;

import static com.revature.p0.Driver.app;

/**
 *  Will invoke the fetchBalance method for the current user, printing all their recorded transactions.
 *  Also gives the option to return to dash board or quit the app.
 *
 *@return
 */
public class TransactionsScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public TransactionsScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("TransactionsScreen", "/trans");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    public void render() {

        System.out.println("Transactions: ");
        AccountsDAO.fetchTransactions(AppUser.getId());
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



