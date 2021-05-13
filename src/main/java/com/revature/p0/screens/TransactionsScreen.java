package com.revature.p0.screens;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.models.AppUser;
import com.revature.p0.util.ScreenRouter;
import java.io.BufferedReader;

import static com.revature.p0.Driver.app;

/**
 * Displays the current users transaction history and gives the option to quit the app or return to dashboard using the bufferedReader
 * This screen is accessible through the dashboard
 */
public class TransactionsScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    /**
     * Establishes the name and route for the router as well as invoking router so the user can navigate to other screens
     * from this one
     * @param consoleReader
     * @param router
     */
    public TransactionsScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("TransactionsScreen", "/trans");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    /**
     * Invocation of the render method from Screen that is extended. Lets the user choose
     * what to do after seeing their transactions
     */
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
                    System.out.println("Invalid selection! Please try again!");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again!");
        }

    }
}



