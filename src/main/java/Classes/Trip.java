package Classes;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Trip {

	
	private String destiny; // Madrid
	private String date; // 12/02/21 , 12:00
	private int busID;
	private int cost;
	
	public Trip(int busID, int cost, String date,  String destiny ) {
		super();
		this.destiny = destiny;
		this.date = date;
		this.busID = busID;
		this.cost = cost;
	}
	
	public Trip() {
		super();
		this.destiny = "";
		this.date = "";
		this.busID = 0;
		
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

	

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "\nOrigin: Bilbao\nDestiny: " + destiny + "\nDate: " + date + "\nBus: " + busID +  "\nCost: " + cost + "\n";
	}
}
