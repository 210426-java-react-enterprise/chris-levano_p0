package com.revature.p0.daos;

import com.revature.p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsDAO {
    public static void fetchBalance(int id) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "select account_num, balance from public.accounts where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int account_num = rs.getInt(1);
                double balance = rs.getDouble(2);
                System.out.println("New balance is: " + balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deposit(int id, double deposit_am) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "update accounts set balance = balance + ? where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, deposit_am);
            pstmt.setInt(2, id);
            double balanceDelta = pstmt.executeUpdate();;
            if (balanceDelta != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    System.out.println(rs.getDouble("balance"));
                }
            }
            AccountsDAO.fetchBalance(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void withdraw(int id, double withdraw_am) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

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
            AccountsDAO.fetchBalance(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
