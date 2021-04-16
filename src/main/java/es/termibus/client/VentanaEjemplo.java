package es.termibus.client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class VentanaEjemplo extends JFrame{

    private JPanel pNorte,pCentral;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaEjemplo frame = new VentanaEjemplo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaEjemplo() {

        pNorte = new JPanel();
        pNorte.setBackground(Color.WHITE);
        pCentral = new JPanel(new GridLayout(0, 3));
        getContentPane().add(pNorte,BorderLayout.NORTH);
        getContentPane().add(pCentral,BorderLayout.CENTER);

        setTitle("Servicios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(300, 200, 900, 900);

        JLabel derecha = new JLabel("");
        derecha.setBackground(Color.WHITE);


        pNorte.add(derecha);

        JScrollPane scrollbar = new JScrollPane(pCentral);
        getContentPane().add(scrollbar, BorderLayout.CENTER);
        scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


    }

}