package com.revature.quizzard;

import com.revature.quizzard.models.AppUser;
import com.revature.quizzard.screens.LoginScreen;
import com.revature.quizzard.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        AppUser newUser = new AppUser("wsingleton", "p4ssw0rd",
                "wezley.singleton@revature.com",
                "Wezley", "Singleton", 30);

        File dataFile = new File("resources/users.txt");

        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Register");
        System.out.println("Press 3 to Exit");

        //Scanner scan = new Scanner(System.in);//scanner makes situation worse
        //String inputNum = scan.next();
        //scan.close();

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            int inputNum;
            //inputNum = consoleReader.read();//be careful, it hasn't finished reading the line

            String temp;
            temp = consoleReader.readLine();//now line is read
            inputNum = temp.charAt(0);

            //System.out.println("You inputted: " + inputNum);

            switch ((char)inputNum) {
                case '1':
                    LoginScreen lScreen = new LoginScreen(consoleReader);
                    lScreen.CheckForUser(dataFile);
                    break;
                case '2':
                    RegisterScreen rScreen = new RegisterScreen(consoleReader);
                    rScreen.render();
                    break;
                case '3':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input.  Exiting...");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}