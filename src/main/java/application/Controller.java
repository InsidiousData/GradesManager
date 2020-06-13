package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller {

    @FXML
    private ChoiceBox<String> yearChoice;

    @FXML
    private ChoiceBox<String> sessionChoice;

    @FXML
    private ChoiceBox<String> subjectChoice;

    @FXML
    private ChoiceBox<String> courseChoice;

    private Model model;

    public void initialize() {
        model = new Model();
        yearChoiceLoader();
        sessionChoiceLoader();
        subjectChoiceLoader();
    }

    public void yearChoiceLoader() {
        yearChoice.setItems(model.getYearObservableList());
        yearChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                subjectChoiceLoader();
            }
        });
    }

    public void sessionChoiceLoader() {
        sessionChoice.setItems(model.getSessionObservableList());
        sessionChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                subjectChoiceLoader();
            }
        });
    }

    public void subjectChoiceLoader() {
//        if ((yearChoice.getSelectionModel().getSelectedItem() == null) ||
//                (sessionChoice.getSelectionModel().getSelectedItem() == null)) {
//            subjectChoice.setItems(model.getSubjectObservableList());
//        } else {
        if ((yearChoice.getSelectionModel().getSelectedItem() != null) ||
               (sessionChoice.getSelectionModel().getSelectedItem() != null)) {
            System.out.println("Subject choices loaded.");
            int year = getYearChoiceValue();
            String session = getSessionChoiceValue();
                subjectChoice.setItems(model.getSubjectObservableList(year, session));
        }
    }

    public int getYearChoiceValue() {
        int i = Integer.parseInt(yearChoice.getSelectionModel().getSelectedItem().toString());
        return i;
    }

    public String getSessionChoiceValue() {
        String s = sessionChoice.getValue();
        return s;
    }

    public String getCourseChoiceValue() {
        String s = courseChoice.getValue();
        return s;
    }

        //TODO: use this listener structure to create dependent ChoiceBoxes
        //yearChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
          //  public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
          //      System.out.println("Testing");



}

