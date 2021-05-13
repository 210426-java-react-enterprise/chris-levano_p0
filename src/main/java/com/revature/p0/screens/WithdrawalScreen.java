package com.revature.p0.screens;

import com.revature.p0.services.AccountService;
import com.revature.p0.util.ScreenRouter;
import java.io.BufferedReader;

/**
 * Prompts the user for a withdrawal amount, reading it in with BufferedReader
 * after it is given they will return to the dashboard
 */
public class WithdrawalScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    /**
     * Establishes the name and route for the router as well as invoking router so the system can navigate back to
     * the dashboard from this one
     * @param consoleReader
     * @param router
     */
    public WithdrawalScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WithdrawalScreen", "/withdrawal");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    /**
     * Invocation of the render method from Screen that is extended. Lets the user input an amount for withdrawal and
     * navigates back to dash
     */
    public void render() {


        System.out.println("How much would you like to withdraw? : ");

        try {
            System.out.print("$");
            double withdraw_am = Double.parseDouble(consoleReader.readLine());
            AccountService.withdrawVerify(withdraw_am);
            System.out.println("Navigating to dashboard");
            router.navigate("/dashboard");

        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again!");
        }

    }
}
