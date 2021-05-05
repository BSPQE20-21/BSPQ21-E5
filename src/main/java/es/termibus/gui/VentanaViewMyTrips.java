package es.termibus.gui;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
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
		
		JPanel titulopanel = new JPanel();
		titulopanel.setBounds(0, 0, 811, 58);
		titulopanel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(titulopanel);
		titulopanel.setLayout(null);
		
		JLabel titulo = new JLabel("TRIPS");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(0, 11, 602, 36);
		titulopanel.add(titulo);
	
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
		
		List<Ticket> tckts = db.getTickets();
		for(Ticket ticket: tckts) {
			
			String fila[] = {ticket.getDestino(), ticket.getDate()};
			modelo.addRow(fila);
		}	
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(21, 10, 85, 21);
		
	}
	public void setTableContent() {
		
	}
		
	public void TripsJTable() {
		
		
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
