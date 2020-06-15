package application;

import java.sql.*;

public class SQLHandler {

    private Connection connection;
    private String databaseURL = "jdbc:sqLite::resource:export.db";

    public SQLHandler(String databaseURL) {
        this.databaseURL = databaseURL;
        try {
            connection = DriverManager.getConnection(databaseURL);
            System.out.println("Connection to provided database established.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SQLHandler() {
        try {
            connection = DriverManager.getConnection(databaseURL);
            System.out.println("Connection to default database established.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}




