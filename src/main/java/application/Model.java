package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    //Selection fields
    private int selectedYear;
    private String selectedSession;
    private String selectedSubject;
    private int selectedCourse;
    private String selectedSection;

    //Selection lists
    private ObservableList<Integer> yearList;
    private ObservableList<String> sessionList;
    private ObservableList<String> subjectList;
    private ObservableList<Integer> courseList;
    private ObservableList<String> sectionList;

    //Statistics for selected course
    private String courseTitle;
    private String detail;
    private String professor;
    private int enrolled;
    private double average;
    private double stdDev;
    private int highestGrade;
    private int lowestGrade;
    private int passCount;
    private int failCount;
    private int withdrewCount;
    private int auditCount;
    private int otherCount;

    private SQLConnection sql;

    public Model() {
        sql = new SQLConnection();
        updateYearList();
        updateSessionList();
        subjectList = FXCollections.observableArrayList();
        courseList = FXCollections.observableArrayList();
        sectionList = FXCollections.observableArrayList();
    }

    public void updateYearList() {
        yearList = sql.getYearList();
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public String getSelectedSession() {
        return selectedSession;
    }

    public void updateSessionList() {
        sessionList = sql.getSessionList();
    }

    public void updateSubjectList() {
        if ((selectedYear != 0) && (selectedSession != null)) {
            subjectList = sql.getSubjectList(selectedYear, selectedSession);
        }
        else {
            subjectList.clear();
        }
    }

    public void updateCourseList() {
        if ((selectedYear != 0) && (selectedSession != null) && (selectedSubject != null)) {
            courseList = sql.getCourseList(selectedYear, selectedSession, selectedSubject);
        }
        else {
            courseList.clear();
        }
    }

    public void updateSectionList() {
        if ((selectedYear != 0) && (selectedSession != null) && (selectedSubject != null) && (selectedCourse != 0)) {
            sectionList = sql.getSectionList(selectedYear, selectedSession, selectedSubject, selectedCourse);
        }
        else {
            sectionList.clear();
        }
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public void setSelectedSession(String selectedSession) {
        this.selectedSession = selectedSession;
    }

    public void setSelectedSubject(String selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public void setSelectedCourse(int selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public void setSelectedSection(String selectedSection) {
        this.selectedSection = selectedSection;
    }

    public ObservableList<Integer> getYearList() {
        return yearList;
    }

    public ObservableList<String> getSessionList() {
        return sessionList;
    }

    public ObservableList<String> getSubjectList() {
        return subjectList;
    }

    public ObservableList<Integer> getCourseList() {
        return courseList;
    }

    public ObservableList<String> getSectionList() {
        return sectionList;
    }

    public void updateModel() {
        updateSubjectList();
        updateCourseList();
        updateSectionList();

        sql.getCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse, selectedSection, "Title");


    }


}

