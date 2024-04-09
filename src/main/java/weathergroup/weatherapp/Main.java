package weathergroup.weatherapp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
    Much of the code here was created by following PragmaticCoding's blog posts: https://www.pragmaticcoding.ca/
    The GUI is currently using hardcoded values. In the future it will be pulling data from a weather API
 */

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new WeatherController().getView(), 500, 600);
        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
