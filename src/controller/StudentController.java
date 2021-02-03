/**
 *
 * @author ethan
 */


package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Student;


public class StudentController extends Controller<Student> {

    @FXML
    private Text scholarshipText;

    @FXML

    public final Student getStudent() {
        return (Student) this.model;
    }

    //Translates scholarship from boolean true/false to yes/no
    @FXML
    private void initialize() {
        if (this.getStudent().getScholarship()) {
            scholarshipText.setText("Yes");
        } else {
            scholarshipText.setText("No");
        }

    }

    // close window when logout is pressed
    @FXML
    private void handleLogout(ActionEvent event) {
        this.stage.close();
    }
    
    
    
}
