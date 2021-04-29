package Main;

import database.DBException;
import database.DBManager;
import gui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) throws DBException {
		
		VentanaPrincipal vp = new VentanaPrincipal(null);
		vp.setVisible(true);

		DBManager.getInstance().preparedData();
	}
}
