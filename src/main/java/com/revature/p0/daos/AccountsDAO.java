package com.revature.p0.daos;

import com.revature.p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class AccountsDAO {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static Double fetchBalance(int id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT account_num, balance FROM public.accounts WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int account_num = rs.getInt(1);
                double balance = rs.getDouble(2);
                return balance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int fetchAccountNum(int id){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT account_num FROM public.accounts WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int account_num = rs.getInt(1);
                return account_num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(null);
    }
    public static void deposit(int id, double deposit_am) {
        if (deposit_am < 0){
            System.out.println("You can not deposit a negative amount! Please try again!");
            return;
        }
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String change_bal = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(change_bal);
            pstmt.setDouble(1, deposit_am);
            pstmt.setInt(2, id);
            double balanceDelta = pstmt.executeUpdate();;
            if (balanceDelta != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    System.out.println(rs.getDouble("balance"));
                }
            }
            double balance = AccountsDAO.fetchBalance(id);
            int account_num = AccountsDAO.fetchAccountNum(id);
            System.out.println("New balance is: \n" + balance);
            String trans_insert = "INSERT INTO public.transactions (account_num, change, prev_bal)" + "VALUES (?,?,?)";
            PreparedStatement prepState = conn.prepareStatement(trans_insert);
            prepState.setInt(1, account_num);
            prepState.setDouble(2, deposit_am);
            prepState.setDouble(3, (balance - deposit_am));
            int insertTrans = prepState.executeUpdate();
            if (insertTrans != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    System.out.println(rs.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void withdraw(int id, double withdraw_am) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            double balance = AccountsDAO.fetchBalance(id);
            if (withdraw_am < 0 || withdraw_am > balance){
                System.out.println("You can not withdraw a negative amount or withdraw more than your account balance! Please try again!");
                return;
            }
            String sql = "update accounts set balance = balance - ? where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, withdraw_am);
            pstmt.setInt(2, id);
            double balanceDelta = pstmt.executeUpdate();;
            if (balanceDelta != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    System.out.println(rs.getDouble("balance"));
                }
            }
            balance = AccountsDAO.fetchBalance(id);
            System.out.println("New balance is: \n" + balance);
            int account_num = AccountsDAO.fetchAccountNum(id);
            String trans_insert = "INSERT INTO public.transactions (account_num, change, prev_bal)" + "VALUES (?,?,?)";
            PreparedStatement prepState = conn.prepareStatement(trans_insert);
            prepState.setInt(1, account_num);
            prepState.setDouble(2, (-1 * withdraw_am));
            prepState.setDouble(3, (balance + withdraw_am));
            int insertTrans = prepState.executeUpdate();
            if (insertTrans != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    System.out.println(rs.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void fetchTransactions(int id){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            int account_num = AccountsDAO.fetchAccountNum(id);
            String fetchTrans = "SELECT * FROM transactions WHERE account_num = ?";
            PreparedStatement pstmt = conn.prepareStatement(fetchTrans);
            pstmt.setInt(1, account_num);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int trans_num = rs.getInt(1);
                double prev_balance = rs.getDouble(3);
                double  change = rs.getDouble(4);
                System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
                String type;
                type = change < 0 ? "WITHDRAWAL" : "DEPOSIT";
                System.out.println("|| Transaction Number: " + trans_num + " || Account Number: " + account_num +
                        " || Previous Balance: " + prev_balance + " || Net Change: " + change + " || Transaction type: " + type + " || Post balance: " +
                        df2.format(prev_balance + change));
            }
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
