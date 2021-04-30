package com.revature.quizzard.screens;

import java.io.*;

public class LoginScreen {

    //private String users = "users.txt";
    private String successM = "Login successful!";
    private String failM = "Login failed!";

    private BufferedReader br;
    private BufferedReader consoleReader;

    public LoginScreen(BufferedReader consoleReader) { this.consoleReader = consoleReader; }

    public String CheckForUser(String users){
        String userName = null;
        String password = null;

        String fName = "";
        String fPassword = "";

        boolean foundName = false;
        //boolean foundPassword = false;

        RegisterScreen reg1 = new RegisterScreen(br);

        System.out.println("Enter a Username: ");
        //consoleReader = this.consoleReader;

        try {
            userName = consoleReader.readLine();

            System.out.println("Enter Username's password: ");
            password = consoleReader.readLine();

        } catch (Exception e){
            e.printStackTrace();
        }

        //Find Username
        try{
            BufferedReader br = new BufferedReader(new FileReader(users));
            String temp;

            System.out.println("Checking for username: " + userName);

            //int line = 0;

            while((temp = br.readLine()) != null) {//will go until end of file is reached

                //line++;
                //System.out.println("Reading file line " + line);

                fName = "";
                fPassword = "";

                //first check for matching username
                //if it matches, then store/check it and password on same line
                for (int i = 0; i < temp.length(); i++) {//checks username and password for current line each loop
                    char c = temp.charAt(i);

                    if (c == ';' && !foundName) {//1st time ';' is read in line, indicates finished reading username
                        assert userName != null;
                        if (userName.equals(fName)) {
                            foundName = true;
                            System.out.println("Found username " + fName);
                            continue;//skip ';' char
                        } else {
                            break;//username doesn't match on this line
                        }
                    } else if(c == ';' && foundName){//2nd time ';' is read, indicates finished reading password
                        assert password != null;
                        if(password.equals(fPassword)){//password found that matches username
                            //System.out.println("Found password match " + fPassword);
                            return successM;
                        }else{//password doesn't match username
                            //System.out.println("Password " + fPassword + " does not match username!");
                            return failM;
                        }
                    } else if(!foundName){
                        fName += temp.charAt(i);
                    } else if(foundName){
                        fPassword += temp.charAt(i);
                    }
                }
            }
            return failM;//username and/or password not found

        } catch (FileNotFoundException e) {
           System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Input or output error!");
        } catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println("Password " + fPassword + " still does not match username!");
        return failM;//sanity check

    }

}


/* Obsolete coding
       try{
            BufferedReader br = new BufferedReader(new FileReader(users));
            //FileReader fr = new FileReader(users);
            char[] a = new char[2048];

            try {
                br.read(a);
            }catch(IOException e){
                System.out.println("Cannot read file!");
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("Checking for username: " + userName);
            //System.out.println("Found username: " + userName);
            System.out.println("...");

            for (char c : a){
                if (c == ';'){
                    if(userName.equals(fName)){
                        foundName = true;
                        br.close();
                        break;
                    } else {
                        fName = "";//reset
                        br.readLine();//skip to next line
                    }
                } if(c == Character.MIN_VALUE){
                    br.close();
                    break;//reached end of file
                }
                else {
                    fName += c;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch(IOException e){
            System.out.println("End of file reached.");
        } catch(Exception e){
            e.printStackTrace();
        }

        if(!foundName){ return failM; } //exit if no username found

        */





//Find Password
        /*try{
            BufferedReader br = new BufferedReader(new FileReader(users));
            char[] a = new char[2048];
            br.read(a);

            System.out.println("Checking for password: " + password);
            System.out.println("...");

            boolean atPassword = false;
            for (char c : a){
                if(password.equals(fPassword)){
                    foundPassword = true;
                    br.close();
                    break;
                }

                if (c == ';' && !atPassword) {
                    atPassword = true;
                } else if(c == ';' && atPassword) {
                    fPassword = "";
                    atPassword = false;//reset for checking password at next line
                    br.readLine();//skip to next line
                } else if(c == Character.MIN_VALUE){
                    br.close();
                    break;//reached end of file
                } else {
                    fPassword += c;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found.");
        } catch(IOException e){
            System.out.println("End of file reached.");
        } catch(Exception e){
            e.printStackTrace();
        }*/
