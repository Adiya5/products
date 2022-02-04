package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;
public class DB implements IDB {
    private Connection conn;

    public DB() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionUrl, "postgres", "20072004");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Connection getConnection() {
        return conn;
    }


    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
