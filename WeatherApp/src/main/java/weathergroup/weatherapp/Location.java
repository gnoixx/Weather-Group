package weathergroup.weatherapp;

public class Location
{

	private String city;
	private String zipCode;
	private WeatherData weatherData;
<<<<<<< HEAD

=======
	//private double longitude, latitude; //Maybe? Just an idea if we want to store the long/lat as well.
	
>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8
	public Location(String city, String zipCode, WeatherData weatherData)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = weatherData;
	}

<<<<<<< HEAD
	public String getCity()
=======
	public Location(String city, String zipCode)
	{
		this.city = city;
		this.zipCode = zipCode;
		this.weatherData = null;
	}
	
	public String getCity() 
>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8
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
