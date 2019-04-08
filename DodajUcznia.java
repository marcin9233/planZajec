package polaczenie;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.dom4j.util.StringUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DodajUcznia {

	public JFrame frmDodajucznia;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnDodaj;

	/**
	 * Launch the application.
	 *//*
		 * public static void main(String[] args) { EventQueue.invokeLater(new
		 * Runnable() { public void run() { try { DodajUcznia window = new
		 * DodajUcznia(); window.frmDodajucznia.setVisible(true); } catch (Exception e)
		 * { e.printStackTrace(); } } }); }
		 */
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public DodajUcznia() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frmDodajucznia = new JFrame();
		frmDodajucznia.setTitle("Dodaj_Ucznia");
		frmDodajucznia.setBounds(100, 100, 300, 300);
		//frmDodajucznia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JLabel lblNrid = new JLabel("nrID:");
		
		JLabel lblImi = new JLabel("Imi\u0119:");
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		
		JLabel lblUwagi = new JLabel("Uwagi:");
		
		JLabel lblKlasa = new JLabel("Klasa:");
		
		JLabel lblRok = new JLabel("Rok:");
		
		//textField = new JTextField();
		//textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		btnDodaj = new JButton("Dodaj");

		
		JComboBox comboBox = new JComboBox();
		Statement stmt = null;
	    String query = String.format
	      ("SELECT nrRoku FROM roczniki");

	    try {
	    	Connection conn = Main.getConnection();
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	        	Date id = rs.getDate("nrRoku");
	        	
		        //System.out.println("Imie: " + imie + "\nNazwisko: " + nazwisko + "\nUwagi: " + uwagi);
	        	comboBox.addItem(new SimpleDateFormat("yyyy").format(id));
	        	comboBox.setSelectedItem(null);
	        } rs.close();
		         }catch (SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
		
		JComboBox comboBox_1 = new JComboBox(); //To jest klasa (nie class)
		Statement stmt2 = null;
	    String query2 = String.format
	      ("SELECT klasaID FROM klasy");

	    try {
	    	Connection conn = Main.getConnection();
	        stmt2 = conn.createStatement();
	        ResultSet rs = stmt2.executeQuery(query2);
	        while (rs.next()) {
	        	String id = rs.getString("klasaID");
		        //System.out.println("Imie: " + imie + "\nNazwisko: " + nazwisko + "\nUwagi: " + uwagi);
	        	comboBox_1.addItem(id);
	        	comboBox_1.setSelectedItem(null);
	        } rs.close();
		         }catch (SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        if (stmt2 != null) { stmt2.close(); }
	    }
		GroupLayout groupLayout = new GroupLayout(frmDodajucznia.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblRok)
								.addComponent(lblKlasa)
								.addComponent(lblUwagi)
								.addComponent(lblImi)
								.addComponent(lblNazwisko))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_2)
								.addComponent(textField_3)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(126)
							.addComponent(btnDodaj)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImi)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNazwisko)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUwagi)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKlasa)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRok)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnDodaj)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		frmDodajucznia.getContentPane().setLayout(groupLayout);
		btnDodaj.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
              //if (dodajUcznia == null) // first time
             
             try {
            	 String klasa = (String)comboBox_1.getSelectedItem();
            	 String rok = (String)comboBox.getSelectedItem();
            	 //Dodaj.dodajUcznia(imie, nazwisko, uwagi, klasa, rok); <-- dokonczyc!!!!!!!!!!!
				} catch (Exception e) {
					e.printStackTrace();
				}
           }
        });
	}
}
