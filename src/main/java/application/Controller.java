package application;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Locale;


public class Controller {

    @FXML
    private ComboBox<Integer> yearChoice;

    @FXML
    private ComboBox<String> sessionChoice;

    @FXML
    private ComboBox<String> subjectChoice;

    @FXML
    private ComboBox<Integer> courseChoice;

    @FXML
    private ComboBox<String> sectionChoice;

    @FXML
    private Text courseLabel;
    @FXML
    private Text professorLabel;
    @FXML
    private Text enrolledLabel;
    @FXML
    private Text averageLabel;
    @FXML
    private Text stdDevLabel;
    @FXML
    private Text highLabel;
    @FXML
    private Text lowLabel;
    @FXML
    private Text passLabel;
    @FXML
    private Text failLabel;
    @FXML
    private Text withdrewLabel;
    @FXML
    private Text auditLabel;
    @FXML
    private Text otherLabel;

    @FXML
    private BarChart<String, Integer> gradeGraph;

    private Model model;

    public void initialize() {
        model = new Model();
        yearChoice.setItems(model.getYearList());
        sessionChoice.setItems(model.getSessionList());
        updateGraph();
    }

    public void handleComboBoxEvent(Event e) {
        ComboBox cb = (ComboBox) e.getSource();
        String id = cb.getId();
        Object value = cb.getValue();
            switch(id) {
            case "yearChoice":
                if (value != null) {
                    model.setSelectedYear((Integer) value);
                }
                break;
            case "sessionChoice":
                if (value != null) {
                    model.setSelectedSession((String) value);
                }
                break;
            case "subjectChoice":
                if (value != null) {
                    model.setSelectedSubject((String) value);
                }
                break;
            case "courseChoice":
                if (value != null) {
                    model.setSelectedCourse((Integer) value);
                }
                break;
            case "sectionChoice":
                if (value != null) {
                    model.setSelectedSection((String) value);
                }
                break;
        }
        model.updateLists();
        model.updateData();
        updateView();
    }

    public void updateView() {
        System.out.println("view updated");
        subjectChoice.setItems(model.getSubjectList());
        courseChoice.setItems(model.getCourseList());
        sectionChoice.setItems(model.getSectionList());

        courseLabel.setText(model.getCourseTitle());
        professorLabel.setText(model.getProfessor());
        enrolledLabel.setText(model.getEnrolled());
        averageLabel.setText((model.getAverage()));
        stdDevLabel.setText(model.getStdDev());
        highLabel.setText(model.getHighestGrade());
        lowLabel.setText(model.getLowestGrade());
        passLabel.setText(model.getPassCount());
        failLabel.setText(model.getFailCount());
        withdrewLabel.setText(model.getWithdrewCount());
        auditLabel.setText(model.getAuditCount());
        otherLabel.setText(model.getOtherCount());

        updateGraph();
    }

    public void updateGraph() {
        System.out.println("graph updated");
        gradeGraph.getData().clear();
        XYChart.Series grades = new XYChart.Series();

        grades.getData().add(new XYChart.Data("0-9", model.getZerosRange()));
        grades.getData().add(new XYChart.Data("10-10", model.getTensRange()));
        grades.getData().add(new XYChart.Data("20-29", model.getTwentiesRange()));
        grades.getData().add(new XYChart.Data("30-39", model.getThirtiesRange()));
        grades.getData().add(new XYChart.Data("40-49", model.getFortiesRange()));
        grades.getData().add(new XYChart.Data("50-54", model.getFiftiesFirstHalfRange()));
        grades.getData().add(new XYChart.Data("55-59", model.getFiftiesSecondHalfRange()));
        grades.getData().add(new XYChart.Data("60-63", model.getSixtiesFirstRange()));
        grades.getData().add(new XYChart.Data("64-67", model.getSixtiesSecondRange()));
        grades.getData().add(new XYChart.Data("68-71", model.getSixtiesThirdRange()));
        grades.getData().add(new XYChart.Data("72-75", model.getSeventiesFirstRange()));
        grades.getData().add(new XYChart.Data("76-79", model.getSeventiesSecondRange()));
        grades.getData().add(new XYChart.Data("80-84", model.getEightiesFirstHalfRange()));
        grades.getData().add(new XYChart.Data("85-89", model.getEightiesSecondHalfRange()));
        grades.getData().add(new XYChart.Data("90-100", model.getNinetiesRange()));

        gradeGraph.getData().add(grades);
    }


}

