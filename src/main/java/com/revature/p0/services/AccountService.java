package com.revature.p0.services;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.models.AppUser;

import static com.revature.p0.models.AppUser.*;

/**
 * Handles logic for user withdrawals and deposits to prevent trying to write to the database
 */
public class AccountService {
    /**
     * verifies that the deposit is positive, if it is it will invoke the deposit
     * @param deposit_am
     */
    public static void depositVerify(double deposit_am){
        if (deposit_am < 0) {
            System.out.println("Deposit value must be positive!");
        } else{
            AccountsDAO.deposit(getId(), deposit_am);
        }
    }
    /**
     * verifies that the withdraw is positive and would not leave the user with negative balance,
     * as long as it is it will invoke the withdraw. Does need to call the db to see if it would overdraft
     * but it should still be done before we try to write to it.
     * @param withdraw_am
     */
    public static void withdrawVerify(double withdraw_am){
        if (withdraw_am < 0 || withdraw_am > AccountsDAO.fetchBalance(getId())) {
            System.out.println("Withdrawal value must be greater than zero and less than account balance!");
        } else{
            AccountsDAO.withdraw(getId(), withdraw_am);
        }
    }
}
