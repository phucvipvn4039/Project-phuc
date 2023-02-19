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
import java.sql.Statement;
import utils.Hash;

/**
 *
 * @author PHT
 */
public class CustomerFacade {

    public void register(Customer customer) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException {
        //Tao ket noi database
        Connection con = DbContext.getConnection();

        try {
            //Bắt đầu transaction
            con.setAutoCommit(false);
            //Insert data vào table Account
            PreparedStatement stm = con.prepareStatement("insert into Account values(?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, customer.getName());
            stm.setString(2, customer.getAddress());
            stm.setString(3, customer.getPhone());
            stm.setString(4, customer.getEmail());
            stm.setString(5, Hash.hash(customer.getPassword()));
            stm.setBoolean(6, customer.isEnabled());
            stm.setString(7, customer.getRole());
            int count = stm.executeUpdate();

            //Lấy account id được phát sinh tự động
            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) {
                    customer.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Inserting account failed.");
                }
            }

            //Insert data vào table Customer
            stm = con.prepareStatement("insert into Customer values(?, ?, ?)");
            stm.setInt(1, customer.getId());
            stm.setString(2, customer.getCategory());
            stm.setString(3, customer.getShipToAddress());
            count = stm.executeUpdate();
            //Kết thúc transaction
            con.commit();
        } catch (SQLException ex) {
            try {
                //Undo transaction
                con.rollback();
            } catch (SQLException ex1) {
                throw ex1;
            }
            throw ex;
        }

        //Dong ket noi database
        con.close();
    }
}
