package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UBCGradesData {

    SQLHandler sql = new SQLHandler();

    //Return empty list on exception
    public ArrayList<Integer> getUBCYears() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT Year FROM UBC_ALL_DATA;";
            Statement stmt = sql.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(rs.getInt("Year"));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }

    //Return empty list on exception
    public ArrayList<String> getUBCSessions() {
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT Session FROM UBC_ALL_DATA;";
            Statement stmt = sql.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(rs.getString("Session"));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }

    //List of subjects depends on year and session
    //If unable to find, return empty list
    public ArrayList<String> getUBCSubjects(int year, String session) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT Subject FROM UBC_ALL_DATA WHERE " +
                    "Year=" + year + " AND Session='" + session + "';";
            Statement stmt = sql.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(rs.getString("Subject"));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }

    //List of courses depends on year, session, and subject
    public ArrayList<Integer> getUBCCourses(int year, String session, String subject) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT Course FROM UBC_ALL_DATA WHERE " +
                    "Year=" + year + " AND Session='" + session + "' AND " +
                    "Subject='" + subject +"';";
            Statement stmt = sql.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(rs.getInt("Course"));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }

    //List of sections depends on year, session, subject, and course
    public ArrayList<String> getUBCSections(int year, String session, String subject, int course) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT Section FROM UBC_ALL_DATA WHERE " +
                    "Year=" + year + " AND Session='" + session + "' AND " +
                    "Subject='" + subject +"' AND Course=" + course +";";
            Statement stmt = sql.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(rs.getString("Section"));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return list;
        }
    }

}


