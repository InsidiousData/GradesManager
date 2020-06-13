package application;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {

    Connection conn = null;

    public SQLConnection() {
    }

    public void connect() {
        try {
            //DB parameters
            String url = "jdbc:sqlite::resource:export.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Connection to database established.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getQuery(String query) throws SQLException {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;


    }
}

