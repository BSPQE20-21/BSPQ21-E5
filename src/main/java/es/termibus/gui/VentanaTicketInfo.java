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
import es.termibus.data.Language;
import es.termibus.data.Ticket;
import es.termibus.database.DBManager;
import java.awt.Color;

public class VentanaTicketInfo extends JFrame {

	private JPanel contentPane;
		
	public VentanaTicketInfo(Ticket t, Cliente c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThankYou = new JLabel(Language.lang.getString("gracias_por_la_reserva") + c.getName());
		lblThankYou.setForeground(new Color(255, 255, 255));
		lblThankYou.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblThankYou.setBounds(26, 20, 238, 46);
		contentPane.add(lblThankYou);
		
		JButton btnOK = new JButton("OK");
		btnOK.setForeground(new Color(0, 0, 0));
		btnOK.setBackground(new Color(105, 105, 105));
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setBounds(225, 507, 100, 46);
		contentPane.add(btnOK);
		
		JLabel lblDestiny = new JLabel(Language.lang.getString("destinacion") + ": " + t.getDestino());
		lblDestiny.setForeground(new Color(255, 255, 255));
		lblDestiny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDestiny.setBounds(26, 209, 362, 38);
		contentPane.add(lblDestiny);
		
		JLabel lblDate = new JLabel(Language.lang.getString("fecha") + ": " + t.getDate());
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(26, 257, 362, 38);
		contentPane.add(lblDate);
		
		JLabel lblHour = new JLabel(Language.lang.getString("hora") + ": " + t.getHour());
		lblHour.setForeground(new Color(255, 255, 255));
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHour.setBounds(26, 305, 362, 38);
		contentPane.add(lblHour);
		
		JLabel lblBusId = new JLabel("Bus ID: " + t.getBus());
		lblBusId.setForeground(new Color(255, 255, 255));
		lblBusId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusId.setBounds(26, 161, 362, 38);
		contentPane.add(lblBusId);
		
		JLabel lblTripId = new JLabel("Trip ID: " + t.getCodigo());
		lblTripId.setForeground(new Color(255, 255, 255));
		lblTripId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTripId.setBounds(26, 113, 362, 38);
		contentPane.add(lblTripId);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 95, 538, 268);
		contentPane.add(panel);
		
		JLabel lblCost = new JLabel("TOTAL:                                                                                  " + t.getPrecio() + " €");
		lblCost.setForeground(new Color(255, 255, 255));
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 16));
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
