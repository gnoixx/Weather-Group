package weathergroup.weatherapp;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.Optional;

public class WeatherViewBuilder implements Builder<Region> {

    private final WeatherModel model;
    private final WeatherInteractor interactor; // Added interactor

    public WeatherViewBuilder(WeatherModel model) {
        this.model = model;
        this.interactor = new WeatherInteractor(model); // Initialize the interactor
    }

    @Override
    public Region build() {
        VBox results = new VBox(60, createCityTemp(), createFiveDay());
        results.setAlignment(Pos.CENTER);
        results.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        return results;
    }

    private Node createCityTemp() {
        Label cityLabel = styledLabel("", "city-label");
        cityLabel.textProperty().bind(model.cityProperty());

        Label tempLabel = styledLabel("", "temp-label");
        tempLabel.textProperty().bind(model.currentTempProperty());

        Button changeLocationButton = new Button("Change Location");
        changeLocationButton.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Change Location");
            dialog.setHeaderText("Look up a new city");
            dialog.setContentText("Please enter the city name:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(this.interactor::updateWeatherForCity);
        });

        HBox hbox = new HBox(30,
                createHumidityWind("Humidity", model.getHumidity()),
                createHumidityWind("Wind Speed", model.getWindSpeed()));
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(4, changeLocationButton, cityLabel, tempLabel, getImage(), hbox);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

    private Node createHumidityWind(String type, String data) {
        Label dataLabel = new Label(data);
        if (type.equalsIgnoreCase("Humidity")) {
            dataLabel.textProperty().bind(model.humidityProperty());
        } else if (type.equalsIgnoreCase("Wind Speed")) {
            dataLabel.textProperty().bind(model.windSpeedProperty());
        }

        VBox vbox = new VBox(new Label(type), dataLabel);
        vbox.setAlignment(Pos.CENTER_LEFT);

        Image image = new Image(this.getClass().getResource(type.equalsIgnoreCase("Humidity") ? "humidity.jpg" : "wind.jpg").toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(50);

        HBox hbox = new HBox(5, imageView, vbox);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private Node getImage() {
        Image image = new Image(this.getClass().getResource("cloud.jpg").toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100);
        return imageView;
    }

    private Node createFiveDay() {
        // Assuming createDayTemp and other relevant methods are implemented correctly
        HBox fiveDays = new HBox(16, createDayTemp("Monday"), createDayTemp("Tuesday"), createDayTemp("Wednesday"), createDayTemp("Thursday"), createDayTemp("Friday"));
        fiveDays.setAlignment(Pos.CENTER);

        VBox results = new VBox(2, styledLabel("5 Day Forecast:", "five-day-label"), fiveDays);
        results.setAlignment(Pos.CENTER);

        return results;
    }

    private Node createDayTemp(String day) {
        Label tempLabel = new Label();
        tempLabel.textProperty().bind(model.currentTempProperty());
        VBox vbox = new VBox(4, new Label(day), tempLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(80);
        vbox.getStyleClass().add("five-day-border");
        return vbox;
    }

    private Label styledLabel(String contents, String className) {
        Label label = new Label(contents);
        label.getStyleClass().add(className);
        return label;
    }
}
