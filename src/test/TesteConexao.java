package test;

import java.sql.Connection;

import org.junit.Test;

import DB.DBConexao;

public class TesteConexao {

	@Test
	public static void main(String[] args) {
		
		Connection conn = DBConexao.connection();
		System.out.println("Conexão realizada com sucesso: " + conn);
	}
}
