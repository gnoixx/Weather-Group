package weathergroup.weatherapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WeatherModel {
    private final StringProperty city = new SimpleStringProperty("Minneapolis");
    private final StringProperty current_temp = new SimpleStringProperty("40ºF");

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCurrent_temp() {
        return current_temp.get();
    }

    public StringProperty current_tempProperty() {
        return current_temp;
    }

    public void setCurrent_temp(String current_temp) {
        this.current_temp.set(current_temp);
    }
}
