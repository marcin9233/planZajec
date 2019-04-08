package polaczenie;

import java.sql.*;

public class Zapytaj {
	public static void viewTable(int id)
		    throws SQLException {

		    Statement stmt = null;
		    String query = String.format
		      ("SELECT imie, nazwisko, uwagi FROM uczniowie WHERE uczenID='%d'",id);

		    try {
		    	Connection conn = Main.getConnection();
		        stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	String imie = rs.getString("imie");
			        String nazwisko = rs.getString("nazwisko");
			        String uwagi = rs.getString("uwagi");
			        //System.out.println("Imie: " + imie + "\nNazwisko: " + nazwisko + "\nUwagi: " + uwagi);
			
		        } rs.close();
			         }catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
}
