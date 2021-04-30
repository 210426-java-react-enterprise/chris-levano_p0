package com.revature.quizzard;

import com.revature.quizzard.models.AppUser;
import com.revature.quizzard.screens.LoginScreen;
import com.revature.quizzard.screens.RegisterScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) {
        AppUser newUser = new AppUser("wsingleton", "p4ssw0rd",
                "wezley.singleton@revature.com",
                "Wezley", "Singleton", 30);

//        newUser.toString()
//        System.out.printf("Hello and welcome, %s! I see that you are %d years old, nice!", newUser.getUsername(), newUser.getAge());

        // doesn't work because %d only works with digits
//        System.out.printf("Test char with digit specifier: %d", 'a');

        // try () {} == try-with-resources
        /*try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            RegisterScreen registerScreen = new RegisterScreen(consoleReader);
            registerScreen.render();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String name;

        //LoginScreen lScreen = new LoginScreen();

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            LoginScreen lScreen = new LoginScreen(consoleReader);

            System.out.println(lScreen.CheckForUser("resources/users.txt")); //could make it File f = "resources/users.txt", and place f as parameter
            //System.out.println(lScreen.CheckForUser("resources/users.txt"));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}