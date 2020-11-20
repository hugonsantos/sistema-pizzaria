package teste;

import java.sql.Connection;

import DB.DBConexao;

public class TesteDB {

	public static void main(String[] args) {

		Connection con = DBConexao.connection();
		
		System.out.println("Success: " + con);
		
		DBConexao.closeConnection();
	}
}
