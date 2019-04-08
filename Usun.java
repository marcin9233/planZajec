package polaczenie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usun {
	public static void wybierz(int id)
		    throws SQLException {

		    Statement stmt = null;
		    String delete = String.format(			
		      "DELETE FROM uczniowie WHERE uczenID = '%d'",id);
		    try {
		    	Connection conn = Main.getConnection();
		        stmt = conn.createStatement();
		        stmt.executeUpdate(delete);
		        System.out.println("The student was deleted.");        
		    }catch (SQLException e ) {
		    	e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
}
