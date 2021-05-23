package es.termibus.gui;

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

import es.termibus.client.ClienteClient;
import es.termibus.client.TicketClient;
import es.termibus.client.TripClient;
import es.termibus.data.Cliente;
import es.termibus.data.Language;
import es.termibus.data.Selection;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import java.awt.SystemColor;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private final JPanel panelNorte = new JPanel();
	private List<Trip> trips;
	private JDateChooser fechaSalida;
	private DateFormat df;
	
	private TripClient tc;
	private TicketClient tcc;
	private ClienteClient cc;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public VentanaPrincipal(Cliente client) {
		
		tc = TripClient.getInstance();
		trips = new ArrayList<Trip>(tc.viewTrips());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 428);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelNorte.setBackground(SystemColor.textInactiveText);
		panelNorte.setBounds(0, 0, 879, 88);
		contentPane.add(panelNorte);
		panelNorte.setLayout(null);

		JLabel lblLogo = new JLabel("");// Poner logo que creemos
		lblLogo.setBounds(10, 10, 152, 53);
		panelNorte.add(lblLogo);

		ImageIcon ico1 = new ImageIcon("images/logo.JPG");// meter las rutas en la bd
		ImageIcon img1 = new ImageIcon(
				ico1.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH));
		lblLogo.setIcon(img1);
		
		JLabel lblWelcomeUser = new JLabel(Language.lang.getString("bienvenido") + client.getName());
		lblWelcomeUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblWelcomeUser.setBounds(188, 17, 309, 53);
		panelNorte.add(lblWelcomeUser);
		
		JButton btnViewTrips = new JButton(Language.lang.getString("ver_viajes_reservados"));
		btnViewTrips.setBounds(447, 36, 179, 27);
		panelNorte.add(btnViewTrips);
		
		JButton btnChangeLang = new JButton("Change language");
		btnChangeLang.setForeground(new Color(255, 255, 255));
		btnChangeLang.setBackground(new Color(128, 0, 0));
		btnChangeLang.setBounds(712, 35, 135, 28);
		panelNorte.add(btnChangeLang);

		btnChangeLang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				new VentanaTraduccion().setVisible(true);
			}
		});
		
		
		if (VentanaInicioSesion.getUser() == null) {

			JButton btnRegistro = new JButton(Language.lang.getString("crear_cuenta"));
			btnRegistro.setBounds(960, 13, 117, 23);
			panelNorte.add(btnRegistro);

			JButton btnLogin = new JButton(Language.lang.getString("registrar_usuario"));
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
			JLabel lblNewLabel = new JLabel(Language.lang.getString("entrar_como")+ " " + VentanaInicioSesion.getUser().getName());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel);

		}

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(SystemColor.scrollbar);
		panelCentro.setForeground(new Color(255, 51, 51));
		panelCentro.setBounds(0, 98, 879, 293);
		contentPane.add(panelCentro);
		panelCentro.setLayout(null);

		JPanel panelSalidas = new JPanel();
		panelSalidas.setBackground(Color.DARK_GRAY);
		panelSalidas.setBounds(126, 20, 577, 115);
		panelCentro.add(panelSalidas);
		panelSalidas.setLayout(null);

		JLabel lblSalidas = new JLabel(Language.lang.getString("salida_Bilbao"));
		lblSalidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalidas.setBounds(0, 0, 524, 42);
		panelSalidas.add(lblSalidas);
		lblSalidas.setForeground(Color.WHITE);
		lblSalidas.setBackground(Color.RED);

		JLabel lblDestination = new JLabel(Language.lang.getString("destinacion"));
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDestination.setBounds(20, 56, 76, 24);
		panelSalidas.add(lblDestination);

		JComboBox<String> comboBoxDestination = new JComboBox();
		comboBoxDestination.setBounds(106, 52, 133, 28);
		panelSalidas.add(comboBoxDestination);
		
		for (int i = 0; i < trips.size(); i++) {
			comboBoxDestination.addItem(trips.get(i).getDestiny());
		}

		JLabel lblDate = new JLabel(Language.lang.getString("fecha"));
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(249, 56, 40, 24);
		panelSalidas.add(lblDate);
		

		fechaSalida = new JDateChooser();
		fechaSalida.setBounds(299, 52, 147, 28);
		panelSalidas.add(fechaSalida);
		
		df = new SimpleDateFormat("dd/MM/yyyy");
		
		JButton btnSearchSalida = new JButton(Language.lang.getString("busqueda"));
		btnSearchSalida.setForeground(Color.BLACK);
		btnSearchSalida.setBackground(Color.RED);
		btnSearchSalida.setBounds(463, 58, 85, 21);
		panelSalidas.add(btnSearchSalida);

		JPanel panelSur = new JPanel();
		panelSur.setBackground(SystemColor.scrollbar);
		panelSur.setBounds(0, 164, 879, 128);
		panelCentro.add(panelSur);
		panelSur.setLayout(null);

		JLabel lblLogos = new JLabel("");
		lblLogos.setIcon(new ImageIcon(""));
		lblLogos.setBounds(25, 10, 157, 108);
		panelSur.add(lblLogos);

		JLabel lblPolicy = new JLabel(Language.lang.getString("politica_de_privacidad"));
		lblPolicy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPolicy.setForeground(Color.DARK_GRAY);
		lblPolicy.setBounds(481, 89, 144, 29);
		panelSur.add(lblPolicy);

		JLabel lblknowUs = new JLabel(Language.lang.getString("quienes_somos"));
		lblknowUs.setForeground(Color.BLACK);
		lblknowUs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblknowUs.setBounds(665, 89, 194, 29);
		panelSur.add(lblknowUs);

		
		btnSearchSalida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {	
					Selection s = new Selection(comboBoxDestination.getSelectedItem().toString(), df.format(fechaSalida.getDate()), "");
					List<Trip> listOfTrips= new ArrayList<Trip>();
					
					for(Trip t : trips) {
						if(s.getCity().equals(t.getDestiny()) && s.getDate().equals(t.getDate())) {			
							listOfTrips.add(t);
						}
					}
					setVisible(false);
					VentanaSalidas vs = new VentanaSalidas(listOfTrips, client);
					vs.setVisible(true);		
			}
		});
		

		btnViewTrips.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tcc = TicketClient.getInstance();
				List<Ticket> lt = new ArrayList<Ticket>(tcc.viewTickets());
				setVisible(false);
				VentanaViewMyTrips vv = new VentanaViewMyTrips(lt, client);
				vv.setVisible(true);
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