package weathergroup.weatherapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

// TODO: Update wind and humidity
public class WeatherViewBuilder implements Builder<Region> {

    private final WeatherModel model;
    private final Runnable sceneSwapper;
    public WeatherViewBuilder(WeatherModel model, Runnable sceneSwapper){
        this.model = model;
        this.sceneSwapper = sceneSwapper;
    }

    @Override
    public Region build() {
        VBox results = new VBox(60, createSceneChangeButton("Change Location"),
                createCityTemp(), createFiveDay());
        results.setAlignment(Pos.TOP_CENTER);
        results.setPadding(new Insets(20));
        results.getStyleClass().add("weather-region");
        return results;
    }

    private Node createCityTemp(){
        Label cityLabel = styledLabel("", "city-label");
        cityLabel.textProperty().bind(model.cityProperty());
        Label tempLabel = styledLabel("", "temp-label");
        tempLabel.textProperty().bind(model.current_tempProperty());

        HBox hbox = new HBox(30, createHumidityWind("Humidity", "25%"),
                createHumidityWind("Windspeed", "10mi/h"));
        hbox.setAlignment(Pos.CENTER);

        VBox results = new VBox(4, cityLabel, tempLabel, getWeatherIcon(), hbox);
        results.setAlignment(Pos.CENTER);
        return results;
    }

    private Node createSceneChangeButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setOnAction(evt -> sceneSwapper.run());
        return button;
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
        tempLabel.textProperty().bind(model.current_tempProperty());
        VBox results = new VBox(4, new Label(day), tempLabel);

        results.setAlignment(Pos.CENTER);
        results.setMinWidth(80);
        results.getStyleClass().add("five-day-border");
        return results;
    }

    private Node getWeatherIcon(){
        ImageView imageView = new ImageView();
        imageView.imageProperty().bind(model.iconProperty());
        imageView.setFitHeight(140);
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
