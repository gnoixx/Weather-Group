package weathergroup.weatherapp;

import java.util.Date;

public class WeatherData {

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

	public double getTemperature() {
		return temperature;
	}
	
	//Accepts 'k'/'K' for Kelvin (default), 'c'/'C' for Celsius, and 'f'/'F' for Fahrenheit. Returns default (Kelvin) otherwise.
	public double getTemperature(char units) {
		switch (Character.toLowerCase(units)) {
		case 'k': return temperature;
		case 'c': return temperature - 273.15;
		case 'f': return (((temperature - 273.15) * 9)/5) + 32;
		}
		return temperature;
	}

	public double getFeelsLike() {
		return feelsLike;
	}
	
	//Same as getTemperature(char) above.
	public double getFeelsLike(char units) {
		switch (Character.toLowerCase(units)) {
		case 'k': return feelsLike;
		case 'c': return feelsLike - 273.15;
		case 'f': return (((feelsLike - 273.15) * 9)/5) + 32;
		}
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
	}

	public int getTimeZoneOffset() {
		return timeZoneOffset;
	}
	
	public Date getLocalTimestamp() {
		long localTimestamp = timestampUTC - timeZoneOffset;
		Date localDate = new Date(localTimestamp);
		return localDate;
	}

	public String getWeatherType() {
		return weatherType;
	}

	public String getWeatherDesc() {
		return weatherDesc;
	}

	public void setLoc(Location l) {
		loc = l;
	}

	public void setTemperature(double t) {
		temperature = t;
	}

	public void setFeelsLike(double fL) {
		feelsLike = fL;
	}

	public void setOneHourRain(double oHR) {
		oneHourRain = oHR;
	}

	public void setOneHourSnow(double oHS) {
		oneHourSnow = oHS;
	}

	public void setHumidity(int hum) {
		humidity = hum;
	}

	public void setTimestampUTC(int tsUTC) {
		timestampUTC = tsUTC;
	}

	public void setTimeZoneOffset(int tZOff) {
		timeZoneOffset = tZOff;
	}

	public void setWeatherType(String wT) {
		weatherType = wT;
	}

	public void setWeatherDesc(String wD) {
		weatherDesc = wD;
	}	
}
