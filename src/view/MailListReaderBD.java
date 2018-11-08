/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Mail;

/**
 *
 * @author Usuario
 */
public class MailListReaderBD {
    
    public static List<Mail> read() throws Exception {
        List<Mail> lista = new ArrayList<>();
        String sql = "SELECT * FROM EMAIL";
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                lista.add(new Mail(rs.getString("mail")));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"--");
        }
        
        return lista;
    }
    
    private static ResultSet selectAll(){
        String sql = "SELECT * FROM EMAIL";
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            return rs;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"--");
            return null;
        }
    }
    
    public static Connection connect() throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:KATA5.db";
        conn = DriverManager.getConnection(url);
        return conn;
        
    }
}
