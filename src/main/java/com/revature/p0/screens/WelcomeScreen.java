package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;
import static com.revature.p0.Driver.app;

import java.io.BufferedReader;

/**
 * Displays a variety of options available to the user, either bringing them to a separate screen or exiting the app.
 * Choice read in by BufferedReader
 */
public class WelcomeScreen extends Screen {

    private BufferedReader consoleReader;
    private ScreenRouter router;

    /**
     * Establishes the name and route for the router as well as invoking router so the user can navigate to other screens
     * from this one
     * @param consoleReader
     * @param router
     */
    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    /**
     * Shows the user the options to log in, register or close the app.
     */
    @Override
    public void render() {

        System.out.println("Welcome to the 47th Bank of Neverland!");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit application");

        try {
            System.out.print("> ");
            String userSelection = consoleReader.readLine();

            switch (userSelection) {
                case "1":
                    System.out.println("Navigating to login screen");
                    router.navigate("/login");
                    break;
                case "2":
                    System.out.println("Navigating to register screen");
                    router.navigate("/register");
                    break;
                case "3":
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
