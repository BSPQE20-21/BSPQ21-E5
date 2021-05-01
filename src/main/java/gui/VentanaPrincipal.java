package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import data.Cliente;
import data.Selection;
import data.Trip;
import database.DBManager;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private final JPanel panelNorte = new JPanel();
	private Trip trip;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public VentanaPrincipal(Cliente client) {
		DBManager dbm = DBManager.getInstance();
		List<Trip> trips = new ArrayList<Trip>(dbm.getTrips());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 578);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelNorte.setBackground(Color.LIGHT_GRAY);
		panelNorte.setBounds(0, 0, 879, 88);
		contentPane.add(panelNorte);
		panelNorte.setLayout(null);

		JLabel lblLogo = new JLabel("");// Poner logo que creemos
		lblLogo.setBounds(10, 10, 152, 53);
		panelNorte.add(lblLogo);

		JComboBox comboBoxInformacion = new JComboBox();
		comboBoxInformacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxInformacion.setBounds(194, 25, 152, 38);
		panelNorte.add(comboBoxInformacion);
		comboBoxInformacion.addItem("Termibus Station");
		comboBoxInformacion.addItem("General information");
		comboBoxInformacion.addItem("Services");
		comboBoxInformacion.addItem("Maps");		

		JComboBox comboBoxLocation = new JComboBox();
		comboBoxLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxLocation.setBounds(437, 25, 145, 38);
		panelNorte.add(comboBoxLocation);
		comboBoxLocation.addItem("Location");
		comboBoxLocation.addItem("How to get there");

		JCheckBox chckbxEnglish = new JCheckBox("EN");
		chckbxEnglish.setFont(new Font("Tahoma", Font.ITALIC, 10));
		chckbxEnglish.setBackground(Color.LIGHT_GRAY);
		chckbxEnglish.setBounds(716, 10, 93, 21);
		panelNorte.add(chckbxEnglish);

		JCheckBox chckbxEuskera = new JCheckBox("EUS");
		chckbxEuskera.setFont(new Font("Tahoma", Font.ITALIC, 10));
		chckbxEuskera.setBackground(Color.LIGHT_GRAY);
		chckbxEuskera.setBounds(716, 35, 93, 21);
		panelNorte.add(chckbxEuskera);

		JCheckBox chckbxCastellano = new JCheckBox("ES");
		chckbxCastellano.setFont(new Font("Tahoma", Font.ITALIC, 10));
		chckbxCastellano.setBackground(Color.LIGHT_GRAY);
		chckbxCastellano.setBounds(716, 61, 93, 21);
		panelNorte.add(chckbxCastellano);

		ImageIcon ico1 = new ImageIcon("images/logo.JPG");// meter las rutas en la bd
		ImageIcon img1 = new ImageIcon(
				ico1.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
		lblLogo.setIcon(img1);

		if (VentanaInicioSesion.getUser() == null) {

			JButton btnRegistro = new JButton("Create an account");
			btnRegistro.setBounds(960, 13, 117, 23);
			panelNorte.add(btnRegistro);

			JButton btnLogin = new JButton("Log in");
			btnLogin.setBounds(1087, 13, 123, 23);
			panelNorte.add(btnLogin);

			btnLogin.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaInicioSesion vi = new VentanaInicioSesion();
					vi.setVisible(true);

				}
			});

			btnRegistro.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro();
					vr.setVisible(true);

				}
			});

		} else {
			JLabel lblNewLabel = new JLabel("You're log in as:  " + VentanaInicioSesion.getUser().getName());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel);

		}

		JPanel panelCentro = new JPanel();
		panelCentro.setBounds(0, 98, 879, 443);
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		JPanel panelSalidas = new JPanel();
		panelSalidas.setBackground(Color.DARK_GRAY);
		panelSalidas.setBounds(126, 20, 577, 115);
		panelCentro.add(panelSalidas);
		panelSalidas.setLayout(null);

		JLabel lblSalidas = new JLabel("DEPARTURES FROM BILBAO");
		lblSalidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalidas.setBounds(0, 0, 524, 42);
		panelSalidas.add(lblSalidas);
		lblSalidas.setForeground(Color.WHITE);
		lblSalidas.setBackground(Color.RED);

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDestination.setBounds(20, 56, 76, 24);
		panelSalidas.add(lblDestination);

		JComboBox comboBoxDestination = new JComboBox();
		comboBoxDestination.setBounds(106, 52, 133, 28);
		panelSalidas.add(comboBoxDestination);
		
		for (int i = 0; i < trips.size(); i++) {
			comboBoxDestination.addItem(trips.get(i).getDestiny());
		}

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(249, 56, 40, 24);
		panelSalidas.add(lblDate);

		JDateChooser fechaSalida = new JDateChooser();
		fechaSalida.setBounds(299, 52, 147, 28);
		panelSalidas.add(fechaSalida);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		JButton btnSearchSalida = new JButton("SEARCH");
		btnSearchSalida.setBackground(Color.RED);
		btnSearchSalida.setBounds(463, 58, 85, 21);
		panelSalidas.add(btnSearchSalida);

		// Search for the trip selected
		
		btnSearchSalida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				Selection s = new Selection(comboBoxDestination.getSelectedItem().toString(), df.format(fechaSalida.getDate()));
				
				for(Trip t : trips) {
					if(s.getCity().equals(t.getDestiny()) && s.getDate().equals(t.getDate())) {
						System.out.println("\nFunciona :)");
					}
				}
			}
		});
		
		JPanel panelLlegadas = new JPanel();
		panelLlegadas.setLayout(null);
		panelLlegadas.setBackground(Color.DARK_GRAY);
		panelLlegadas.setBounds(126, 162, 577, 115);
		panelCentro.add(panelLlegadas);

		JLabel lblLlegadas = new JLabel("ARRIVALS IN BILBAO");
		lblLlegadas.setForeground(Color.WHITE);
		lblLlegadas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLlegadas.setBackground(Color.RED);
		lblLlegadas.setBounds(0, 0, 524, 42);
		panelLlegadas.add(lblLlegadas);

		JLabel lblArrivals = new JLabel("Departure Point");
		lblArrivals.setForeground(Color.WHITE);
		lblArrivals.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArrivals.setBounds(10, 54, 99, 24);
		panelLlegadas.add(lblArrivals);

		JComboBox comboBoxDeparture = new JComboBox();
		comboBoxDeparture.setBounds(116, 52, 133, 28);
		panelLlegadas.add(comboBoxDeparture);

		JLabel lblDate2 = new JLabel("Date");
		lblDate2.setForeground(Color.WHITE);
		lblDate2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate2.setBounds(259, 56, 40, 24);
		panelLlegadas.add(lblDate2);

		JDateChooser fechaLlegada = new JDateChooser();
		fechaLlegada.setBounds(299, 52, 147, 28);
		panelLlegadas.add(fechaLlegada);

		JButton btnSearchLlegada = new JButton("SEARCH");
		btnSearchLlegada.setBackground(Color.RED);
		btnSearchLlegada.setBounds(463, 58, 85, 21);
		panelLlegadas.add(btnSearchLlegada);

		JPanel panelSur = new JPanel();
		panelSur.setBounds(0, 305, 869, 128);
		panelCentro.add(panelSur);
		panelSur.setLayout(null);

		JLabel lblLogos = new JLabel("");
		lblLogos.setIcon(new ImageIcon(""));
		lblLogos.setBounds(25, 10, 157, 108);
		panelSur.add(lblLogos);

		JLabel lblPolicy = new JLabel("Privacy Policy");
		lblPolicy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPolicy.setForeground(Color.DARK_GRAY);
		lblPolicy.setBounds(481, 89, 144, 29);
		panelSur.add(lblPolicy);

		JLabel lblknowUs = new JLabel("Who are we? Get to know us");
		lblknowUs.setForeground(Color.BLACK);
		lblknowUs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblknowUs.setBounds(665, 89, 194, 29);
		panelSur.add(lblknowUs);

		btnSearchSalida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					trip.setDestiny(comboBoxDestination.getName());
					trip.setDate(fechaSalida.getDateFormatString());
					dbm.pushToDB(trip);

					//VentanaSalidas vs = new VentanaSalidas(client);
					//vs.setVisible(true);
					dispose();

				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}

				panelCentro.removeAll();
				panelCentro.revalidate();

				String destino = comboBoxDestination.getName();

				List<Trip> tripsChosen;

				tripsChosen = dbm.getSelectedTrip(destino, fechaSalida.getCalendar());

				for (Trip t : tripsChosen) {
					if (t.getDestiny() != null) {

					}
				}

			}
		});

		lblknowUs.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}
}