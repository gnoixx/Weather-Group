package weathergroup.weatherapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WeatherModel {
    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty currentTemp = new SimpleStringProperty();
    private final StringProperty windSpeed = new SimpleStringProperty();
    private final StringProperty visibility = new SimpleStringProperty();
    private final StringProperty sunrise = new SimpleStringProperty();
    private final StringProperty sunset = new SimpleStringProperty();
    private final StringProperty humidity = new SimpleStringProperty();

    // Getters and Setters
    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public String getCurrentTemp() {
        return currentTemp.get();
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp.set(currentTemp);
    }

    public StringProperty currentTempProperty() {
        return currentTemp;
    }

    public String getWindSpeed() {
        return windSpeed.get();
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed.set(windSpeed);
    }

    public StringProperty windSpeedProperty() {
        return windSpeed;
    }

    public String getVisibility() {
        return visibility.get();
    }

    public void setVisibility(String visibility) {
        this.visibility.set(visibility);
    }

    public StringProperty visibilityProperty() {
        return visibility;
    }

    public String getSunrise() {
        return sunrise.get();
    }

    public void setSunrise(String sunrise) {
        this.sunrise.set(sunrise);
    }

    public StringProperty sunriseProperty() {
        return sunrise;
    }

    public String getSunset() {
        return sunset.get();
    }

    public void setSunset(String sunset) {
        this.sunset.set(sunset);
    }

    public StringProperty sunsetProperty() {
        return sunset;
    }

    public String getHumidity() {
        return humidity.get();
    }

    public void setHumidity(String humidity) {
        this.humidity.set(humidity);
    }

    public StringProperty humidityProperty() {
        return humidity;
    }
}