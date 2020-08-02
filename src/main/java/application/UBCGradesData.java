package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UBCGradesData {

    SQLHandler sql;
    Statement stmt;

    public UBCGradesData() {
        sql = new SQLHandler();
        try {
            stmt = sql.getConnection().createStatement();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    //Return empty list on exception
    public ArrayList<Integer> getUBCYears() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT Year FROM UBC_ALL_DATA;";
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

    public String getUBCCourseDataAsString(int year, String session, String subject, int course, String section, String columnLabel) {
        try {
            String query = "SELECT DISTINCT \"" + columnLabel +"\" FROM UBC_ALL_DATA WHERE " +
                    "Year=" + year + " AND Session='" + session + "' AND " +
                    "Subject='" + subject +"' AND Course=" + course +" AND Section='" +
                    section + "';";
            ResultSet rs = stmt.executeQuery(query);
            String data = rs.getString(columnLabel);
            return data;
        } catch (Exception throwables) {
            return "";
        }
    }

    public int getUBCCourseDataAsInteger(int year, String session, String subject, int course, String section, String columnLabel) {
        try {
            String query = "SELECT DISTINCT \"" + columnLabel + "\" FROM UBC_ALL_DATA WHERE " +
                    "Year=" + year + " AND Session='" + session + "' AND " +
                    "Subject='" + subject +"' AND Course=" + course +" AND Section='" +
                    section + "';";
            ResultSet rs = stmt.executeQuery(query);
            int data = rs.getInt(columnLabel);
            return data;
        } catch (Exception throwables) {
            return 0;
        }
    }

    public static void main(String[] args) {
        UBCGradesData grades = new UBCGradesData();
        System.out.println(grades.getUBCCourseDataAsInteger(2001, "W", "CPSC", 100, "OVERALL", "10-19"));
    }

}


