package Main;

import BD.DBException;
import BD.DBManager;
import VentanaPrincipal.VentanaPrincipal;

public class Main {

	public static void main(String[] args) throws DBException {

//		VentanaRegistro vr = new VentanaRegistro();
//		vr.setVisible(true);

		VentanaPrincipal vp = new VentanaPrincipal(null);
		vp.setVisible(true);
//		
//		VentanaSalidas vs = new VentanaSalidas(null);
//		vs.setVisible(true);

		DBManager.getInstance().preparedData();
	}
}
