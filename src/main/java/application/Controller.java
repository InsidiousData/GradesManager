package application;

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
        yearChoice.setOnAction((event) -> subjectChoiceLoader());
    }

    public void sessionChoiceLoader() {
        sessionChoice.setItems(model.getSessionObservableList(sql));
        sessionChoice.setOnAction((event) -> subjectChoiceLoader());
    }

    public void subjectChoiceLoader() {
        if ((yearChoice.getSelectionModel().getSelectedItem() != null) &&
               (sessionChoice.getSelectionModel().getSelectedItem() != null)) {
            System.out.println("Subject choices loaded.");
            int year = getYearChoiceValue();
            String session = getSessionChoiceValue();
                subjectChoice.setItems(model.getSubjectObservableList(sql, year, session));
        }
        subjectChoice.setOnAction((event) -> courseChoiceLoader());

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

    public int getYearChoiceValue() {
        int i = Integer.parseInt(yearChoice.getSelectionModel().getSelectedItem());
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

    public String getCourseChoiceValue() {
        String s = courseChoice.getValue();
        return s;
    }

        //TODO: use this listener structure to create dependent ChoiceBoxes
        //yearChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
          //  public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
          //      System.out.println("Testing");



}

