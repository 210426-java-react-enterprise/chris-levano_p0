package com.revature.quizzard;

import com.revature.quizzard.models.AppUser;
import com.revature.quizzard.screens.LoginScreen;
import com.revature.quizzard.screens.RegisterScreen;
import com.revature.quizzard.util.LinkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) {
        AppUser newUser = new AppUser("wsingleton", "p4ssw0rd",
                "wezley.singleton@revature.com",
                "Wezley", "Singleton", 30);

        AppUser newUser2 = new AppUser("ggecko", "p4ssw0rd",
                "gex.gecko@revature.com",
                "Gex", "Gecko", 30);

        AppUser newUser3 = new AppUser("tdiendorf", "p4ssw0rd",
                "thomas.diendorf@revature.com",
                "Thomas", "Diendorf", 30);

        AppUser newUser4 = new AppUser("sguy", "p4ssw0rd",
                "some.guy@revature.com",
                "Some", "Guy", 30);

        LinkedList<AppUser> userList = new LinkedList<>();
        userList.add(newUser);
        userList.add(newUser2);
        userList.add(newUser3);
        userList.add(newUser4);
        userList.printLinkedList();

        File dataFile = new File("resources/users.txt");

        /*System.out.println("Press 1 to Login");
        System.out.println("Press 2 to Register");
        System.out.println("Press 3 to Exit");

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
        }*/


    }

}