package weatherapp;

import java.util.Date;

public abstract class Alert {
	private String name;
	private String description;
	private Date time;
	
	public Alert(String name, String description, Date time) {
		this.name = name;
		this.description = description;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	abstract void displayAlert();
}
