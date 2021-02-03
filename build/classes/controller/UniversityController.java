package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Activity;
import model.Student;
import model.University;

public class UniversityController extends Controller<University> {

    @FXML
    private ListView<Student> studentsLv;
    @FXML
    private Button loginStudentBtn;
    @FXML
    private Button removeStudentBtn;

    //disable buttons if nothing if selected from list. Enable if student is selected from list
    @FXML
    private void initialize() {
        studentsLv.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) -> {
            loginStudentBtn.setDisable(newValue == null);
        });
        studentsLv.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) -> {
            removeStudentBtn.setDisable(newValue == null);
        });
    }

    public final University getUniversity() {
        return (University) this.model;
    }

    
    //Open new add_student window
    @FXML
    private void handleAddStudent(ActionEvent event) throws Exception {
        ViewLoader.showStage(this.getUniversity(), "/view/add_student.fxml", "Add Student", new Stage());
    }

    //select current selected student on list and return
    private Student getSelectedStudent() {
        return studentsLv.getSelectionModel().getSelectedItem();
    }

    //get student and remove using universeity remove method
    @FXML
    private void handleRemoveStudent(ActionEvent event) {
        Student student = this.getSelectedStudent();
        getUniversity().remove(student);
    }

    //get student and remove using universeity remove method
    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        Student student = this.getSelectedStudent();
        ViewLoader.showStage(student, "/view/student.fxml", "Student", new Stage());
    }

}
