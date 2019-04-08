package polaczenie;

import java.sql.*;


public class Dodaj {
	
	
	public static void dodajUcznia(String imie, String nazwisko, 
			String uwagi, String klasa, String rok) throws SQLException {

		    String query = String.format(
				" INSERT INTO uczniowie (imie,nazwisko,uwagi,klasaID,RokID) VALUES('%s', '%s','%s','%s','%s');",
				imie, nazwisko, uwagi, klasa, rok);
				
			Statement stmt = null;
		    try {
		    	
		    	Connection conn = Main.getConnection();
		        stmt = conn.createStatement();
		        stmt.executeUpdate(query);
		        
		      
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}

}
