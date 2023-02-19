/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Hash;

/**
 *
 * @author PHT
 */
public class AccountFacade {

    public Account login(String email, String password) throws ClassNotFoundException, SQLException {
        Account account = null;
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        //Thuc hien lenh SQL
        PreparedStatement stm = con.prepareStatement("select * from Account where email=? and password=?");
        stm.setString(1, email);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            //Doc mau tin hien hanh vao doi tuong product
            account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setAddress(rs.getString("address"));
            account.setPhone(rs.getString("phone"));
            account.setEmail(rs.getString("email"));
            account.setPassword(rs.getString("password"));
            account.setEnabled(rs.getBoolean("enabled"));
            account.setRole(rs.getString("role"));
        }
        //Dong ket noi database
        con.close();
        return account;
    }   
}
