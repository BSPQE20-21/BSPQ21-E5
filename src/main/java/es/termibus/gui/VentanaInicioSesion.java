package es.termibus.gui;


	
	import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

//import VentanaPrincipal.VentanaPrincipal;

	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.termibus.client.ClienteClient;
import es.termibus.data.Cliente;
import es.termibus.database.DBManager;

	public class VentanaInicioSesion extends JFrame {

		private static Cliente cl;
		private JPanel contentPane;
		private JTextField txtClientName;
		private JPasswordField pfPw;
		private List<Cliente> clientes;
		private String name;
		private String pw;
		private boolean acceso;
		private ClienteClient cc;
		private DBManager db;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaInicioSesion frame = new VentanaInicioSesion();
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
		public VentanaInicioSesion() {
			

			cc = ClienteClient.getInstance();
			clientes = cc.viewClients();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 394, 303);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblClientName = new JLabel("Mail");
			lblClientName.setBounds(10, 78, 103, 14);
			contentPane.add(lblClientName);
			
			JLabel lblPw = new JLabel("Password");
			lblPw.setBounds(10, 118, 86, 14);
			contentPane.add(lblPw);
			
			txtClientName = new JTextField();
			txtClientName.setBounds(154, 75, 137, 20);
			contentPane.add(txtClientName);
			txtClientName.setColumns(10);
			
			pfPw = new JPasswordField();
			pfPw.setBounds(154, 115, 137, 20);
			contentPane.add(pfPw);
			pfPw.setColumns(10);
			
			JButton btnLogIn = new JButton("LogIn");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnLogIn.setBounds(202, 163, 89, 23);
			contentPane.add(btnLogIn);
			
			JLabel lblNewLabel = new JLabel("TERMIBUS");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 11, 156, 20);
			contentPane.add(lblNewLabel);
			
			JLabel lblReg = new JLabel("I don't have an account");
			lblReg.setBounds(161, 210, 142, 14);
			contentPane.add(lblReg);
			
			
			acceso = false;
			
			btnLogIn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					name = txtClientName.getText();
					pw = pfPw.getText();
					
					for (Cliente user : clientes) {
						if (user.getMail().equals(name) && user.getPw().equals(pw)) {
							acceso = true;	
							// String DNI, String name, String mail, String p
							cl = new Cliente(user.getDNI(), user.getName(), user.getMail(), user.getPw());
						}		
					}
					if (acceso) {
						JOptionPane.showMessageDialog(null, "Correct log in", "Inicio correcto", 1, null);
						VentanaPrincipal vp = new VentanaPrincipal(cl);
					    vp.setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Error", "Error", 0, null);
					}
				}
			});
			
			lblReg.addMouseListener(new MouseListener() {
				
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
					VentanaRegistro vr = new VentanaRegistro();
					vr.setVisible(true);
					setVisible(false);

				}
			});

		}

		public static Cliente getUser() {
			return cl;

		}
	}


