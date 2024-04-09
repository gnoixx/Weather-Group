package weathergroup.weatherapp;

import java.util.Arrays;
import java.util.List;

public class WeatherInteractor {
    private final WeatherModel model;
    private final WeatherFetcher weatherFetcher = new WeatherFetcher();
    private WeatherData weatherData;

    public WeatherInteractor(WeatherModel model) {
        this.model = model;
        model.setCity("Minneapolis");
        model.setStates(createAbbrList());
        weatherData = weatherFetcher.checkWeather(model.getCity());
        updateWeatherModel();
    }

    public void checkWeather() {
        weatherData = weatherFetcher.checkWeather(model.getCity());
    }

    public void updateWeatherModel() {
        model.setCurrentTemp(weatherData.getTemperature());
        model.setConditions(weatherData.getConditions());
        model.setIcon(weatherData.getWeatherImage());
    }

    private List<String> createAbbrList(){
        return Arrays.asList(
                "AL", "AK", "AZ", "AR", "AS",
                "CA", "CO", "CT",
                "DE", "DC", "FL", "GA", "HI",
                "ID", "IL", "IN", "IA",
                "KS", "KY", "LA",
                "ME", "MD", "MA", "MI", "MN",
                "MS", "MO", "MT",
                "NE", "NV", "NH", "NJ", "NM",
                "NY", "NC", "ND",
                "OH", "OK", "OR",
                "PA", "RI", "SC", "SD",
                "TN", "TX", "UT", "VT", "VA",
                "WA", "WV", "WI", "WY"
                );
    }
}
