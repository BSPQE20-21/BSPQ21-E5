package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class VentanaLlegadas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDestino;
	

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public VentanaLlegadas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 574);
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
		
		JComboBox comboBoxInformacion = new JComboBox();
		comboBoxInformacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxInformacion.setBounds(194, 25, 152, 38);
		panelNorte.add(comboBoxInformacion);
		comboBoxInformacion.addItem("Termibus Station");
		comboBoxInformacion.addItem("General information");
		comboBoxInformacion.addItem("Services");
		comboBoxInformacion.addItem("Maps");
		
		JComboBox comboBoxLocation = new JComboBox();
		comboBoxLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxLocation.setBounds(437, 25, 145, 38);
		panelNorte.add(comboBoxLocation);
		comboBoxLocation.addItem("Location");
		comboBoxLocation.addItem("How to get there");
		
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
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(10, 98, 870, 429);
		contentPane.add(panelCentral);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Departures ");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelCentral.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelViaje = new JPanel();
		panelCentral.add(panelViaje, BorderLayout.CENTER);
		panelViaje.setLayout(null);
		
		JPanel panelArriba = new JPanel();
		panelArriba.setBounds(153, 38, 534, 276);
		panelViaje.add(panelArriba);
		panelArriba.setLayout(null);
		
		JLabel lblDestino = new JLabel("Destination");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setBackground(Color.DARK_GRAY);
		lblDestino.setBounds(23, 10, 85, 34);
		panelArriba.add(lblDestino);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(138, 10, 96, 28);
		panelArriba.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBackground(Color.DARK_GRAY);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(244, 10, 78, 25);
		panelArriba.add(lblDate);
		
		JDateChooser fechaLlegada = new JDateChooser();
		fechaLlegada.setBounds(302, 10, 147, 28);
		panelArriba.add(fechaLlegada);
		
		DefaultTableModel modeloTabla;
		  modeloTabla = new DefaultTableModel() {
				public boolean isCellEditable(int row,int column) {
						return false;
				}
			};
		JTable table = new JTable(modeloTabla);
		String[] ids = {"Destiny", "Date", "Price"};
		modeloTabla.setColumnIdentifiers(ids);
		table.setBounds(21, 69, 475, 181);
		panelArriba.add(table);
		
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				Font fuente = new Font("Arial", Font.BOLD, 12);
				if(isSelected)
					c.setFont(fuente);
				return c;
			
			}
		});
		
		
	}
}

