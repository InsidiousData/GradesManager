package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;


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

    private Model model;

    public void initialize() {
        model = new Model();
        setupModelListeners();
        yearChoice.setItems(model.getYearList());
        sessionChoice.setItems(model.getSessionList());
    }

    public void setupModelListeners() {
        yearChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            model.setSelectedYear(newValue);
            model.updateModel();
            updateView();
        });
        sessionChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            model.setSelectedSession(newValue);
            model.updateModel();
            updateView();
        });
        subjectChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.setSelectedSubject(newValue);
            }
            model.updateModel();
            updateView();
        });
        courseChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.setSelectedCourse(newValue);
            }
            model.updateModel();
            updateView();
        });
        sectionChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.setSelectedSection(newValue);
            }
            model.updateModel();
            updateView();
        });
    }

    public void updateView() {
        subjectChoice.setItems(model.getSubjectList());
        courseChoice.setItems(model.getCourseList());
        sectionChoice.setItems(model.getSectionList());
    }

}

