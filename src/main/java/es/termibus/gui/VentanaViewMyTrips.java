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
	private JPanel panel;
	private JButton btnGoBack;
	private JLabel lblWelcomeClient;

	public VentanaViewMyTrips(List<Ticket> listOfTickets, Cliente c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 69, 751, 266);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		modelo.addColumn(Language.lang.getString("destinacion"));
		modelo.addColumn(Language.lang.getString("fecha"));
		
		table.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnGoBack = new JButton("Back");
		panel.add(btnGoBack);
		
		lblWelcomeClient = new JLabel("Viewing " + c.getName() + "'s past booked trips");
		lblWelcomeClient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblWelcomeClient.setForeground(new Color(255, 255, 255));
		panel.add(lblWelcomeClient);
		
		for(Ticket ticket: listOfTickets) {
			String fila[] = {ticket.getDestino(), ticket.getDate()};
			modelo.addRow(fila);
		}	
		
		JButton btnBack = new JButton(Language.lang.getString("atras"));
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