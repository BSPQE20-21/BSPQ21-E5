package es.termibus.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.termibus.data.Cliente;
import es.termibus.database.DBException;
import es.termibus.database.DBManager;
import javax.swing.JCheckBox;
import java.awt.Color;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtClientName, txtClientMail, txtClientPw, txtClientPw2;
	private List<Cliente> clientes;
	private String dni, name, mail, pw, pwRepeat, age;
	private Cliente user;
	private DBManager dbm;
	private JTextField txtClientAge;
	private JTextField txtDNI;

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
		setBounds(100, 100, 448, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TERMIBUS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 137, 14);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 41, 90, 14);
		contentPane.add(lblName);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 123, 90, 14);
		contentPane.add(lblMail);

		JLabel lblPw = new JLabel("Password");
		lblPw.setBounds(10, 147, 90, 14);
		contentPane.add(lblPw);

		JLabel lblPw2 = new JLabel("Repeat Password");
		lblPw2.setBounds(10, 171, 99, 14);
		contentPane.add(lblPw2);

		txtClientName = new JTextField();
		txtClientName.setBounds(147, 39, 222, 20);
		contentPane.add(txtClientName);
		txtClientName.setColumns(10);

		txtClientAge = new JTextField();
		txtClientAge.setBounds(147, 66, 222, 19);
		contentPane.add(txtClientAge);
		txtClientAge.setColumns(10);

		txtClientMail = new JTextField();
		txtClientMail.setBounds(147, 119, 222, 20);
		contentPane.add(txtClientMail);
		txtClientMail.setColumns(10);

		txtClientPw = new JTextField();
		txtClientPw.setBounds(147, 144, 222, 20);
		contentPane.add(txtClientPw);
		txtClientPw.setColumns(10);

		txtClientPw2 = new JTextField();
		txtClientPw2.setBounds(147, 169, 222, 20);
		contentPane.add(txtClientPw2);
		txtClientPw2.setColumns(10);

		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignUp.setBounds(200, 215, 89, 23);
		contentPane.add(btnSignUp);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 69, 45, 13);
		contentPane.add(lblAge);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 99, 90, 14);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(147, 95, 222, 19);
		contentPane.add(txtDNI);
		
		JLabel lblText = new JLabel("<html>This Privacy Policy sets forth the terms under which Termibus uses and protects the information that is provided by its users when using its website. This company is committed to the security of its users' data. When we ask you to provide personal information by which you can be identified, we do so with the assurance that it will only be used in accordance with the terms of this document. However, this Privacy Policy may change over time or be updated and we encourage you to continually review this page to ensure that you agree to any such changes.<br></html>\r\n\r\nTranslated with www.DeepL.com/Translator (free version)<br></html>");
		lblText.setOpaque(true);
		lblText.setForeground(Color.BLACK);
		lblText.setBackground(Color.YELLOW);
		lblText.setBounds(10, 300, 412, 117);
		contentPane.add(lblText);
		lblText.setVisible(false);
		
		JCheckBox chckbxPrivacy = new JCheckBox("I have read and accept the Privacy Policy");
		chckbxPrivacy.setBackground(Color.WHITE);
		chckbxPrivacy.setBounds(77, 258, 268, 23);
		contentPane.add(chckbxPrivacy);
		chckbxPrivacy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblText.setVisible(false);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblText.setVisible(true);
				
			}
		});

		dbm = DBManager.getInstance();
		clientes = dbm.getClients();

		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxPrivacy.isSelected()) {

					dni = txtDNI.getText();
					name = txtClientName.getText();
					mail = txtClientMail.getText();
					age = txtClientAge.getText();
					pw = txtClientPw.getText();
					pwRepeat = txtClientPw2.getText();

					user = new Cliente(dni, name, mail, pw);

					try {
						if (!dbm.existsClient(user)) {
							if (pw.equals(pwRepeat)) {

								dbm.pushToDB(user);
								JOptionPane.showMessageDialog(null, "Account created", "Welcome", 1, null);

								VentanaInicioSesion vi = new VentanaInicioSesion();
								setVisible(false);
								vi.setVisible(true);

							} else {
								JOptionPane.showMessageDialog(null, "Passwords were not the same", "Error", 0, null);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Client's name already in use", "Error", 0, null);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You must accept the privacy policy", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
