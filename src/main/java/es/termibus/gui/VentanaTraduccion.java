package es.termibus.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.termibus.data.Language;

public class VentanaTraduccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTraduccion frame = new VentanaTraduccion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTraduccion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEus = new JButton("ES");
		btnEus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Language.lang = ResourceBundle.getBundle("SystemMessages",	Locale.forLanguageTag("es"));
				
				new VentanaPrincipal(new VentanaInicioSesion().getUser()).setVisible(true);
				setVisible(false);				
			}
		});
		btnEus.setBounds(56, 107, 135, 52);
		contentPane.add(btnEus);
		
		JButton btnEus_1 = new JButton("EUS");
		btnEus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Language.lang = ResourceBundle.getBundle("SystemMessages",	Locale.forLanguageTag("eu"));
				
				new VentanaPrincipal(new VentanaInicioSesion().getUser()).setVisible(true);
				setVisible(false);
			}
		});
		btnEus_1.setBounds(56, 45, 135, 52);
		contentPane.add(btnEus_1);
		
		JButton btnEn = new JButton("EN");
		btnEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Language.lang = ResourceBundle.getBundle("SystemMessages",	Locale.forLanguageTag("en"));
				
				new VentanaPrincipal(new VentanaInicioSesion().getUser()).setVisible(true);
				setVisible(false);
			}
		});
		btnEn.setBounds(56, 169, 135, 52);
		contentPane.add(btnEn);
	}
}
