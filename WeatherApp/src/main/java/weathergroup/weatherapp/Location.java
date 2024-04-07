package weathergroup.weatherapp;

public class Location
{

	private String city;
	private String zipCode;
	private WeatherData weatherData;
	//private double longitude, latitude; //Maybe? Just an idea if we want to store the long/lat as well.
	
	public Location(String city, String zipCode, WeatherData weatherData)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = weatherData;
	}

	public Location(String city, String zipCode)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = null;
	}
	
	public String getCity() 
	{
        return city;
    }

    public String getZipCode() 
    {
        return zipCode;
    }

    public WeatherData getWeatherData() 
    {
        return weatherData;
    }

	public void setWeatherData(WeatherData weatherData) {
		this.weatherData = weatherData;
	}
}
