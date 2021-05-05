package es.termibus.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.termibus.data.Cliente;
import es.termibus.data.Ticket;
import es.termibus.database.DBManager;

public class VentanaTicketInfo extends JFrame {

	private JPanel contentPane;
		
	public VentanaTicketInfo(Ticket t, Cliente c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThankYou = new JLabel("Thank you for your booking " + c.getName());
		lblThankYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThankYou.setBounds(26, 20, 238, 46);
		contentPane.add(lblThankYou);
		
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setBounds(225, 507, 100, 46);
		contentPane.add(btnOK);
		
		JLabel lblDestiny = new JLabel("Destiny: " + t.getDestino());
		lblDestiny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestiny.setBounds(26, 209, 362, 38);
		contentPane.add(lblDestiny);
		
		JLabel lblDate = new JLabel("Date: " + t.getDate());
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(26, 257, 362, 38);
		contentPane.add(lblDate);
		
		JLabel lblHour = new JLabel("Hour: " + t.getHour());
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHour.setBounds(26, 305, 362, 38);
		contentPane.add(lblHour);
		
		JLabel lblBusId = new JLabel("Bus ID: " + t.getBus());
		lblBusId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusId.setBounds(26, 161, 362, 38);
		contentPane.add(lblBusId);
		
		JLabel lblTripId = new JLabel("Trip ID: " + t.getCodigo());
		lblTripId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTripId.setBounds(26, 113, 362, 38);
		contentPane.add(lblTripId);
		
		JLabel lblCost = new JLabel("TOTAL:                                                                                  " + t.getPrecio() + " €");
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCost.setBounds(26, 422, 506, 46);
		contentPane.add(lblCost);
		
		// Listeners
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				VentanaPrincipal vp = new VentanaPrincipal(c);
				vp.setVisible(true);
			}
		});
	}
}
