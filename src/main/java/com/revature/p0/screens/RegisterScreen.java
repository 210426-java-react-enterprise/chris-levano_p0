package com.revature.p0.screens;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.AppUser;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {

    private UserDAO userDao = new UserDAO();
    private BufferedReader consoleReader;

    public RegisterScreen(BufferedReader consoleReader) {
        super("RegisterScreen", "/register");
        this.consoleReader = consoleReader;
    }

    public void render() {

        String firstName;
        String lastName;
        String email;
        String username;
        String password;
        int age;

        try {

            System.out.println("Register for a new account!");
            System.out.println("+-------------------------+");

            System.out.print("First name: ");
            firstName = consoleReader.readLine(); // throws Exception here

            System.out.print("Last name: ");
            lastName = consoleReader.readLine();

            System.out.print("Email: ");
            email = consoleReader.readLine();

            System.out.print("Username: ");
            username = consoleReader.readLine();

            System.out.print("Password: ");
            password = consoleReader.readLine();

            System.out.print("Age: ");
            age = Integer.parseInt(consoleReader.readLine());

            AppUser newUser = new AppUser(username, password, email, firstName, lastName, age);
            userDao.save(newUser);

        } catch (NumberFormatException nfe) {
            System.err.println("You provided an incorrect value for your age! Please try again!");
            this.render();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
