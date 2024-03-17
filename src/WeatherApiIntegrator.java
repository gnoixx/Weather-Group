public interface WeatherApiIntegrator {

    double getTemp(char scale);
    double getFeelsLike(char scale);
    double getMinTemp(char scale);
    double getMaxTemp(char scale);
    int getPressure();
    int getHumidity();
    String getWeatherType();
    String getWeatherDesc();
    int getVisibility();
    double getWindSpeed(char scale);
    double getWindGust(char scale);
    int getWindDir();
    int getCloudiness();
    double getOneHourRain();
    double getOneHourSnow();
    int getTimestampUTC();
    int getTimeZoneOffset();
    int getLocalTimestamp();
    String getDateTimeUTC();
    String getLocalDateTime();
}
