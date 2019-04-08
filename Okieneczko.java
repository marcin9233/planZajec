package polaczenie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.*;

import antlr.collections.impl.Vector;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Okieneczko {

	public JFrame frmPlanZajec;
	private JTable table;
	private static Logger logger = LogManager.getLogger(Main.class);
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
				//	Okieneczko window = new Okieneczko();
				//	window.frmPlanZajec.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
	//}

	/**
	 * Create the application.
	 */
	public Okieneczko() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlanZajec = new JFrame();
		frmPlanZajec.setTitle("Plan zajec");
		frmPlanZajec.setBounds(100, 100, 741, 638);
		frmPlanZajec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmPlanZajec.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Nauczyciele");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmDodaj = new JMenuItem("Dodaj");
		mntmDodaj.setEnabled(false);
		mnNewMenu.add(mntmDodaj);
		
		JMenuItem mntmSprawdz = new JMenuItem("Sprawdz");
		mntmSprawdz.setEnabled(false);
		mnNewMenu.add(mntmSprawdz);
		
		JMenu mnKlasy = new JMenu("Klasy");
		menuBar.add(mnKlasy);
		
		JMenuItem menuItem = new JMenuItem("Dodaj");
		menuItem.setEnabled(false);
		mnKlasy.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Sprawdz");
		menuItem_1.setEnabled(false);
		mnKlasy.add(menuItem_1);
		
		JMenu mnRoczniki = new JMenu("Roczniki");
		menuBar.add(mnRoczniki);
		
		JMenuItem menuItem_2 = new JMenuItem("Dodaj");
		menuItem_2.setEnabled(false);
		mnRoczniki.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Sprawdz");
		menuItem_3.setEnabled(false);
		mnRoczniki.add(menuItem_3);
		
		JMenu mnPrzedmioty = new JMenu("Przedmioty");
		menuBar.add(mnPrzedmioty);
		
		JMenuItem menuItem_4 = new JMenuItem("Dodaj");
		menuItem_4.setEnabled(false);
		mnPrzedmioty.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Sprawdz");
		menuItem_5.setEnabled(false);
		mnPrzedmioty.add(menuItem_5);
		
		JMenu mnSale = new JMenu("Sale");
		menuBar.add(mnSale);
		
		JMenuItem menuItem_6 = new JMenuItem("Dodaj");
		menuItem_6.setEnabled(false);
		mnSale.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Sprawdz");
		menuItem_7.setEnabled(false);
		mnSale.add(menuItem_7);
		
		JMenu mnUczniowie = new JMenu("Uczniowie");
		menuBar.add(mnUczniowie);
		
		JMenuItem menuItem_8 = new JMenuItem("Dodaj");
		mnUczniowie.add(menuItem_8);
		//static DodajUcznia dodajUcznia;
		menuItem_8.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
              //if (dodajUcznia == null) // first time
             
             try {
					DodajUcznia dodajUcznia = new DodajUcznia();
					dodajUcznia.frmDodajucznia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
           }
        });
		
		
		JMenuItem menuItem_9 = new JMenuItem("Sprawdz");
		mnUczniowie.add(menuItem_9);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		JProgressBar progressBar = new JProgressBar();
		frmPlanZajec.getContentPane().add(progressBar, BorderLayout.SOUTH);
		
		JScrollPane panel = new JScrollPane();
		frmPlanZajec.getContentPane().add(panel, BorderLayout.NORTH);
		
		table = new JTable();
		Object[] objekt = new Object[]{"ID", "Imie", "Nazwisko", "Uwagi", "Klasa", "Rok"};
		Object[] uczen = new Object[6];
		DefaultTableModel model = new DefaultTableModel(objekt,0 );
	 
for(int i = 0; i < getUczniowie().size(); i++){
            
            uczen[0] = getUczniowie().get(i).getId();
             uczen[1] = getUczniowie().get(i).getImie();
              uczen[2] = getUczniowie().get(i).getNazwisko();
               uczen[3] = getUczniowie().get(i).getUwagi();
                uczen[4] = getUczniowie().get(i).getKlasa();
                 uczen[5] = getUczniowie().get(i).getRok();
               
               model.addRow(uczen);
        }
		table.setModel(model);
		System.out.println(getUczniowie().size());
		panel.setViewportView(table);
	}
		//Object[][] uczen = {{"1","Wojciech","Kesik","spi na lekcji","1","1995"}};
		Zapytaj zapytaj = new Zapytaj();
		private final Action action = new SwingAction();
		static ArrayList<Uczniowie> getUczniowie(){
	        
	        ArrayList<Uczniowie> uczniowie = new ArrayList<Uczniowie>();
	        
	        Connection main;
			try {
				main = Main.getConnection();
				Statement st;
	        
	        ResultSet rs;
	        
	        Uczniowie u;

	            
	            st = main.createStatement();
	            rs = st.executeQuery("SELECT * FROM uczniowie");
	            
	            while(rs.next()){
	                
	                u = new Uczniowie(
	                        rs.getInt("uczenID"),
	                        rs.getString("imie"),
	                        rs.getString("nazwisko"),
	                        rs.getString("uwagi"),
	                        rs.getInt("klasaID"),
	                        rs.getInt("rokID")
	                );
	                
	                uczniowie.add(u);
	            }
	             
	        } catch (SQLException ex) {
	            //logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        	System.out.println("lol");
	        	ex.printStackTrace();
	        }

	        return uczniowie;
	    }
		
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	}

