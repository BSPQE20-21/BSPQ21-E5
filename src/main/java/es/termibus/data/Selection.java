package es.termibus.data;

public class Selection {

	private String city;
	private String date;
	private String hour;

	public Selection(String city, String date, String hour) {
		this.city = city;
		this.date = date;
		this.hour = hour;
	}
	
	public Selection() {
		this.city = "";
		this.date = "";
		this.hour = "";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return city.toUpperCase() + " - " + date + " - " + hour;
	}
}