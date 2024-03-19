package weathergroup.weatherapp;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
    Much of the code here was created by following PragmaticCoding's blog posts: https://www.pragmaticcoding.ca/
    The GUI is currently using hardcoded values. In the future it will be pulling data from a weather API
 */

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    private final StringProperty city = new SimpleStringProperty("Minneapolis");
    private final StringProperty current_temp = new SimpleStringProperty("40ºF");

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 500, 600);
        primaryStage.setTitle("WeatherApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents(){
        VBox results = new VBox(60, createCityTemp(), createFiveDay());
        results.setAlignment(Pos.CENTER);
        results.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        return results;
    }

    private Node createCityTemp(){
        Label cityLabel = styledLabel("", "city-label");
        cityLabel.textProperty().bind(city);
        Label tempLabel = styledLabel("", "temp-label");
        tempLabel.textProperty().bind(current_temp);

        HBox hbox = new HBox(30, createHumidityWind("Humidity", "25%"),
                createHumidityWind("Windspeed", "10mi/h"));
        hbox.setAlignment(Pos.CENTER);

        VBox results = new VBox(4,
                new Button("Change Location"), cityLabel, tempLabel, getImage(), hbox);

        results.setAlignment(Pos.CENTER);
        return results;
    }

    private Node createHumidityWind(String type, String data){
        VBox vbox = new VBox(new Label(type), new Label(data));
        vbox.setAlignment(Pos.CENTER_LEFT);
        HBox results;
        Image image;
        if(type.equalsIgnoreCase("humidity"))
            image = new Image(this.getClass().getResource("humidity.jpg").toString());
        else if(type.equalsIgnoreCase("windspeed"))
            image = new Image(this.getClass().getResource("wind.jpg").toString());
        else image = new Image(this.getClass().getResource("humidity.jpg").toString());

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(50);
        results = new HBox(5, imageView, vbox);
        results.setAlignment(Pos.CENTER);
        return results;
    }

    private Node createDayTemp(String day){
        Label tempLabel = new Label();
        tempLabel.textProperty().bind(current_temp);
        VBox results = new VBox(4, new Label(day), tempLabel);

        results.setAlignment(Pos.CENTER);
        results.setMinWidth(80);
        results.getStyleClass().add("five-day-border");
        return results;
    }

    private Node getImage(){
        Image image = new Image(this.getClass().getResource("cloud.jpg").toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100);
        return imageView;
    }

    private Node createFiveDay(){
        HBox fiveDays = new HBox(16,
                createDayTemp("Monday"),
                createDayTemp("Tuesday"),
                createDayTemp("Wednesday"),
                createDayTemp("Thursday"),
                createDayTemp("Friday"));
        fiveDays.setAlignment(Pos.CENTER);

        VBox results = new VBox(2, styledLabel("5 Day Forecast:", "five-day-label"), fiveDays);
        results.setAlignment(Pos.CENTER);

        return results;
    }

    private Label styledLabel(String contents, String className){
        Label results = new Label(contents);
        results.getStyleClass().add(className);
        return results;
    }
}