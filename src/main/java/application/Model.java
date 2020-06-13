package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

    public ObservableList<Integer> getYearObservableList(SQLConnection sql) {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = sql.getQuery("SELECT DISTINCT Year FROM UBC_ALL_DATA;");
            while (rs.next() == true) {
                int year = rs.getInt("Year");
                list.add(year);
            }
            return list;
        }
        catch(SQLException e) {
            return list;
        }
    }

    public ObservableList<String> getSessionObservableList(SQLConnection sql) {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
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

    public ObservableList<String> getSubjectObservableList(SQLConnection sql, int year, String session) {
        try {
            ObservableList<String> list = FXCollections.observableArrayList();
            ResultSet rs = sql.getQuery("SELECT DISTINCT Subject FROM UBC_ALL_DATA WHERE Year=" + year + " AND Session='" + session +"';");
            while (rs.next() == true) {
                String subject = rs.getString("Subject");
                list.add(subject);
            }
            System.out.println(list);
            return list;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList();
    }

    public ObservableList<String> getSubjectObservableList() {
        ObservableList<String> list = FXCollections.observableArrayList();
            return list;
    }

    public ObservableList<Integer> getCourseObservableList(SQLConnection sql, int year, String session, String subject) {
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = sql.getQuery("SELECT DISTINCT Course FROM UBC_ALL_DATA WHERE Year="
                    + year + " AND Session='" + session +"' AND Subject='" + subject + "';");
            while (rs.next() == true) {
                int course = rs.getInt("Course");
                list.add(course);
            }
            return list;
        }
        catch(SQLException e) {
            return list;
        }
    }

//    public static void main(String[] args) {
//        SQLConnection sql = new SQLConnection();
//        sql.connect();
//        Model model = new Model();
//        long startTime = System.nanoTime();
//        model.getSubjectObservableList(sql, 2000, "W");
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println(duration);
//    }
}
