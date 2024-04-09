package weathergroup.weatherapp;

public class WeatherData {
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
