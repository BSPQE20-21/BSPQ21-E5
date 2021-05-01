package Main;

import database.DBException;
import database.DBManager;
import gui.VentanaPrincipal;
import gui.VentanaSalidas;

public class Main {

	public static void main(String[] args) throws DBException {
		
		VentanaPrincipal vp = new VentanaPrincipal(null);
		vp.setVisible(true);
//		
//		VentanaLlegadas vl = new VentanaLlegadas();
//		vl.setVisible(true);
		
//		VentanaSalidas vs = new VentanaSalidas();
//		vs.setVisible(true);

		DBManager.getInstance().preparedData();
	}
}
