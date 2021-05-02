package es.termibus.data;

public class Selection {

	String city;
	String date;
	
	public Selection(String city, String date) {
		this.city = city;
		this.date = date;
	}
	
	public Selection() {
		this.city = "";
		this.date = "";
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

	@Override
	public String toString() {
		return city.toUpperCase() + " - " + date;
	}
}
