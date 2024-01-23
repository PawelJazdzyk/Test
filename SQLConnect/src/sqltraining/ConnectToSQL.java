package sqltraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectToSQL {

	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dburl = "jdbc:sqlserver://DESKTOP-383CF7Q;databaseName=Poligrafia;integratedSecurity=true;encrypt=true;trustServerCertificate=true;allowMultiQueries=true";
			Connection connection = DriverManager.getConnection(dburl);
			Statement stat = connection.createStatement();
			// String insert = "INSERT INTO User_test(Imie,Nazwisko,Adres,Wiek)
			// VALUES('Kam', 'Sz', 'Ma ,  Warszawa', '41')";

			String query = "SELECT * FROM Lotos";

			// int in = stat.executeUpdate(insert);

			String query_IloscKolumn = "SELECT Count(*) FROM INFORMATION_SCHEMA.Columns where TABLE_NAME = 'Lotos'";
			ResultSet rs_IloscKolumn = stat.executeQuery(query_IloscKolumn);

			Integer iloscKolumn = null;

			while (rs_IloscKolumn.next()) {
				iloscKolumn = rs_IloscKolumn.getInt(1);
			}

			ResultSet rs = stat.executeQuery(query);
			System.out.println(iloscKolumn);
			Integer i = null;
			while (rs.next()) {

				for (i = 2; i <= iloscKolumn; i++) {
					if (i == iloscKolumn) {
						if (rs.getString(i) == null) {
							System.out.println("");
						} else {
							System.out.println(rs.getString(i));
						}
					} else {
						if (rs.getString(i) == null) {
							System.out.print("");
						} else {
							System.out.print(rs.getString(i));
						}
					}
				}
			}

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectToSQL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
