package es.termibus.data;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Trip {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int trip_ID;
	
	private String destiny; // Madrid .
	private String date; // 12/02/21 , 12:00
	private int busID;
	private int cost;
	private String hour;
	
	public Trip(int busID, int cost, String date,  String destiny, String hour ) {
		super();
		this.destiny = destiny;
		this.date = date;
		this.busID = busID;
		this.cost = cost;
		this.hour = hour;
	}
	
	public Trip() {
		super();
		this.destiny = "";
		this.date = "";
		this.busID = 0;
		this.cost = 0;
		this.hour = "";
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

	public int getTrip_ID() {
		return trip_ID;
	}

	public void setTrip_ID(int trip_ID) {
		this.trip_ID = trip_ID;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return destiny.toUpperCase() + " - " + date + " - " + hour;
	}
}
