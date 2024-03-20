/*
 * ?s are things that might not be implemented, but were in the api.
+ getData1 WeatherData
+ getData2 WeatherData
+ compareTemp(char): double
+ compareFeelsLike(char): double
+ compareMinTemp(char): double ?
+ compareMaxTemp(char): double ?
+ comparePressure(): int ?
+ compareHumidity(): int
+ getWeatherType(): String
+ getWeatherDesc(): String
+ compareVisibility(): int ?
+ compareWindSpeed(char): double ?
+ compareWindGust(char): double ?
+ compareWindDir(): int ?
+ compareCloudiness(): int ?
+ compareOneHourRain(): double
+ compareOneHourSnow(): double
+ toString(): String

 */


public class WeatherComparison {
	private WeatherData data1, data2;
	
	public WeatherComparison(WeatherData d1, WeatherData d2) {
		data1 = d1;
		data2 = d2;
	}
	
	public WeatherData getData1() {
		return data1;
	}
	
	public WeatherData getData2() {
		return data2;
	}
	
	/*"Compare" methods return the difference between data1 and data2's attributes.
	 *If the output is positive, data1's attribute is higher.
	 *If the output is negative, data2's attribute is higher.
	*/
	public double compareTemp() {
		return data1.getTemperature() - data2.getTemperature();
	}
	
	public double compareTemp(char units) {
		return data1.getTemperature(units) - data2.getTemperature(units);
	}
	
	public double compareFeelsLike() {
		return data1.getFeelsLike() - data2.getFeelsLike();
	}

	public double compareFeelsLike(char units) {
		return data1.getFeelsLike(units) - data2.getFeelsLike(units);
	}
	
	public int compareHumidity() {
		return data1.getHumidity() - data2.getHumidity();
	}
	
	public double compareOneHourRain() {
		return data1.getOneHourRain() - data2.getOneHourRain();
	}
	
	public double compareOneHourSnow() {
		return data1.getOneHourSnow() - data2.getOneHourSnow();
	}
	
	//Spaces are in between each substring and punctuation to more easily handle processing by methods 
	//like String.split() using whitespace as a delimiter.
	public String getWeatherType() {
		return data1.getLoc().getCity() + " : " + data1.getWeatherType() + " . " 
					+ data2.getLoc().getCity() + " : " + data2.getWeatherType(); 
	}
	
	public String getWeatherDesc() {
		return data1.getLoc().getCity() + " : " + data1.getWeatherDesc() + " . " 
				+ data2.getLoc().getCity() + " : " + data2.getWeatherDesc(); 
	}
	
	public String toString() {
		return data1.getLoc().getCity() + " Temperature: " + data1.getTemperature() + " FeelsLike: " + data1.getFeelsLike() +
				" OneHourRain: " + data1.getOneHourRain() + " OneHourSnow: " + data1.getOneHourSnow() + " Humidity: " 
				+ data1.getHumidity() +	" TimestampUTC: " + data1.getTimestampUTC() + " TimeZoneOffset: " + data1.getTimeZoneOffset() 
				+ " LocalTime: " + data1.getLocalTimestamp().toString() 
				+ " . " + data2.getLoc().getCity() + " Temperature: " + data2.getTemperature() + " FeelsLike: " 
				+ data2.getFeelsLike() + " OneHourRain: " + data2.getOneHourRain() + " OneHourSnow: " + data2.getOneHourSnow() 
				+ " Humidity: "	+ data2.getHumidity() + " TimestampUTC: " + data2.getTimestampUTC() + " TimeZoneOffset: " 
				+ data2.getTimeZoneOffset() + " LocalTime: " + data2.getLocalTimestamp().toString();
	}
	
	public String toString(char units) {
		return data1.getLoc().getCity() + " Temperature: " + data1.getTemperature(units) + " FeelsLike: " + data1.getFeelsLike(units) +
				" OneHourRain: " + data1.getOneHourRain() + " OneHourSnow: " + data1.getOneHourSnow() + " Humidity: " 
				+ data1.getHumidity() +	" TimestampUTC: " + data1.getTimestampUTC() + " TimeZoneOffset: " + data1.getTimeZoneOffset() 
				+ " LocalTime: " + data1.getLocalTimestamp().toString() 
				+ " . " + data2.getLoc().getCity() + " Temperature: " + data2.getTemperature(units) + " FeelsLike: " 
				+ data2.getFeelsLike(units) + " OneHourRain: " + data2.getOneHourRain() + " OneHourSnow: " + data2.getOneHourSnow() 
				+ " Humidity: "	+ data2.getHumidity() + " TimestampUTC: " + data2.getTimestampUTC() + " TimeZoneOffset: " 
				+ data2.getTimeZoneOffset() + " LocalTime: " + data2.getLocalTimestamp().toString();
	}
}
