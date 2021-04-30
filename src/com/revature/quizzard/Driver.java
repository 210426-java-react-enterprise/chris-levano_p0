package com.revature.quizzard;

import com.revature.quizzard.models.AppUser;
import com.revature.quizzard.screens.RegisterScreen;
import com.revature.quizzard.screens.LoginScreen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Driver {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        AppUser newUser = new AppUser("wsingleton", "p4ssw0rd",
                "wezley.singleton@revature.com",
                "Wezley", "Singleton", 30);

        int userInput;

        System.out.print("1. Registration\n" +
                "2. Login\n" +
                "Please select: ");
        Scanner scan = new Scanner(System.in);
        userInput = scan.nextInt();

        switch (userInput) {
            case 1:
                try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
                    RegisterScreen registerScreen = new RegisterScreen(consoleReader);
                    registerScreen.render();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try{
                    LoginScreen.render();
                } catch (Exception e) {

            }
                break;
            default:
                System.out.println("try again");
        }




        scan.close(); // close System.in Scanner
    }
}
