package com.revature.quizzard.screens;

import java.io.*;

public class LoginScreen {

    private static final String SUCCESS_M = "Login successful!";
    private static final String FAIL_M = "Login failed!";

    private BufferedReader br;
    private BufferedReader consoleReader;

    public LoginScreen(BufferedReader consoleReader) { this.consoleReader = consoleReader; }

    public void CheckForUser(File users){
        String userName = null;
        String password = null;



        System.out.println("+----- LOGIN: ------+");
        System.out.println("Enter username: ");

        try {
            userName = consoleReader.readLine();
            assert (userName != null && userName.length() > 2);
            System.out.println("Username = " + userName);

            System.out.println("Enter password: ");
            password = consoleReader.readLine();
            assert password != null;
        } catch (Exception e){
            e.printStackTrace();
        }


        try{
            BufferedReader br = new BufferedReader(new FileReader(users));
            String temp;

            String[] fileStrings;// = new String[6];

            System.out.println("Checking for username: " + userName);

            while((temp = br.readLine()) != null) {//will go until end of file is reached
                fileStrings = temp.split(";", 6);
                assert fileStrings.length == 6;//username, pswd, email, firstname, lastname, age
                assert !fileStrings[0].equals("");//make sure there's a valid username
                assert !fileStrings[1].equals("");//make sure there's a valid password

                if(userName.equals(fileStrings[0])){
                    if(password.equals(fileStrings[1])){
                        System.out.println(SUCCESS_M);
                    }else{
                        System.out.println("Password doesn't match username!");
                        System.out.println(FAIL_M);
                    }
                    return;//either the password matches the username, or it doesn't, either way we're done
                }
            }
            System.out.println("Username not found!");
            System.out.println(FAIL_M);

        } catch (FileNotFoundException e) {
           System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Input or output error!");
        } catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println("Password " + fPassword + " still does not match username!");
        //return FAIL_M;//sanity check
        //System.out.println(FAIL_M);

    }

}
