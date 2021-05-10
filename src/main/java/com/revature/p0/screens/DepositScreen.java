package com.revature.p0.screens;


import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.models.AppUser;
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
    @Override
    public void render() {

        System.out.println("How much would you like to deposit? : ");

        try {
            System.out.print("> ");
            double deposit_am = Double.parseDouble(consoleReader.readLine());
            AccountsDAO.deposit(AppUser.getId(), deposit_am);
            System.out.println("Navigating to dashboard");
            router.navigate("/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



