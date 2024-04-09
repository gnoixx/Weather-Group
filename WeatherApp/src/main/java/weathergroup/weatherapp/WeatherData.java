package weathergroup.weatherapp;

public class WeatherData {
<<<<<<< HEAD
	private double temperature; // in Kelvin
	private double windSpeed; // in m/s
	private long visibility; // in meters
	private long sunrise; // Unix UTC
	private long sunset; // Unix UTC
	private int humidity; // Percentage

	public WeatherData(double temperature, double windSpeed, long visibility, long sunrise, long sunset, int humidity) {
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.visibility = visibility;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.humidity = humidity;
	}

	// Getter and Setter methods
=======

	private Location loc;
	private double temperature, feelsLike, windSpeed, oneHourRain, oneHourSnow;
	private int humidity, timestampUTC, timeZoneOffset;
	private String weatherType, weatherDesc;
	
	public WeatherData(Location l, double temp, double feel, double wSpeed, double hourRain, double hourSnow,
			int hum, int tStamp, int tZone, String wType, String wDesc) {
		loc = l;
		temperature = temp;
		feelsLike = feel;
		windSpeed = wSpeed;
		oneHourRain = hourRain;
		oneHourSnow = hourSnow;
		humidity = hum;
		timestampUTC = tStamp;
		timeZoneOffset = tZone;
		weatherType = wType;
		weatherDesc = wDesc;
	}

	public Location getLoc() {
		return loc;
	}

>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getTemperature(char units) {
		switch (units) {
			case 'f': // Convert to Fahrenheit
				return (this.temperature - 273.15) * 9/5 + 32;
			case 'c': // Convert to Celsius
				return this.temperature - 273.15;
			case 'k': // Already in Kelvin
			default:
				return this.temperature;
		}
<<<<<<< HEAD
=======
		return feelsLike;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public double getOneHourRain() {
		return oneHourRain;
	}

	public double getOneHourSnow() {
		return oneHourSnow;
	}

	public int getHumidity() {
		return humidity;
	}

	public int getTimestampUTC() {
		return timestampUTC;
>>>>>>> a3a2a7bc15e595fef15ec01f753f0654ce9a18e8
	}


	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public long getVisibility() {
		return visibility;
	}

	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
}
