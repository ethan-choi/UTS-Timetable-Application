/**
 *
 * @author ethan
 */


package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import au.edu.uts.ap.javafx.*;


public class AddStudentController extends Controller<University> {

    public final University getUniversity() {
        return (University) this.model;
    }

    @FXML
    private TextField studentNumberTf;
    @FXML
    private TextField studentNameTf;
    @FXML
    private CheckBox scholarshipCb;
    @FXML
    private ToggleGroup attendanceTg;
    @FXML
    private Button addStudentBtn;
    @FXML
    private Text errorText;

    
    
    @FXML
    private void initialize() {
        attendanceTg.selectedToggleProperty().addListener((observer, oldValue, newValue) -> {
            enableButtons();
        });
        studentNumberTf.textProperty().addListener((observer, oldValue, newValue) -> {
            enableButtons();
        });
        studentNameTf.textProperty().addListener((observer, oldValue, newValue) -> {
            enableButtons();
        });
    }

    //enable add button only if fields are not empty/unchecked i.e. validators return true
    private void enableButtons() {
        addStudentBtn.setDisable(!studentNumberValidator() || !studentNameValidator() || !studentAttendancevalidator());
    }

    //checking if fields are blank/unchecked. If empty, return false
    private boolean studentNumberValidator() {
        return (getStudentNumber().length() > 0);
    }

    private boolean studentNameValidator() {
        return (getStudentName().length() > 0);
    }

    private boolean studentAttendancevalidator() {
        return getStudentAttendance() != null;
    }

    //getters
    private String getStudentNumber() {
        return studentNumberTf.getText();
    }

    private String getStudentName() {
        return studentNameTf.getText();
    }

    private String getStudentAttendance() {
        return attendanceTg.getSelectedToggle() == null ? null : attendanceTg.getSelectedToggle().getUserData().toString();
    }

    private boolean hasScholarship() {
        return scholarshipCb.isSelected();
    }

    
    
    //functions
    
    //add student to list if student number does not already exist. If it does, return error message
    @FXML
    private void handleAdd(ActionEvent event) throws Exception {
        try {
            this.errorText.setText("");
            getUniversity().addStudent(getStudentNumber(), getStudentName(), getStudentAttendance(), hasScholarship());
            this.stage.close();
        } catch (Exception exception) {
            this.errorText.setText("Student already exists");
        }
    }

    
    //close window when cancel button is pressed
    @FXML
    private void handleCancel(ActionEvent event) throws Exception {
        this.stage.close();
    }
}
