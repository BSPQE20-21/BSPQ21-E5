package es.termibus;

import es.termibus.database.DBException;
import es.termibus.gui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) throws DBException {
		
		VentanaPrincipal vp = new VentanaPrincipal(null);
		vp.setVisible(true);
//		
//		VentanaLlegadas vl = new VentanaLlegadas();
//		vl.setVisible(true);
		
//		VentanaSalidas vs = new VentanaSalidas();
//		vs.setVisible(true);
	}
}
