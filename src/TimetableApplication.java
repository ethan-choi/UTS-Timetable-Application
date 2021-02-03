import au.edu.uts.ap.javafx.*;
import model.*;
import javafx.application.*;
import javafx.stage.*;

public class TimetableApplication extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        University univeristy = new University();
        ViewLoader.showStage(univeristy, "/view/university.fxml", "University", stage);
    }
}
