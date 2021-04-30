package com.revature.quizzard.screens;

import com.revature.quizzard.Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginScreen {

    /*
    Implement a login screen that takes in user input for the username and password
     and compares that to data in the users.txt file (inside of resources).
     If a user is found, print out "Login successful!"
     Otherwise, print out "Login failed!"
     */

    private static int attempts = 3;

    LoginScreen(){
        System.out.println("LoginScreen constructor invoked!");
    }
    public static void render() {
        String user;
        String pass;

        System.out.print("username: ");
        user = Driver.scan.next();
        System.out.println(user);

        System.out.print("password: ");
        pass = Driver.scan.next();
        System.out.println(pass);

        if(LoginScreen.checkCreds(user, pass))
        {
            System.out.println("Login successful");
        } else System.out.println("Login failed");
    }

    public static boolean checkCreds(String user, String pass) {
        String txt;

        try {
            Scanner reader = new Scanner(new FileReader("resources/users.txt"));
            txt = reader.next();
            String[] textData = txt.split(";");
            System.out.println(txt);

            while (attempts > 0 ){
                if (textData[0].equals(user) && textData[1].equals(pass)){
                    return true;
                }
                else if (attempts < 3) System.out.printf("You have %d attempts left.\n", attempts--);
            }
        } catch (FileNotFoundException fnf) {
        }
        return false;
    }
}
