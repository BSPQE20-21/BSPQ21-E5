package es.termibus.util;

import es.termibus.database.DBException;
import es.termibus.database.DBManager;

public class PreparedData {

	public static void main(String args[]) {
		DBManager db = DBManager.getInstance();

		try {
			db.preparedData();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
