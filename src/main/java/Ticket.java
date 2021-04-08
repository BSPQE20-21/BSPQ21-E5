
public class Ticket extends Trip {
	
	private int busID; // 07
	private String tripCode; // 3EF2JK
	private float cost; // 70.5
	
	public Ticket(String origin, String destiny, int busID, String tripCode, float cost) {
		super(origin, destiny);
		this.busID = busID;
		this.tripCode = tripCode;
		this.cost = cost;
	}	
	
	public Ticket() {
		super();
		this.busID = 0;
		this.tripCode = "";
		this.cost = 0;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Ticket [busID=" + busID + ", tripCode=" + tripCode + ", cost=" + cost + ", origin=" + getOrigin()
				+ ", destiny=" + getDestiny() + "]";
	}	
}