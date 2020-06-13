package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;


public class Controller {

    @FXML
    private ComboBox<Integer> yearChoice;

    @FXML
    private ComboBox<String> sessionChoice;

    @FXML
    private ComboBox<String> subjectChoice;

    @FXML
    private ComboBox<Integer> courseChoice;

    private Model model;
    private SQLConnection sql;

    public void initialize() {
        model = new Model();
        sql = new SQLConnection();
        sql.connect();
        yearChoiceLoader();
        sessionChoiceLoader();
    }

    public void yearChoiceLoader() {
        yearChoice.setItems(model.getYearObservableList(sql));
        yearChoice.setOnAction((event) -> updateAllChoices());
    }

    public void sessionChoiceLoader() {
        sessionChoice.setItems(model.getSessionObservableList(sql));
        sessionChoice.setOnAction((event) -> updateAllChoices());
    }

    public void subjectChoiceLoader() {
        if ((yearChoice.getSelectionModel().getSelectedItem() != null) &&
               (sessionChoice.getSelectionModel().getSelectedItem() != null)) {
            System.out.println("Subject choices loaded.");
            int year = getYearChoiceValue();
            String session = getSessionChoiceValue();
            long startTime = System.nanoTime();
            subjectChoice.setItems(model.getSubjectObservableList(sql, year, session));
            long endTime = System.nanoTime();
            System.out.println(endTime-startTime);
        }
        subjectChoice.setOnAction((event) -> updateAllChoices());
    }

    public void courseChoiceLoader() {
        if ((yearChoice.getSelectionModel().getSelectedItem() != null) &&
                (sessionChoice.getSelectionModel().getSelectedItem() != null) &&
                (subjectChoice.getSelectionModel().getSelectedItem() != null)) {
            System.out.println("Course choices loaded.");
            int year = getYearChoiceValue();
            String session = getSessionChoiceValue();
            String subject = getSubjectChoiceValue();
            courseChoice.setItems(model.getCourseObservableList(sql, year, session, subject));
        }

    }

    private void updateAllChoices() {
        subjectChoiceLoader();
        courseChoiceLoader();
    }

    public int getYearChoiceValue() {
        int i = yearChoice.getSelectionModel().getSelectedItem();
        return i;
    }

    public String getSessionChoiceValue() {
        String s = sessionChoice.getValue();
        return s;
    }

    public String getSubjectChoiceValue() {
        String s = subjectChoice.getValue();
        return s;
    }

    public int getCourseChoiceValue() {
        int s = courseChoice.getValue();
        return s;
    }

        //TODO: use this listener structure to create dependent ChoiceBoxes
        //yearChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
          //  public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
          //      System.out.println("Testing");



}

