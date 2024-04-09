package weathergroup.weatherapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Finish adding abbr:city pairs to StateAbbr hashmap
public class WeatherModel {
<<<<<<< HEAD
    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty currentTemp = new SimpleStringProperty();
    private final StringProperty windSpeed = new SimpleStringProperty();
    private final StringProperty visibility = new SimpleStringProperty();
    private final StringProperty sunrise = new SimpleStringProperty();
    private final StringProperty sunset = new SimpleStringProperty();
    private final StringProperty humidity = new SimpleStringProperty();
=======
    private final StringProperty city = new SimpleStringProperty("Minneapolis");

    private final HashMap<String, String> StateAbbr = buildMap();
    private final StringProperty state = new SimpleStringProperty("MN");
    private final StringProperty current_temp = new SimpleStringProperty("40ºF");
    private final ObservableList<String> states = FXCollections.observableArrayList();
>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8

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

<<<<<<< HEAD
    public String getHumidity() {
        return humidity.get();
=======
    public String getState() {
        return StateAbbr.get(state.get());
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getCurrent_temp() {
        return current_temp.get();
>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8
    }

    public void setHumidity(String humidity) {
        this.humidity.set(humidity);
    }

    public StringProperty humidityProperty() {
        return humidity;
    }
<<<<<<< HEAD
}
=======

    public ObservableList<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states.setAll(states);
    }

    private HashMap<String, String> buildMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("AL", "Alabama");
        map.put("AK", "Alaska");
        map.put("AZ", "Arizona");
        map.put("AR", "Arkansas");
        map.put("CA", "California");
        map.put("CO", "Colorado");
        map.put("CT", "Connecticut");
        map.put("DE", "Delaware");
        map.put("DC", "District of Columbia");
        map.put("FL", "Florida");
        map.put("GA", "Georgia");
        map.put("HI", "Hawaii");
        map.put("ID", "Idaho");
        map.put("IL", "Illinois");
        map.put("IN", "Indiana");
        map.put("IA", "Iowa");
        map.put("KS", "Kansas");
        map.put("KY", "Kentucky");
        map.put("LA", "Louisiana");
        map.put("ME", "Maine");
        map.put("MD", "Maryland");
        map.put("MA", "Massachusetts");
        map.put("MI", "Michigan");
        map.put("MN", "Minnesota");
        return map;
    }
}
>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8
