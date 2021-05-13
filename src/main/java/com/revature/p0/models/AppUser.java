package com.revature.p0.models;

/**
 * Builds the AppUser object using basic getters and setters
 */
public class AppUser {

    private static int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int age;

    public AppUser() {
        super();
    }

    /**
     * Assembles the present values of the params to assemble an AppUser object to be more easily passed around
     * Values for the params will be harvested at registration.
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param age
     */
    public AppUser(String username, String password, String email, String firstName, String lastName, int age) {
        System.out.println("Registering user...");
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
