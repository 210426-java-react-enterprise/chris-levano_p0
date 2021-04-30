package com.revature.quizzard;

import com.revature.quizzard.daos.UserDAO;
import com.revature.quizzard.models.AppUser;
import com.revature.quizzard.screens.RegisterScreen;
import com.revature.quizzard.screens.LoginScreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) {
//        AppUser newUser = new AppUser("wsingleton", "p4ssw0rd",
//                                      "wezley.singleton@revature.com",
//                                      "Wezley", "Singleton", 30);

        AppUser user = null;
        UserDAO userDAO = new UserDAO();

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            //RegisterScreen registerScreen = new RegisterScreen(consoleReader);
            //registerScreen.render();
            LoginScreen loginScreen = new LoginScreen(consoleReader);
            user = loginScreen.render();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user != null) {
            AppUser foundUser = userDAO.findUserByUsername(user.getUsername());
            if (foundUser == null) {
                System.out.println("User not found.");
            }
            else if (foundUser.getPassword().equals(user.getPassword())) {
                System.out.printf("User %s authenticated!\n", user.getUsername());
            }
            else if(!foundUser.getPassword().equals(user.getPassword())) {
                System.out.printf("User %s not authenticated, password mismatch.\n", user.getUsername());
            }

        }



    }

}
