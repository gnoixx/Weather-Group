package weathergroup.weatherapp;

public class Location
{

	private String city;
	private String zipCode;
	private WeatherData weatherData;
	private String state;
	//private double longitude, latitude; //Maybe? Just an idea if we want to store the long/lat as well.
	
	public Location(String city, String zipCode, WeatherData weatherData, String state)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = weatherData;
		this.state = state;
	}

	public Location(String city, String zipCode, String state)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = null;
		this.state = state;
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

	public void setWeatherData(WeatherData weatherData)
	{
		this.weatherData = weatherData;
	}

	public String getState()
	{
		return state;
	}

}
