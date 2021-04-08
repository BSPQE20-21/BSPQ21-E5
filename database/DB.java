import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
	
	private static DB newDB;
	static Connection conn;
	
	public DB() {
		 try {
	            Class.forName("org.sqlite.JDBC");
	        } catch (ClassNotFoundException e) {
	            System.out.println("No se pudo cargar el driver de BD");
	        }
	        try {
	            conn = DriverManager.getConnection("jdbc:sqlite:termibus.db");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Error en la BD");
	        }
	}
	
	public static DB getInstance() {	// Singleton usage to instance the DB only once at a time
		if(null == newDB) {
			newDB = new DB();
		}
		return newDB;
	}
	
	public List<Trip> getTrips() throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * from Trip")){

           ArrayList<Trip> trips = new ArrayList<>();

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    Trip trip = new Trip(rs.getString("destiny"),
                    		rs.getString("date"),
                    		rs.getInt("busID"),
                    		rs.getString("tripCode"),
                    		rs.getInt("cost")
                    );
                    trips.add(trip);
                }
            }
            return trips;
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Something went wrong with the database", e);
        }
    }
}
