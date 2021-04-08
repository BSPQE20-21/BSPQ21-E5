
public class DB {
	
	private static DB newDB;
	
	public DB() {	
	}
	
	public static DB getInstance() {	// Singleton usage to instance the DB only once at a time
		if(null == newDB) {
			newDB = new DB();
		}
		return newDB;
	}
}
