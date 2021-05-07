package es.termibus.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.data.Trip;
import es.termibus.database.DBManager;

public class VentanaSalidas extends JFrame {
	
	private JPanel contentPane;

	public VentanaSalidas(List<Trip> listOfTrips, Cliente c) {
		DefaultListModel<Trip> model = new DefaultListModel<Trip>();
		DBManager db = DBManager.getInstance();
		String tr = "";
		
		System.out.println(listOfTrips.size());
		
		setForeground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(null);
		panelNorte.setBackground(Color.LIGHT_GRAY);
		panelNorte.setBounds(0, 0, 879, 88);
		contentPane.add(panelNorte);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 10, 152, 53);
		panelNorte.add(lblLogo);
		
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
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(20, 35, 85, 21);
		panelNorte.add(btnGoBack);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.DARK_GRAY);
		panelCentral.setBounds(10, 98, 870, 429);
		contentPane.add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Departures ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelCentral.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelViaje = new JPanel();
		panelViaje.setBackground(Color.GRAY);
		panelCentral.add(panelViaje, BorderLayout.CENTER);
		panelViaje.setLayout(null);
		
		JPanel panelArriba = new JPanel();
		panelArriba.setBackground(Color.LIGHT_GRAY);
		panelArriba.setForeground(Color.RED);
		panelArriba.setBounds(21, 20, 806, 341);
		panelViaje.add(panelArriba);
		panelArriba.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 67, 388, 251);
		panelArriba.add(scrollPane);
		
		JList<Trip> tripList = new JList<Trip>();
		tripList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		for (Trip t : listOfTrips) {
			model.addElement(t);
			tr = t.getDestiny();
		}	

		tripList.setModel(model);
		scrollPane.setViewportView(tripList);
		
		
		JLabel lblTripsOn = new JLabel("Trips on " + tr);
		lblTripsOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTripsOn.setBounds(27, 12, 185, 27);
		panelArriba.add(lblTripsOn);
		
		JButton btnBookTrip = new JButton("Book selected trip");
		btnBookTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBookTrip.setBounds(465, 67, 292, 50);
		panelArriba.add(btnBookTrip);
		
		// Listeners
		
		btnGoBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				 VentanaPrincipal vp = new VentanaPrincipal(null);
				 vp.setVisible(true);
			}
		});
		
		btnBookTrip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Ticket t = new Ticket(
						tripList.getSelectedValue().getTrip_ID(),
						tripList.getSelectedValue().getDate(),
						tripList.getSelectedValue().getDestiny(),
						tripList.getSelectedValue().getHour(),
						tripList.getSelectedValue().getBusID(),
						tripList.getSelectedValue().getCost()
						);
				
				db.bookATicket(t);
				System.out.println("\n" + t);
				
				JOptionPane.showMessageDialog(null, "Ticket booked succesfully!");
				setVisible(false);
				
				List<Ticket> lt = new ArrayList<Ticket>(db.getTickets());
				
				for (Ticket tck : lt) {
					if(tck.getCodigo() == t.getCodigo()) {
						
						VentanaTicketInfo vti = new VentanaTicketInfo(tck, c);
						vti.setVisible(true);
					} else {
						System.out.println("XD");
					}
				}
			}
		});
	}
}
