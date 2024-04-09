package weathergroup.weatherapp;

public class Location
{

	private String city;
	private String zipCode;
	private WeatherData weatherData;

	public Location(String city, String zipCode, WeatherData weatherData)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = weatherData;
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

}
