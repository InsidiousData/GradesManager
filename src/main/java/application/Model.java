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
    private String enrolled;
    private String average;
    private String stdDev;
    private String highestGrade;
    private String lowestGrade;
    private String passCount;
    private String failCount;
    private String withdrewCount;
    private String auditCount;
    private String otherCount;

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

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getDetail() {
        return detail;
    }

    public String getProfessor() {
        return professor;
    }

    public String getEnrolled() {
        return enrolled;
    }

    public String getAverage() {
        return average;
    }

    public String getStdDev() {
        return stdDev;
    }

    public String getHighestGrade() {
        return highestGrade;
    }

    public String getLowestGrade() {
        return lowestGrade;
    }

    public String getPassCount() {
        return passCount;
    }

    public String getFailCount() {
        return failCount;
    }

    public String getWithdrewCount() {
        return withdrewCount;
    }

    public String getAuditCount() {
        return auditCount;
    }

    public String getOtherCount() {
        return otherCount;
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

    public void updateCourseTitle() {
        courseTitle = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Title");
    }
    public void updateProfessor() {
        professor = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Professor");
    }
    public void updateEnrolled() {
        enrolled = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Enrolled");
    }
    public void updateAverage() {
        average = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Avg");
    }
    public void updateStdDev() {
        stdDev = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Stddev");
    }
    public void updateHigh() {
        highestGrade = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "High");
    }
    public void updateLow() {
        lowestGrade = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Low");
    }
    public void updatePassCount() {
        passCount = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Pass");
    }
    public void updateFailCount() {
        failCount = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Fail");
    }
    public void updateWithdrewCount() {
        withdrewCount = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Withdrew");
    }
    public void updateAuditCount() {
        auditCount = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Audit");
    }
    public void updateOtherCount() {
        otherCount = data.getUBCCourseData(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Other");
    }


    public void updateData() {
        updateCourseTitle();
        updateProfessor();
        updateEnrolled();
        updateAverage();
        updateStdDev();
        updateHigh();
        updateLow();
        updatePassCount();
        updateFailCount();
        updateWithdrewCount();
        updateAuditCount();
        updateOtherCount();
    }


    public void updateLists() {
        updateSubjectList();
        updateCourseList();
        updateSectionList();
    }

    public static void main(String[] args) {
        Model model = new Model();
        model.setSelectedYear(2000);
        model.setSelectedSection("OVERAll");
        model.setSelectedCourse(100);
        model.setSelectedSession("W");
        model.setSelectedSubject("CPSC");
        model.updateStdDev();
        System.out.println(model.getStdDev());
    }


}

