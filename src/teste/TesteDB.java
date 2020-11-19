package teste;

import java.sql.Connection;

import DB.DataBaseConnection;

public class TesteDB {

	public static void main(String[] args) {

		Connection con = DataBaseConnection.connection();
		
		System.out.println("Success: " + con);
		
		DataBaseConnection.closeConnection();
	}
}
