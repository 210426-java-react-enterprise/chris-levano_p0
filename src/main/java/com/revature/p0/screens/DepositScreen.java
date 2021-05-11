package com.revature.p0.screens;

import com.revature.p0.services.AccountService;
import com.revature.p0.util.ScreenRouter;
import java.io.BufferedReader;

public class DepositScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public DepositScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("DepositScreen", "/deposit");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    public void render() {

        System.out.println("How much would you like to deposit? : ");

        try {
            System.out.print("$");
            double deposit_am = Double.parseDouble(consoleReader.readLine());
            AccountService.depositVerify(deposit_am);
            System.out.println("Navigating to dashboard");
            router.navigate("/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



