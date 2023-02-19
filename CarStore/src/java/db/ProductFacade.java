/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHT
 */
public class ProductFacade {

    public List<Product> select() throws ClassNotFoundException, SQLException {
        List<Product> list = new ArrayList<>();
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        //Thuc hien lenh SQL
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from Product");
        while (rs.next()) {
            //Doc mau tin hien hanh vao doi tuong product
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
            //Them doi tuong product vao list
            list.add(product);
        }
        //Dong ket noi database
        con.close();
        return list;
    }

    public List<Product> select(int index, int pageSize) throws ClassNotFoundException, SQLException {
        List<Product> list = new ArrayList<>();
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        //Thuc hien lenh SQL
        String sql = String.format("select * from Product order by Id offset %d rows fetch next %d rows only",
                (index - 1) * pageSize, pageSize);
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            //Doc mau tin hien hanh vao doi tuong product
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
            //Them doi tuong product vao list
            list.add(product);
        }
        //Dong ket noi database
        con.close();
        return list;
    }

    public List<Product> select(int index, int pageSize, String searchField, String searchText, String operator) throws ClassNotFoundException, SQLException {
        List<Product> list = new ArrayList<>();
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        if(operator.equals("contains")){
            operator = "like";
            searchText = "%" + searchText + "%";
        }
        String sql = String.format("select * from Product where %s %s '%s' order by Id offset %d rows fetch next %d rows only",
                searchField, operator, searchText,
                (index - 1) * pageSize, pageSize);
        //Thuc hien lenh SQL        
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            //Doc mau tin hien hanh vao doi tuong product
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
            //Them doi tuong product vao list
            list.add(product);
        }
        //Dong ket noi database
        con.close();
        return list;
    }
    
    public Product select(int id) throws ClassNotFoundException, SQLException {
        Product product = null;
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        //Thuc hien lenh SQL
        PreparedStatement stm = con.prepareStatement("select * from Product where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            //Doc mau tin hien hanh vao doi tuong product
            product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        //Dong ket noi database
        con.close();
        return product;
    }

    public int count() throws ClassNotFoundException, SQLException {
        int n = 0;
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        //Thuc hien lenh SQL
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select count(*) from Product");
        if (rs.next()) {
            n = rs.getInt(1);
        }
        //Dong ket noi database
        con.close();
        return n;
    }

    public int count(String searchField, String searchText, String operator) throws ClassNotFoundException, SQLException {
        int n = 0;
        //Tao ket noi database
        Connection con = DbContext.getConnection();
        //Thuc hien lenh SQL
        Statement stm = con.createStatement();
        if(operator.equals("contains")){
            operator = "like";
            searchText = "%" + searchText + "%";
        }
        String sql = String.format("select count(*) from Product where %s %s '%s'", searchField, operator, searchText);
        ResultSet rs = stm.executeQuery(sql);
        if (rs.next()) {
            n = rs.getInt(1);
        }
        //Dong ket noi database
        con.close();
        return n;
    }
}
