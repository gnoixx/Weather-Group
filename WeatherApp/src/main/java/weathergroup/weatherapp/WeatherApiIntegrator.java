package weathergroup.weatherapp;

import java.util.List;

public interface WeatherApiIntegrator {

    /**
     * Fetches the current weather data for a specified location.
     *
     * @param "location" is location to fetch the weather data.
     * @return WeatherData instance containing the current weather information for the  location.
     */
    WeatherData getCurrentWeather(Location location);

    /**
     * Fetches the weather forecast for a specified location for a given number of days .
     *
     * @param "location" is location to fetch the weather data.
     * @param days       The number of days to fetch the forecast for.
     * @return A list of WeatherData instances, each representing the forecast for one day.
     */
    List<WeatherData> getWeatherForecast(Location location, int days);

    /**
     * Fetches historical weather data for a specified location over a given date range.
     *
     * @param "location" is location to fetch the weather data.
     * @param startDate  The start date of the range for which to fetch weather data.
     * @param endDate    The end date of the range for which to fetch weather data.
     * @return A list of WeatherData instances, each representing the weather on a given day in the specified range.
     */
    List<WeatherData> getHistoricalWeather(Location location, String startDate, String endDate);

    /**
     * Compares the current weather data between two locations.
     *
     * @param location1 The first location for comparison.
     * @param location2 The second location for comparison.
     * @return A WeatherComparison object containing the weather data for both locations and methods to compare various weather attributes.
     */
    WeatherComparison compareCurrentWeather(Location location1, Location location2);
}
