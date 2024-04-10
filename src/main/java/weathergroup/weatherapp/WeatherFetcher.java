package weathergroup.weatherapp;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.image.Image;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 *  Code from PragmaticCoding:
 *  https://github.com/PragmaticCoding/WeatherFX/blob/master/src/main/java/ca/pragmaticcoding/weather/WeatherFetcher.java
 */
// TODO: fetch wind and humidity information
public class WeatherFetcher {

    private String apiKey = "";

    public WeatherFetcher() {
        InputStream stream = getClass().getResourceAsStream("/data/api.data");
        if (stream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            try {
                apiKey = reader.readLine();
            } catch (IOException e) {
                apiKey = "";
            }
        }
        if (apiKey.isEmpty()) {
            System.out.println("API key is blank!");
        }
    }

    public WeatherData checkWeather(String city, String state) {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("api.openweathermap.org")
                .addPathSegments("data/2.5/weather")
                .addQueryParameter("units", "imperial")
                .addQueryParameter("q", city + ", " + state + ", US")
                .addQueryParameter("appid", apiKey)
                .build();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = new OkHttpClient().newCall(request).execute();
            assert response.body() != null;
            JsonObject json = JsonParser.parseString(response.body().string()).getAsJsonObject();
            JsonObject weather = json.getAsJsonArray("weather").get(0).getAsJsonObject();
            String imageId = weather.get("icon").getAsString();
            WeatherData weatherData = new WeatherData();
            weatherData.setWeatherImage(new Image("http://openweathermap.org/img/wn/" + imageId + "@4x.png"));
            weatherData.setTemperature(json.getAsJsonObject("main").get("temp").getAsString()+"ºF");
            weatherData.setConditions(weather.get("main").getAsString());
            return weatherData;
        } catch (IOException e) {
            e.printStackTrace();
            return new WeatherData();
        }
    }


}