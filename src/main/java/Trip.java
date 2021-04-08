
public class Trip {

	private String destiny; // Madrid
	private String date; // 12/02/21 , 12:00
	private int busID;
	private String tripCode;
	int cost;
	
	public Trip(String destiny, String date, int busID, String tripCode, int cost) {
		super();
		this.destiny = destiny;
		this.date = date;
		this.busID = busID;
		this.tripCode = tripCode;
		this.cost = cost;
	}
	
	public Trip() {
		super();
		this.destiny = "";
		this.date = "";
		this.busID = 0;
		this.tripCode = "";
		this.cost = 0;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
	}

	public String getTripCode() {
		return tripCode;
	}

	public void setTripCode(String tripCode) {
		this.tripCode = tripCode;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "\nOrigin: Bilbao\nDestiny: " + destiny + "\nDate: " + date + "\nBus: " + busID + "\nTrip Code: " + tripCode + "\nCost: " + cost + "\n";
	}
}
