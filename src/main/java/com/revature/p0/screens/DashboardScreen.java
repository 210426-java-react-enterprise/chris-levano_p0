package com.revature.p0.screens;


import com.revature.p0.util.ScreenRouter;
import java.io.BufferedReader;

import static com.revature.p0.Driver.app;

/**
 * Displays a variety of options available to the user, either bringing them to a separate screen or exiting the app.
 * Choice read in by BufferedReader
 */
public class DashboardScreen extends Screen{

    private BufferedReader consoleReader;
    private ScreenRouter router;

    /**
     * Establishes the name and route for the router as well as invoking router so the user can navigate to other screens
     * from this one
     * @param consoleReader
     * @param router
     */
    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("DashboardScreen", "/dashboard");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    /**
     * Invocation of the render method from Screen that is extended. Lets the user choose
     * what to do from here, either view balance or transactions, make deposit or withdrawal
     * or terminate the app
     */
    public void render() {

        System.out.println("Welcome to your account!");
        System.out.println("1) Check balance");
        System.out.println("2) View transaction history");
        System.out.println("3) Withdraw");
        System.out.println("4) Deposit");
        System.out.println("5) Exit application");

        try{
            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to balance screen");
                    router.navigate("/balance");
                    break;
                case "2":
                    System.out.println("Navigating to transaction history");
                    router.navigate("/trans");
                    break;
                case "3":
                    System.out.println("Navigating to withdrawal window");
                    router.navigate("/withdrawal");
                    break;
                case "4":
                    System.out.println("Navigating to deposit window");
                    router.navigate("/deposit");
                    break;
                case "5":
                    System.out.println("Exiting application!");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid selection! Please try again!");
            }

        } catch (Exception e){
            System.out.println("Something went wrong! Please try again!");
        }


    }
}
