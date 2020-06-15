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
        yearChoice.setItems(model.getYearList());
        sessionChoice.setItems(model.getSessionList());
        setupListeners();
    }

    public void setupListeners() {
        yearChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {model.setSelectedYear(newValue);}
            model.updateLists();
            updateView();
        });
        sessionChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {model.setSelectedSession(newValue);}
            model.updateLists();
            System.out.println("test");
            updateView();
        });
        subjectChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {model.setSelectedSubject(newValue);}
            model.updateLists();
            updateView();
        });
        courseChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {model.setSelectedCourse(newValue);}
            model.updateLists();
            updateView();
        });
        sectionChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {model.setSelectedSection(newValue);}
            model.updateLists();
            updateView();
        });
    }

    public void updateView() {
        subjectChoice.setItems(model.getSubjectList());
        courseChoice.setItems(model.getCourseList());
        sectionChoice.setItems(model.getSectionList());
    }


}

