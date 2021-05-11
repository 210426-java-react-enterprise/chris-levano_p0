package com.revature.p0.services;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.models.AppUser;

public class AccountService {
    public static void depositVerify(double deposit_am){
        if (deposit_am < 0) {
            System.out.println("Deposit value must be positive!");
        } else{
            AccountsDAO.deposit(AppUser.getId(), deposit_am);
        }
    }
    public static void withdrawVerify(double withdraw_am){
        if (withdraw_am < 0 || withdraw_am > AccountsDAO.fetchBalance(AppUser.getId())) {
            System.out.println("Withdrawal value must be greater than zero and less than account balance!");
        } else{
            AccountsDAO.deposit(AppUser.getId(), withdraw_am);
        }
    }
}
