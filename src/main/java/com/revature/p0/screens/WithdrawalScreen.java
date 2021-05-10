package com.revature.p0.screens;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.models.AppUser;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;

public class WithdrawalScreen extends Screen{
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public WithdrawalScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WithdrawalScreen", "/withdrawal");
        this.consoleReader = consoleReader;
        this.router = router;
    }
    @Override
    public void render() {


        System.out.println("How much would you like to withdraw? : ");

        try {
            System.out.print("> ");
            double withdraw_am = Double.parseDouble(consoleReader.readLine());
            AccountsDAO.withdraw(AppUser.getId(), withdraw_am);
            System.out.println("Navigating to dashboard");
            router.navigate("/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
