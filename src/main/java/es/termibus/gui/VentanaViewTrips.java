package es.termibus.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaViewTrips extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaViewTrips frame = new VentanaViewTrips();
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
	public VentanaViewTrips() {
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
		
		JButton btnIdaVuelta = new JButton("Round-trip ticket");
		
		btnIdaVuelta.addMouseListener(new MouseAdapter() {
			@Override
			//Al pulsar el boton habilita la jlist mostrando el toString de la clase Trip.
			public void mouseClicked(MouseEvent e) {
				//Una vez mostrada la lista, seleccionar un elemento y pulsar Reservar para guardar los datos.
				
				
			}
		});
		btnIdaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIdaVuelta.setBounds(54, 200, 150, 48);
		contentPane.add(btnIdaVuelta);
		
		JButton btnIdaSolo = new JButton("One-way ticket");
		btnIdaSolo.addMouseListener(new MouseAdapter() {
			@Override
			
				//Al pulsar el boton habilita la jlist mostrando el toString de la clase Trip.
			public void mouseClicked(MouseEvent e) {
				//Una vez mostrada la lista, seleccionar un elemento y pulsar Reservar para guardar los datos.
				
			}
		});
		btnIdaSolo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIdaSolo.setBounds(54, 301, 150, 48);
		contentPane.add(btnIdaSolo);
		
		JList listaIdaVuelta = new JList();
		listaIdaVuelta.setEnabled(false);
		listaIdaVuelta.setBounds(249, 53, 290, 497);
		contentPane.add(listaIdaVuelta);
		
		JList listIdaSolo = new JList();
		listIdaSolo.setEnabled(false);
		listIdaSolo.setBounds(392, 53, 260, 497);
		contentPane.add(listIdaSolo);
		
		JButton btnReservar = new JButton("Book a trip");
		btnReservar.addMouseListener(new MouseAdapter() {
			@Override
			//Acceder a otra VentanaReserva 
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservar.setBounds(724, 242, 120, 42);
		contentPane.add(btnReservar);
		
		JLabel lblBookATicket = new JLabel("GO AHEAD AND BOOK A TRIP");
		lblBookATicket.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookATicket.setBounds(249, 10, 342, 33);
		contentPane.add(lblBookATicket);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
