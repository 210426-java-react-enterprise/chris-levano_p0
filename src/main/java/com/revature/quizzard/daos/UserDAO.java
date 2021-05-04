package com.revature.quizzard.daos;

import com.revature.quizzard.models.AppUser;
import com.revature.quizzard.util.ConnectionFactory;

import javax.xml.transform.Result;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    //TODO
    public void save(AppUser newUser){

    };

    public AppUser findUserByUsernameAndPassword(String username, String password) {
        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select * from quizzard.users where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new AppUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getInt("age"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

/*
// These are for File but we have moved to database.
    String userDataFile;

    public UserDAO() {
        userDataFile = "src/main/resources/users.txt";
    }

    public void saveUserToFile(AppUser newUser) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile, true))) {
            writer.write(newUser.toFileString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AppUser findUserByUsernameAndPassword(String username, String password) {

        try (BufferedReader reader = new BufferedReader(new FileReader(userDataFile))) {
            String userRecord;
            while ((userRecord = reader.readLine()) != null) {
                String[] userData = userRecord.split(";");
                if (userData[0].equals(username) && userData[1].equals(password)) {
                    return new AppUser(userData[0], userData[1], userData[2], userData[3], userData[4], Integer.parseInt(userData[5]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
*/
}
