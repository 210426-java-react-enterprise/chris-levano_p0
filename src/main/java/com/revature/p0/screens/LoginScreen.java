package com.revature.p0.screens;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.AppUser;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;

/**
 * Prompts the user for login credentials, reading it in with BufferedReader
 * after they are given they will proceed to the dashboard
 */
public class LoginScreen extends Screen {

    private UserDAO userDao = new UserDAO();
    private BufferedReader consoleReader;
    private ScreenRouter router;

    /**
     * Establishes the name and route for the router as well as invoking router so the system can navigate go to
     * the dashboard from this one
     * @param consoleReader
     * @param router
     */
    public LoginScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    /**
     * Invocation of the render method from Screen that is extended. Prompts the user for their login details and handles
     * any errors made by the user by reseting itself
     */
    public void render() {

        try {
            String username;
            String password;

            System.out.println("Log into your account!");
            System.out.println("+---------------------+");

            System.out.print("Username: ");
            username = consoleReader.readLine();

            System.out.print("Password: ");
            password = consoleReader.readLine();

            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                AppUser authenticatedUser = userDao.findUserByUsernameAndPassword(username, password);
                if (authenticatedUser != null) {
                    System.out.println("Login successful!");
                    router.navigate("/dashboard");
                } else {
                    System.out.println("Login failed! Please try again!");
                    router.navigate("/login");
                }
            } else {
                System.out.println("It looks like you didn't provide any credentials! Please try again!");
                router.navigate("/login");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again!");
        }
    }
}
