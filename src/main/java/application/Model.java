package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

    public ObservableList<String> getYearObservableList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            SQLConnection sql = new SQLConnection();
            sql.connect();
            ResultSet rs = sql.getQuery("SELECT DISTINCT Year FROM UBC_ALL_DATA;");
            while (rs.next() == true) {
                String year = rs.getString("Year");
                list.add(year);
            }
            return list;
        }
        catch(SQLException e) {
            return list;
        }
    }

    public ObservableList<String> getSessionObservableList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            SQLConnection sql = new SQLConnection();
            sql.connect();
            ResultSet rs = sql.getQuery("SELECT DISTINCT Session FROM UBC_ALL_DATA;");
            while (rs.next() == true) {
                String session = rs.getString("Session");
                list.add(session);
            }
            return list;
        }
        catch(SQLException e) {
            return list;
        }
    }

    public ObservableList<String> getSubjectObservableList(int year, String session) {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            SQLConnection sql = new SQLConnection();
            sql.connect();
            ResultSet rs = sql.getQuery("SELECT DISTINCT Subject FROM UBC_ALL_DATA WHERE Year=" + year + " AND Session='" + session +"';");
            while (rs.next() == true) {
                String subject = rs.getString("Subject");
                list.add(subject);
            }
            return list;
        }
        catch(SQLException e) {
            return list;
        }
    }

    public ObservableList<String> getSubjectObservableList() {
        ObservableList<String> list = FXCollections.observableArrayList();
            return list;
    }

    public ObservableList<String> getCourseObservableList(int year, String session, String subject) {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            SQLConnection sql = new SQLConnection();
            sql.connect();
            ResultSet rs = sql.getQuery("SELECT DISTINCT Course FROM UBC_ALL_DATA WHERE Year="
                    + year + " AND Session='" + session +"' AND Subject='" + subject + "';");
            while (rs.next() == true) {
                String course = rs.getString("Course");
                list.add(course);
            }
            return list;
        }
        catch(SQLException e) {
            return list;
        }
    }
}
