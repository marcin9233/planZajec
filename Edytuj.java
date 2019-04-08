package polaczenie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Edytuj {
	public static void wybierz(String imie, String nazwisko, String uwagi, int id)
		    throws SQLException {

		    Statement stmt = null;
		    String update = String.format(			
		      "UPDATE uczniowie SET imie='%s', nazwisko='%s', uwagi='%s' WHERE uczenID = '%d'",imie, nazwisko, uwagi,id);
		    try {
		    	Connection conn = Main.getConnection();
		        stmt = conn.createStatement();
		        stmt.executeUpdate(update);
		            System.out.println(
				"" + imie + " " + nazwisko + " " + uwagi);        
		    }catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
}
