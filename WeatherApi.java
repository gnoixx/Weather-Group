package weathergroup.weatherapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class WeatherApi
{
    public static void main(String [] args)
    {
        String apiKey = "9ac1fc34473d995eb859b35d17f73644";

        String city = "Maplewood";

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200)
            {
                String responseBody = response.body();

                double temperatureKelvin = extractTemperature(responseBody);
                double temperatureFahrenheit = kelvinToFahrenheit(temperatureKelvin);
                double windSpeed = extractWindSpeed(responseBody);

                System.out.println("Temperature: " + temperatureFahrenheit + " °F");
                System.out.println("Wind Speed: " + windSpeed + " m/s");
            }
            else
            {
                System.out.println("Failed to fetch weather data. Status code: " + response.statusCode());
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static double kelvinToFahrenheit(double temperatureKelvin)
    {
        return (temperatureKelvin - 273.15) * 9 / 5 + 32;
    }


    private static double extractTemperature(String responseBody)
    {
        int startIndex = responseBody.indexOf("\"temp\":") + 7;
        int endIndex = responseBody.indexOf(",", startIndex);
        String temperatureStr = responseBody.substring(startIndex, endIndex);
        return Double.parseDouble(temperatureStr);
    }

    // Method to extract wind speed from JSON response
    // Method to extract wind speed from JSON response using regular expression
    private static double extractWindSpeed(String responseBody)
    {
        // Define regular expression pattern to match the wind speed value
        Pattern pattern = Pattern.compile("\"speed\":(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(responseBody);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1)); // Extract the wind speed value
        } else {
            throw new IllegalArgumentException("Wind speed not found in JSON response");
        }


    }


}

