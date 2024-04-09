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
        String zipCode = "55109";

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
                double feelsLike = extractFeelsLike(responseBody);
                double windSpeed = extractWindSpeed(responseBody);
                double hourRain = extractHourRain(responseBody);
                double hourSnow = extractHourSnow(responseBody);
                int humid = extractHumidity(responseBody);
                int timestamp = extractTimestampUTC(responseBody);
                int timezone = extractTimezone(responseBody);
                String weatherType = extractWeatherType(responseBody);
                String weatherDesc = extractWeatherDesc(responseBody);

                Location loc = new Location(city, zipCode);
                WeatherData wData = new WeatherData(loc, temperatureKelvin, feelsLike, windSpeed, hourRain, hourSnow, humid, timestamp, timezone, weatherType, weatherDesc);
                loc.setWeatherData(wData);

                //public WeatherData(Location l, double temp, double feel, double windSpeed, double hourRain, double hourSnow,
                //			int hum, int tStamp, int tZone, String wType, String wDesc)

                //System.out.println("Temperature: " + temperatureFahrenheit + " °F");
                //System.out.println("Wind Speed: " + windSpeed + " m/s");
                System.out.println("Temperature: " + wData.getTemperature('F') + " °F");
                System.out.println("Wind Speed: " + wData.getWindSpeed() + " m/s");
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
        Pattern pattern = Pattern.compile("(\"temp\":\\s*)(\\d*[.]\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Double.parseDouble(matcher.group(2)); //Extract the temperature value in K.
        } else {
            throw new IllegalArgumentException("Temperature not found in JSON response");
        }
        /*
        int startIndex = responseBody.indexOf("\"temp\":") + 7;
        int endIndex = responseBody.indexOf(",", startIndex);
        String temperatureStr = responseBody.substring(startIndex, endIndex);
        return Double.parseDouble(temperatureStr); //Extract the temperature value, which is in K.
        */
    }

    // Method to extract wind speed from JSON response
    // Method to extract wind speed from JSON response using regular expression
    private static double extractWindSpeed(String responseBody)
    {
        // Define regular expression pattern to match the wind speed value
        Pattern pattern = Pattern.compile("\"speed\":(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(responseBody);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1)); // Extract the wind speed value, which is in m/s.
        } else {
            throw new IllegalArgumentException("Wind speed not found in JSON response");
        }
    }



    private static double extractFeelsLike(String responseBody){
        Pattern pattern = Pattern.compile("(\"feels_like\":\\s*)(\\d*[.]\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Double.parseDouble(matcher.group(2));
        } else {
            throw new IllegalArgumentException("\"Feels like\" not found in JSON response");
        }
    }

    private static double extractHourRain(String responseBody){
        Pattern pattern = Pattern.compile("(\"rain\": \\{\\s*\"1h\":\\s*)(\\d*[.]\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Double.parseDouble(matcher.group(2)); //Extracts volume of rain from the last hour, in mm.
        }
        else {
            return 0; //If no rain is found, returns 0.
            // Unlike other extracted values, rain and snow are not always included in the JSON if there is no rain or snow.
            // So instead of signifying a problem like missing the others might, it just means that there was no rain or snow in the last hour.
        }
    }

    private static double extractHourSnow(String responseBody){
        Pattern pattern = Pattern.compile("(\"snow\": \\{\\s*\"1h\":\\s*)(\\d*[.]\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Double.parseDouble(matcher.group(2)); //Extracts volume of snow from the last hour, in mm.
        }
        else {
            return 0; //If no snow is found, return 0;
        }
    }

    private static int extractHumidity(String responseBody){
        Pattern pattern = Pattern.compile("(\"humidity\":\\s*)(\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Integer.parseInt(matcher.group(2)); //Extracts the current humidity as an integer percentage.
        } else {
            throw new IllegalArgumentException("Humidity not found in JSON response");
        }
    }

    private static int extractTimestampUTC(String responseBody){
        Pattern pattern = Pattern.compile("(\"dt\":\\s*)(\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Integer.parseInt(matcher.group(2)); //Extracts the UTC timestamp in seconds.
        } else {
            throw new IllegalArgumentException("Timestamp not found in JSON response");
        }
    }

    private static int extractTimezone(String responseBody){
        Pattern pattern = Pattern.compile("(\"timezone\":\\s*)(\\d*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return Integer.parseInt(matcher.group(2)); //Extracts the timezone of the location in seconds offset from UTC.
        } else {
            throw new IllegalArgumentException("Timezone not found in JSON response");
        }
    }

    private static String extractWeatherType(String responseBody){
        Pattern pattern = Pattern.compile("(\"main\":\\s*\")([^\"]*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return matcher.group(2); //Extracts the basic type of the current weather (e.g. Rain, Snow, Clouds, etc.).
        } else {
            throw new IllegalArgumentException("Weather type not found in JSON response");
        }
    }

    private static String extractWeatherDesc(String responseBody){
        Pattern pattern = Pattern.compile("(\"description\":\\s*\")([^\"]*)");
        Matcher matcher = pattern.matcher(responseBody);
        if(matcher.find()) {
            return matcher.group(2); //Extracts the specific description of the current weather.
        } else {
            throw new IllegalArgumentException("Weather description not found in JSON response");
        }
    }

}

