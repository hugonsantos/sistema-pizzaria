package test;

import java.sql.Connection;

import DB.DBConexao;

public class TesteConexao {

	public static void main(String[] args) {
		
		Connection conn = DBConexao.connection();
		System.out.println("Conex�o realizada com sucesso: " + conn);
	}
}
