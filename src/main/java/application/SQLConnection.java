package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {

    Connection conn = null;

    public SQLConnection() {
        try {
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

    public ObservableList<Integer> getYearList() {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = getQuery("SELECT DISTINCT Year FROM UBC_ALL_DATA;");
            while (rs.next() == true) {
                int year = rs.getInt("Year");
                list.add(year);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }

    public ObservableList<String> getSessionList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = getQuery("SELECT DISTINCT Session FROM UBC_ALL_DATA;");
            while (rs.next() == true) {
                String session = rs.getString("Session");
                list.add(session);
            }
            return list;
        } catch (SQLException e) {
            return list;
        }
    }

    public ObservableList<String> getSubjectList(int year, String session) {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = getQuery("SELECT DISTINCT Subject FROM UBC_ALL_DATA WHERE Year=" + year
                    + " AND Session='" + session + "';");
            while (rs.next() == true) {
                String subject = rs.getString("Subject");
                list.add(subject);
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }


    public ObservableList<Integer> getCourseList(int year, String session, String subject) {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = getQuery("SELECT DISTINCT Course FROM UBC_ALL_DATA WHERE Year="
                    + year + " AND Session='" + session +"' AND Subject='" + subject + "';");
            while (rs.next() == true) {
                int course = rs.getInt("Course");
                list.add(course);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }

    public ObservableList<String> getSectionList(int year, String session, String subject, int course) {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = getQuery("SELECT DISTINCT Section FROM UBC_ALL_DATA WHERE Year="
                    + year + " AND Session='" + session + "' AND Subject='" + subject
                    + "' AND Course=" + course + ";");
            while (rs.next() == true) {
                String section = rs.getString("Section");
                list.add(section);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }

    public String getCourseData(int year, String session, String subject, int course, String section, String columnLabel) {
        try {
            ResultSet rs = getQuery("SELECT DISTINCT " + columnLabel + " FROM UBC_ALL_DATA WHERE Year=" + year + " AND Session='" + session + "' AND Subject='" + subject + "' AND Course=" +
                    course +" AND Section='" + section + "';");
            System.out.println(rs.getString("Title"));
            return rs.getString("Title");
        } catch (SQLException e) {
            System.out.println("Data retrieval failed.");
            return null;
        }
    }
}




