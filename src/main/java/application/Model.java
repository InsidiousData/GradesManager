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
    //TODO: make sure to incorporate course 'detail'
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

    //Data for graph
    private int zerosRange;
    private int tensRange;
    private int twentiesRange;
    private int thirtiesRange;
    private int fortiesRange;
    private int fiftiesFirstHalfRange;
    private int fiftiesSecondHalfRange;
    private int sixtiesFirstRange;
    private int sixtiesSecondRange;
    private int sixtiesThirdRange;
    private int seventiesFirstRange;
    private int seventiesSecondRange;
    private int eightiesFirstHalfRange;
    private int eightiesSecondHalfRange;
    private int ninetiesRange;

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

    public int getZerosRange() {
        return zerosRange;
    }

    public int getTensRange() {
        return tensRange;
    }

    public int getTwentiesRange() {
        return twentiesRange;
    }

    public int getThirtiesRange() {
        return thirtiesRange;
    }

    public int getFortiesRange() {
        return fortiesRange;
    }

    public int getFiftiesFirstHalfRange() {
        return fiftiesFirstHalfRange;
    }

    public int getFiftiesSecondHalfRange() {
        return fiftiesSecondHalfRange;
    }

    public int getSixtiesFirstRange() {
        return sixtiesFirstRange;
    }

    public int getSixtiesSecondRange() {
        return sixtiesSecondRange;
    }

    public int getSixtiesThirdRange() {
        return sixtiesThirdRange;
    }

    public int getSeventiesFirstRange() {
        return seventiesFirstRange;
    }

    public int getSeventiesSecondRange() {
        return seventiesSecondRange;
    }

    public int getEightiesFirstHalfRange() {
        return eightiesFirstHalfRange;
    }

    public int getEightiesSecondHalfRange() {
        return eightiesSecondHalfRange;
    }

    public int getNinetiesRange() {
        return ninetiesRange;
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
        courseTitle = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Title");
    }
    public void updateProfessor() {
        professor = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Professor");
    }
    public void updateEnrolled() {
        enrolled = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Enrolled");
    }
    public void updateAverage() {
        average = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Avg");
    }
    public void updateStdDev() {
        stdDev = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Stddev");
    }
    public void updateHigh() {
        highestGrade = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "High");
    }
    public void updateLow() {
        lowestGrade = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Low");
    }
    public void updatePassCount() {
        passCount = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Pass");
    }
    public void updateFailCount() {
        failCount = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Fail");
    }
    public void updateWithdrewCount() {
        withdrewCount = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Withdrew");
    }
    public void updateAuditCount() {
        auditCount = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Audit");
    }
    public void updateOtherCount() {
        otherCount = data.getUBCCourseDataAsString(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "Other");
    }

    public void updateZeroesRange() {
        zerosRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "0-9");
    }

    public void updateTensRange() {
        tensRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "10-19");
    }
    public void updateTwentiesRange() {
        twentiesRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "20-29");
    }
    public void updateThirtiesRange() {
        thirtiesRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "30-39");
    }
    public void updateFortiesRange() {
        fortiesRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "40-49");
    }
    public void updateFiftiesFirstHalfRange() {
        fiftiesFirstHalfRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "50-54");

    }
    public void updateFiftiesSecondHalfRange() {
        fiftiesSecondHalfRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "55-59");
    }

    public void updateSixtiesFirstRange() {
        sixtiesFirstRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "60-63");
    }
    public void updateSixtiesSecondRange() {
        sixtiesSecondRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "64-67");
    }

    public void updateSixtiesThirdRange() {
        sixtiesThirdRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "68-71");
    }

    public void updateSeventiesFirstRange() {
        seventiesFirstRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "72-75");
    }
    public void updateSeventiesSecondRange() {
        seventiesSecondRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "76-79");
    }
    public void updateEightiesFirstHalfRange() {
        eightiesFirstHalfRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "80-84");
    }
    public void updateEightiesSecondHalfRange() {
        eightiesSecondHalfRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "85-89");
    }
    public void updateNinetiesRange() {
        ninetiesRange = data.getUBCCourseDataAsInteger(selectedYear, selectedSession, selectedSubject, selectedCourse,
                selectedSection, "90-100");

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

        updateZeroesRange();
        updateTensRange();
        updateTwentiesRange();
        updateThirtiesRange();
        updateFortiesRange();
        updateFiftiesFirstHalfRange();
        updateFiftiesSecondHalfRange();

        updateSixtiesFirstRange();
        updateSixtiesSecondRange();
        updateSixtiesThirdRange();

        updateSeventiesFirstRange();
        updateSeventiesSecondRange();

        updateEightiesFirstHalfRange();
        updateEightiesSecondHalfRange();

        updateNinetiesRange();
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

