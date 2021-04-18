package InicioYRegistro;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.DBException;
import BD.DBManager;
import Classes.Cliente;
import InicioYRegistro.*;

public class VentanaRegistro extends JFrame{

	private JPanel contentPane;
	private JTextField txtClientName;
	private JTextField txtClientMail;
	private JTextField txtClientPw;
	private JTextField txtClientPw2;
	private List<Cliente> clientes;
	private String name;
	private String mail;
	private String pw;
	private String pwRepeat;
	private DBManager dbm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TERMIBUS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 71, 90, 14);
		contentPane.add(lblName);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 96, 90, 14);
		contentPane.add(lblMail);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setBounds(10, 121, 90, 14);
		contentPane.add(lblPw);
		
		JLabel lblPw2 = new JLabel("Repeat Password");
		lblPw2.setBounds(10, 146, 99, 14);
		contentPane.add(lblPw2);
		
		txtClientName = new JTextField();
		txtClientName.setBounds(147, 68, 222, 20);
		contentPane.add(txtClientName);
		txtClientName.setColumns(10);
		
		txtClientMail = new JTextField();
		txtClientMail.setBounds(147, 93, 222, 20);
		contentPane.add(txtClientMail);
		txtClientMail.setColumns(10);
		
		txtClientPw = new JTextField();
		txtClientPw.setBounds(147, 118, 222, 20);
		contentPane.add(txtClientPw);
		txtClientPw.setColumns(10);
		
		txtClientPw2 = new JTextField();
		txtClientPw2.setBounds(147, 143, 222, 20);
		contentPane.add(txtClientPw2);
		txtClientPw2.setColumns(10);
		
		JButton btnSingUp = new JButton("SingUp");
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSingUp.setBounds(280, 214, 89, 23);
		contentPane.add(btnSingUp);
		
		dbm = new DBManager();
		try {
			clientes = dbm.listarClientes();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		btnSingUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = txtClientName.getText();
				mail = txtClientMail.getText();
				pw = txtClientPw.getText();
				pwRepeat = txtClientPw2.getText();
				
				Cliente user = new Cliente(name, mail, pw);
			
				try {
					if (!dbm.exiteCliente(user)) {
						if (pw.equals(pwRepeat)) {

							try {
								
								dbm.insertarCliente(user);
							
							} catch (DBException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Account created", "Welcome", 1, null);
							
							VentanaInicioSesion vi = new VentanaInicioSesion();
							setVisible(false);
							vi.setVisible(true);

					}else {
						JOptionPane.showMessageDialog(null, "Passwords don't coincide", "Error", 0, null);
					}
					}else {
						JOptionPane.showMessageDialog(null, "Client's name already in use", "Error", 0, null);
					}
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		
		
		
		
		
	}
}
