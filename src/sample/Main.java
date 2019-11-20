package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * The {@code Application} class wraps the loading of javafx components
 * defined in <i>fxml</i> source. {@code Application} is the driver class
 * for the application.
 *
 * <p>In addition, this class provides several lines of code for launching
 * a GUI composed of {@code javafx.scene.Node} objects .
 *
 * @author  Scott Vanselow
 * @author  David Rose (editor)
 * @since   JDK13.1
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bike Database");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
