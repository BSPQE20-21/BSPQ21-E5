package es.termibus.gui;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import es.termibus.data.*;
import es.termibus.database.DBManager;

import javax.swing.JButton;

public class VentanaViewMyTrips extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private static Ticket tckt;
	DBManager db = DBManager.getInstance();
	private JPanel panel;
	private JButton btnGoBack;
	private JLabel lblWelcomeClient;
	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public VentanaViewMyTrips(List<Ticket> listOfTickets, Cliente c) {
	
		DBManager db = DBManager.getInstance();
		String tr = "";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 69, 751, 266);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		modelo.addColumn("Destiny");
		modelo.addColumn("Date");
		
		table.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnGoBack = new JButton("Back");
		panel.add(btnGoBack);
		
		lblWelcomeClient = new JLabel("These are the trips you already booked " + c.getName());
		panel.add(lblWelcomeClient);
		
		List<Ticket> tckts = db.getTickets();
		for(Ticket ticket: tckts) {
			
			String fila[] = {ticket.getDestino(), ticket.getDate()};
			modelo.addRow(fila);
		}	
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(21, 10, 85, 21);
		
		
		btnGoBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				VentanaPrincipal vp = new VentanaPrincipal(c);
				vp.setVisible(true);
			}
		});
	}
	
	public void setTableContent() {
		
	}
		
	public void TripsJTable() {
		
		
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
