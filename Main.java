package polaczenie;

import java.sql.*;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;
import java.io.*;
import java.awt.EventQueue;

public class Main {
	
	//static String userName = "root";
	//static String password = ""; 
	//static String dbms = "mysql";	
	//static String portNumber = "55555";
	//static String connectionProps = "szkola";
	//static String serverName = "127.0.0.1";
	static Connection conn = null;
	
	private static  Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[]args) throws SQLException {
	// dla MySQL connection string 'jdbc:mysql://HOST/DATABASE'
		int numer = 0;
		Main.getConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okieneczko window = new Okieneczko();
					window.frmPlanZajec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		while (numer != 5) {
			System.out.println("Co chcesz zrobic?");
			System.out.println("1. Dodaj");
			System.out.println("2. Zapytaj");
			System.out.println("3. Edytuj");
			System.out.println("4. Usun");
			System.out.println("5. Wyjdz");
			Scanner odczyt = new Scanner(System.in);
			numer = odczyt.nextInt();
			switch (numer) {
			case 1:
				Dodaj dodaj = new Dodaj();
				dodaj.dodajUcznia("wojciech", "kesik", "","1","1995");
				break;
			case 2:
				Zapytaj zapytaj = new Zapytaj();
				zapytaj.viewTable(1);
				break;
			case 3:
				Edytuj edytuj = new Edytuj();
				edytuj.wybierz("Wojtek","Kesik","spi na lekcji",1);
				break;
			case 4:
				Usun usun = new Usun();
				usun.wybierz(1);
				break;
			case 5:
				System.exit(1);
				break;
			}
		}
    }
	
	public static Connection getConnection() throws SQLException {
		Properties ustawienia = new Properties();
		
		ustawienia.setProperty("userName","root");
		ustawienia.setProperty("password","");
		ustawienia.setProperty("dbms", "mysql");
		ustawienia.setProperty("portNumber", "55555");
		ustawienia.setProperty("connectionProps","szkola");
		ustawienia.setProperty("serverName","127.0.0.1");
		
		
		
		try {
			File domyslne = new File("D:\\Eclipse\\polaczenie\\ustawienia.properties");
			if (domyslne.isFile()==false) {
				FileOutputStream out = new FileOutputStream("ustawienia.properties");
				ustawienia.storeToXML(out, null);
				out.close();
			}
			FileInputStream in = new FileInputStream("ustawienia.properties");
			ustawienia.loadFromXML(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conn == null) {
			conn = DriverManager.getConnection("jdbc:" + 
			ustawienia.getProperty("dbms") + "://" + ustawienia.getProperty("serverName") + ":" + 
			ustawienia.getProperty("portNumber") + "/" + ustawienia.getProperty("connectionProps"),"root",""); 
	    }
        logger.error("Entering application.");
       
        logger.trace("Exiting application.");
	    //System.out.println("Connected to database");
	    return conn;
	    
	    
}
}
