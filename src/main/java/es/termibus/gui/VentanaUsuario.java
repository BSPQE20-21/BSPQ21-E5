package es.termibus.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario frame = new VentanaUsuario();
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
	public VentanaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Back");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtras.setBounds(10, 16, 120, 33);
		contentPane.add(btnAtras);
		
		JButton btnMisViajes = new JButton("My Trips");
		btnMisViajes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMisViajes.setBounds(54, 200, 150, 48);
		contentPane.add(btnMisViajes);
		
		JButton btnReclamar = new JButton("Claim");
		btnReclamar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReclamar.setBounds(54, 301, 150, 48);
		contentPane.add(btnReclamar);
		
		JList listaIdaVuelta = new JList();
		listaIdaVuelta.setEnabled(false);
		listaIdaVuelta.setBounds(249, 53, 500, 497);
		contentPane.add(listaIdaVuelta);
	}

}
