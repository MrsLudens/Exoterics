/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
    public static java.sql.Connection getConexaoMySQL() {
        Connection conn = null;

        String serverName = "localhost";
        String mydatabase = "exoterics";
        String url = "jdbc:mysql://" + serverName + ":3307 / " + mydatabase;
        String username = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}

