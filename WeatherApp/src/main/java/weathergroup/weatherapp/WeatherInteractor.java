package weathergroup.weatherapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherInteractor {
    private static final String API_KEY = "9ac1fc34473d995eb859b35d17f73644";
    private final WeatherModel model;
    private final HttpClient client = HttpClient.newHttpClient();

    public WeatherInteractor(WeatherModel model) {
        this.model = model;
    }

    public void updateWeatherForCity(String city) {
        Location location = geocodeCity(city);
        if (location != null && location.getWeatherData() != null) {
            WeatherData weatherData = location.getWeatherData();
            model.setCity(city);
            model.setCurrentTemp(String.format("%.2f °F", weatherData.getTemperature('f')));
            model.setWindSpeed(String.format("%.2f m/s", weatherData.getWindSpeed()));
            model.setVisibility(String.format("%d meters", weatherData.getVisibility()));
            model.setSunrise(String.valueOf(weatherData.getSunrise())); // Convert or format as needed
            model.setSunset(String.valueOf(weatherData.getSunset())); // Convert or format as needed
            model.setHumidity(String.format("%d%%", weatherData.getHumidity()));
        } else {
            System.out.println("City not found.");
        }
    }

    private Location geocodeCity(String city) {
        String geocodeUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + city + "&limit=1&appid=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(geocodeUrl)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray jsonArray = new JSONArray(response.body());
            if (!jsonArray.isEmpty()) {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                double lat = jsonObject.getDouble("lat");
                double lon = jsonObject.getDouble("lon");
                WeatherData weatherData = fetchWeatherData(lat, lon);
                return new Location(city, "", weatherData);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private WeatherData fetchWeatherData(double lat, double lon) {
        String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s", lat, lon, API_KEY);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body());

            double temperature = jsonObject.getJSONObject("main").getDouble("temp");
            double windSpeed = jsonObject.getJSONObject("wind").getDouble("speed");
            long visibility = jsonObject.getLong("visibility");
            long sunrise = jsonObject.getJSONObject("sys").getLong("sunrise");
            long sunset = jsonObject.getJSONObject("sys").getLong("sunset");
            int humidity = jsonObject.getJSONObject("main").getInt("humidity");

            return new WeatherData(temperature, windSpeed, visibility, sunrise, sunset, humidity);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
