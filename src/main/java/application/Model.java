package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    UBCGradesData data;

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

    private SQLHandler sql;

    public Model() {
        data = new UBCGradesData();
        yearList = FXCollections.observableArrayList(data.getUBCYears());
        sessionList = FXCollections.observableArrayList(data.getUBCSessions());
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

    public void updateYearList() {
        yearList = FXCollections.observableArrayList(data.getUBCYears());
    }

    public void updateSessionList() {
        sessionList = FXCollections.observableArrayList(data.getUBCSessions());
    }

    public void updateSubjectList() {
        subjectList = FXCollections.observableArrayList(data.getUBCSubjects(selectedYear, selectedSession));
    }

    public void updateCourseList() {
        courseList = FXCollections.observableArrayList(data.getUBCCourses(selectedYear, selectedSession,
                selectedSubject));
    }

    public void updateSectionList() {
        sectionList = FXCollections.observableArrayList(data.getUBCSections(selectedYear, selectedSession,
                selectedSubject, selectedCourse));
    }

    public void updateLists() {
        updateSubjectList();
        updateCourseList();
        updateSectionList();
    }
}

