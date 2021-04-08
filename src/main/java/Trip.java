
public class Trip {

	private String origin; // Bilbao
	private String destiny; // Madrid
	
	public Trip(String origin, String destiny) {
		super();
		this.origin = origin;
		this.destiny = destiny;
	}
	
	public Trip() {
		super();
		this.origin = "";
		this.destiny = "";
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	@Override
	public String toString() {
		return "Trip [origin=" + origin + ", destiny=" + destiny + "]";
	}
}
