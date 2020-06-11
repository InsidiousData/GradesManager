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
    public ResultSet getResultSet() {
        String selectAllQuery = "SELECT * FROM UBC_ALL_DATA;";
        ResultSet rs = null;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(selectAllQuery);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }

    public static void main(String[] args) {
        SQLConnection sqlconn = new SQLConnection();
        sqlconn.connect();
        ResultSet rs = sqlconn.getResultSet();
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println(rs.getString(2));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        }
    }

