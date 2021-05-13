package com.revature.p0.services;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.AppUser;

/**
 * Handles logic for user account creation to prevent trying to write to the database
 */
public class UserService {

    private UserDAO userDao;

    /**
     * sets the current user as the user to run operations on
     * @param userDao
     * @param mockAccountDao
     */
    public UserService(UserDAO userDao, AccountsDAO mockAccountDao) {
        this.userDao = userDao;
    }

    /**
     * Checks if username is unique and valid and see if the email is unique
     * @param newUser
     * @throws Exception
     */
    public void register(AppUser newUser) throws Exception{

        if (!isUserValid(newUser)) {
            throw new Exception("Invalid new user data provided!");
        }

        if (!userDao.isUsernameAvailable(newUser.getUsername())) {
            throw new Exception("The provided username is already taken!");
        }

        if (!userDao.isEmailAvailable(newUser.getEmail())) {
            throw new Exception("The provided email is already taken!");
        }

        userDao.save(newUser);

    }

    /**
     * Checks the user data to ensure that it won't overload the db columns or cause any other problems with data logic
     * @param user
     * @return bool, true if credentials comply, false if not
     */
    public static boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getUsername() == null || user.getUsername().trim().isEmpty() || user.getUsername().length() > 20) return false;
        if (user.getPassword() == null || user.getPassword().trim().isEmpty() || user.getPassword().length() > 255) return false;
        if (user.getEmail() == null || user.getEmail().trim().isEmpty() || user.getEmail().length() > 255) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().isEmpty() || user.getFirstName().length() > 25) return false;
        if (user.getLastName() == null || user.getLastName().trim().isEmpty() || user.getLastName().length() > 25) return false;
        if (user.getAge() < 0) return false;

        return true;
    }

}