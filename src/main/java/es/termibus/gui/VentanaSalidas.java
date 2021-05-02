package es.termibus.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.termibus.data.Selection;

public class VentanaSalidas extends JFrame {
	
	private JPanel contentPane;

	public VentanaSalidas(List<Selection> tripsSelection) {
		DefaultListModel<Selection> model = new DefaultListModel<Selection>();
		
		//System.out.println(tripsSelection.size());
		
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
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setBounds(20, 35, 85, 21);
		panelNorte.add(btnNewButton);
		
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
		
		JLabel lblTripsOn = new JLabel("Trips on ");
		lblTripsOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTripsOn.setBounds(27, 12, 57, 27);
		panelArriba.add(lblTripsOn);
		
		JLabel lblTripNDate = new JLabel("(Trip selected)");
		lblTripNDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTripNDate.setBounds(82, 13, 101, 25);
		panelArriba.add(lblTripNDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 67, 388, 251);
		panelArriba.add(scrollPane);
		
		JList<Selection> tripList = new JList<Selection>();
		tripList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		for (Selection s : tripsSelection) {
			model.addElement(s);
		}	

		tripList.setModel(model);
		scrollPane.setViewportView(tripList);
		
		JButton btnNewButton_1 = new JButton("Book selected trip");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(465, 67, 292, 50);
		panelArriba.add(btnNewButton_1);
	}
}
